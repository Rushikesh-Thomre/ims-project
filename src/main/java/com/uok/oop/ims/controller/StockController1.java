package com.uok.oop.ims.controller;



import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController1 {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<Object> updateStock(@PathVariable String itemId,
                                              @RequestParam int quantity,
                                              @RequestParam String action) {
        Item updatedItem = itemService.updateStock(itemId, quantity, action);
        
        if (updatedItem == null) {
            return ResponseEntity.status(400).body("Failed to update stock: Invalid item, action, or insufficient stock.");
        }
        
        return ResponseEntity.ok(updatedItem);  
    }
}
