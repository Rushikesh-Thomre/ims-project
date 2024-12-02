package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SupplierRepository supplierRepository;

    public void addItems(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return item;
    }

    public void addNewItems(Item item) {
        String supplierId = item.getSupplier().getSupplierId();
        if (supplierRepository.existsById(supplierId)) {
            itemRepository.save(item);
        } else {
            throw new RuntimeException("Supplier does not exist");
        }
    }

    public void deleteItemById(String id) {
        this.itemRepository.deleteById(id);
    }

    public long getTotalItems() {
        return itemRepository.count();
    }

    public int getTotalQuantityOfAllItems() {
        Integer totalQuantity = itemRepository.sumTotalQuantity();
        return totalQuantity != null ? totalQuantity : 0;
    }

    public double getTotalExpenditureForAllItems() {
        List<Item> items = itemRepository.findAll();
        double totalExpenditure = 0.0;

        for (Item item : items) {
            double itemExpenditure = item.getBuyPrice() * item.getQuantity();
            totalExpenditure += itemExpenditure;
        }

        return totalExpenditure;
    }

    public double getTotalRevenue() {
        List<Item> items = itemRepository.findAll();
        double totalRevenue = 0.0;

        for (Item item : items) {
            double itemRevenue = item.getSellPrice() * item.getQuantity();
            totalRevenue += itemRevenue;
        }

        return totalRevenue;
    }

    public double getProjectedIncome() {
        List<Item> items = itemRepository.findAll();
        double totalProjectedIncome = 0.0;

        for (Item item : items) {
            double itemIncome = (item.getSellPrice() * item.getQuantity()) - (item.getBuyPrice() * item.getQuantity());
            totalProjectedIncome += itemIncome;
        }

        return totalProjectedIncome;
    }

    public Item updateStock(String itemId, int quantity, String action) {
        Item item = itemRepository.findById(itemId).orElse(null);
        
        if (item == null) {
            return null;
        }

        if ("in".equalsIgnoreCase(action)) {
            item.setQuantity(item.getQuantity() + quantity);
        } else if ("out".equalsIgnoreCase(action)) {
            if (item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity() - quantity);
            } else {
                return null;
            }
        } else {
            return null;
        }

        return itemRepository.save(item);
    }
}
