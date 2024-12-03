package com.uok.oop.ims.controller;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebCamController {

    @Autowired
    private ItemService itemService; 

    @GetMapping("/webcam")
    public String webcam() {
        return "WebCam"; 
    }

    @PostMapping("/webcam/scanQRCode")
    @ResponseBody
    public String handleQRCode(@RequestBody String qrData) {
        try {
            Item item = itemService.getItemById(qrData);

            return "{\"message\": \"Item found successfully\", \"item\": " + itemToJson(item) + "}";
        } catch (RuntimeException e) {
            return "{\"message\": \"Item not found for QR Code: " + qrData + "\"}";
        }
    }

    private String itemToJson(Item item) {
        return "{"
                + "\"itemId\": \"" + item.getItemId() + "\","
                + "\"itemName\": \"" + item.getItemName() + "\","
                + "\"description\": \"" + item.getDescription() + "\","
                + "\"buyPrice\": " + item.getBuyPrice() + ","
                + "\"sellPrice\": " + item.getSellPrice() + ","
                + "\"quantity\": " + item.getQuantity() + ","
                + "\"imageUrl\": \"" + item.getImageUrl() + "\","
                + "\"supplier\": \"" + (item.getSupplier() != null ? item.getSupplier().getSupplierId() : "Unknown") + "\""
                + "}";
    }
}
