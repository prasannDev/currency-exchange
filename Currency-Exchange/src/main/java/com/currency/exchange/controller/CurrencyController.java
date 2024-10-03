package com.currency.exchange.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.currency.exchange.model.Bill;
import com.currency.exchange.service.CurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/calculate")
        public ResponseEntity<Double> calculatePayableAmount(@RequestBody Bill bill) {
        double finalAmount = currencyService.calculateFinalAmount(bill);

        return ResponseEntity.ok(finalAmount);
    }
}

