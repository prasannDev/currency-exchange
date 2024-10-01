package com.currency.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.currency.exchange.client.CurrencyExchangeClient;
import com.currency.exchange.model.Bill;

import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyExchangeClient currencyExchangeClient;

    @Autowired
    private DiscountService discountService;

    private String apiKey = "24f5a1263171e37321d1f133";

    public double calculateFinalAmount(Bill bill) {
            System.out.println("runnnnnnn................................");
        double discountedAmount = discountService.applyDiscounts(bill);

    
        Map<String, Object> exchangeRates = currencyExchangeClient.getExchangeRates(bill.getOriginalCurrency(), apiKey);
        @SuppressWarnings("unchecked")
        Map<String, Double> rates = (Map<String, Double>) exchangeRates.get("rates");
        double conversionRate = rates.get(bill.getTargetCurrency());

        return discountedAmount * conversionRate;
    }
}
