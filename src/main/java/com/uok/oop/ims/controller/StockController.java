package com.uok.oop.ims.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uok.oop.ims.model.Item; // Ensure you import your entity class, not AcroFields.Item
import com.uok.oop.ims.repository.ItemRepository;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private ItemRepository itemRepository;

    
    @GetMapping
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateStock(@PathVariable Long id, @RequestBody StockUpdateRequest request) {    
        Optional<Item> optionalItem = itemRepository.findById("123"); 
        if (!optionalItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Item item = optionalItem.get();
        item.setQuantity(item.getQuantity() + request.getQuantity());
        itemRepository.save(item);
        return ResponseEntity.ok(item);
    }
    public static class StockUpdateRequest {
        private int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
