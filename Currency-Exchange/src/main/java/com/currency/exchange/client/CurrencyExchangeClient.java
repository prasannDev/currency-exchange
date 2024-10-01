package com.currency.exchange.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "currency-exchange", url = "https://open.er-api.com/v6/latest")
public interface CurrencyExchangeClient {
    @GetMapping("/{base_currency}?apikey={apiKey}")
    Map<String, Object> getExchangeRates(@PathVariable("base_currency") String baseCurrency,
                                         @PathVariable("apiKey") String apiKey);
}