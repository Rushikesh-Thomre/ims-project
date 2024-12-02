package com.uok.oop.ims.service;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.uok.oop.ims.model.Item;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeService {

    public byte[] generateQRCode(Item item, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            String qrData = String.format(
                "Item ID: %s\nName: %s\nSupplier: %s\nDescription: %s\nSell Price: %.2f\nQuantity: %d",
                item.getItemId(),
                item.getItemName(),
                item.getSupplier() != null ? item.getSupplier().getSupplierName() : "N/A",
                item.getDescription(),
                item.getSellPrice(),
                item.getQuantity()
            );

            Map<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix bitMatrix = qrCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, width, height, hints);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

