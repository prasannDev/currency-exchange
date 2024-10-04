package com.currency.exchange.service;

import com.currency.exchange.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${currency.api.key}")
    private String apiKey;

    @Autowired
    ExchangeRepository exchangeRepository;
    public CurrencyService(CurrencyExchangeClient client, DiscountService discountService, ExchangeRepository exchangeRepository) {
        this.currencyExchangeClient = client;
        this.discountService = discountService;
        this.exchangeRepository = exchangeRepository;
    }

    public double calculateFinalAmount(Bill bill) {
        double discountedAmount = discountService.applyDiscounts(bill);
        exchangeRepository.save(bill);
        Map<String, Object> exchangeRates = currencyExchangeClient.getExchangeRates(bill.getOriginalCurrency(), apiKey);
        Map<String, Double> rates = (Map<String, Double>) exchangeRates.get("rates");
        double conversionRate = rates.get(bill.getTargetCurrency());
        return discountedAmount * conversionRate;
    }
}
