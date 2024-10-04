package com.currency.exchange.service;

import com.currency.exchange.client.CurrencyExchangeClient;
import com.currency.exchange.model.Bill;
import com.currency.exchange.model.UserType;
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

    @BeforeEach
    void setUp() {
        client = Mockito.mock(CurrencyExchangeClient.class);  // Mock client
        discountService = Mockito.mock(DiscountService.class);  // Mock discount service
        currencyService = new CurrencyService(client, discountService);  // Inject mocks into the service
    }



    @Test
    void calculateFinalAmount() {
        // Setup: Creating a bill for an employee with USD to EUR conversion
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


/**
 * Test Report
 *
 *
 Test Case              | Description	                                        |Expected Outcome	    |Actual Outcome	        |Status
 calculateFinalAmount()	| Verifies discount application and currency conversion	|Final amount = ₹59.5	|Final amount = ₹59.5	|Pass
 ..................................
 sampling ...
 include patterns:
 com\.currency\.exchange\.service\..*
 exclude patterns:
 rate== {INR=0.85}
 rate== INR
 Class transformation time: 0.03921621s for 2774 classes or 1.4137062004325884E-5s per class

 Process finished with exit code 0



 */
