package com.uok.oop.ims.controller;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.service.ItemService;
import com.uok.oop.ims.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/item-qr-code/{id}")
    public ResponseEntity<byte[]> getQRCode(@PathVariable String id) {
        Item item = itemService.getItemById(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] qrCode = qrCodeService.generateQRCode(item, 300, 300);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + item.getItemName() + "-qr.png\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(qrCode);
    }
}

