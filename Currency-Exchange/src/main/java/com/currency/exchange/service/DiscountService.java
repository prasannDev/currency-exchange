package com.currency.exchange.service;
import org.springframework.stereotype.Service;
import com.currency.exchange.model.Bill;
import com.currency.exchange.model.UserType;

@Service
public class DiscountService {

    public double applyDiscounts(Bill bill) {
        double discount = 0;
            System.out.println("bill category : "+bill.getCategories());
            System.out.println("bill user type : "+bill.getUserType());
        // Apply percentage-based discount
        if (!bill.getCategories().contains("GROCERIES")) {
            if (bill.getUserType() == UserType.EMPLOYEE) {
                System.out.println("Employeeeeeee");
                discount = 0.30;
            } else if (bill.getUserType() == UserType.AFFILIATE) {
                discount = 0.10;
            } else if (bill.getCustomerTenure() > 2) {
                System.out.println("Employeeeeeee");
                discount = 0.05;
            }
        }
        System.out.println("discount :............"+discount);
        // Flat discount for every $100
        double flatDiscount = (int) (bill.getTotalAmount() / 100) * 5;
        return (bill.getTotalAmount() - bill.getTotalAmount() * discount - flatDiscount);
       
    }
}
