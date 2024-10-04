package com.currency.exchange.service;

import com.currency.exchange.client.CurrencyExchangeClient;
import com.currency.exchange.model.Bill;
import com.currency.exchange.model.UserType;
import com.currency.exchange.repository.ExchangeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;


class CurrencyServiceTest {
    @Value("${currency.api.key}")
    private String apiKey;
    private CurrencyExchangeClient client;  // Declare client mock
    private DiscountService discountService;  // Declare discount service mock
    private CurrencyService currencyService;  // Declare the service being tested
    private ExchangeRepository exchangeRepository;
    @BeforeEach
    void setUp() {
        client = Mockito.mock(CurrencyExchangeClient.class);  // Mock client
        discountService = Mockito.mock(DiscountService.class);  // Mock discount service
        exchangeRepository = Mockito.mock(ExchangeRepository.class);  // Mock discount service
        currencyService = new CurrencyService(client, discountService,exchangeRepository);  // Inject mocks into the service
    }



    @Test
    void calculateFinalAmount() {
        List<String> listCategories=new ArrayList<>();
        List<String> listItems=new ArrayList<>();
        listCategories.add("ELECTRONICS");
        listItems.add("TV");
        Bill bill = new Bill();
        bill.setId(1L);
        bill.setCustomerTenure(3);
        bill.setItems(listItems);
        bill.setTotalAmount(100);
        bill.setCategories(listCategories);
        bill.setUserType(UserType.EMPLOYEE);
        bill.setTargetCurrency("INR");
        bill.setOriginalCurrency("USD");


       Mockito.when(client.getExchangeRates("USD", apiKey)).thenReturn(Map.of("rates", Map.of("INR", 0.85)));

        Mockito.when(discountService.applyDiscounts(Mockito.any(Bill.class))).thenReturn(70.0);  // 30% discount applied

            double result = currencyService.calculateFinalAmount(bill);

        assertEquals(70 * 0.85, result, 0.01);
    }

}
