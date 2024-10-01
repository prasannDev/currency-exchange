package com.currency.exchange.service;
import com.currency.exchange.client.CurrencyExchangeClient;
import com.currency.exchange.model.Bill;
import com.currency.exchange.model.UserType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

class CurrencyServiceTest {

    private final CurrencyExchangeClient client = Mockito.mock(CurrencyExchangeClient.class);
    private final DiscountService discountService = new DiscountService();
    private final CurrencyService currencyService = new CurrencyService(client, discountService);

    @Test
    void calculateFinalAmount() {
        Bill bill = new Bill();
        bill.setTotalAmount(100);
        bill.setUserType(UserType.EMPLOYEE);
        bill.setOriginalCurrency("USD");
        bill.setTargetCurrency("EUR");

        Map<String, Object> ratesResponse = new HashMap<>();
        Map<String, Double> rates = new HashMap<>();
        rates.put("EUR", 0.85);
        ratesResponse.put("rates", rates);

        Mockito.when(client.getExchangeRates("USD", "your-api-key")).thenReturn(ratesResponse);

        double result = currencyService.calculateFinalAmount(bill);
        assertEquals(59.5 * 0.85, result); // Expected value based on the logic
    }
}
