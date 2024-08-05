package com.abmpf.abmpf.controller;

import com.abmpf.abmpf.entities.Receipt;
import com.abmpf.abmpf.request.ReceiptRequest;
import com.abmpf.abmpf.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<?> createReceipt(@RequestBody ReceiptRequest receiptRequest) {
        try {
            Receipt receipt = receiptService.createReceipt(receiptRequest);
            return ResponseEntity.ok(receipt);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
