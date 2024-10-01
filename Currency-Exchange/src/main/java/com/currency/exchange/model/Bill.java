package com.currency.exchange.model;



import java.util.List;

public class Bill {
    private List<String> items;
    private List<String> categories;
    private double totalAmount;
    private UserType userType;
    private int customerTenure; // in years
    private String originalCurrency;
    private String targetCurrency;
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    public int getCustomerTenure() {
        return customerTenure;
    }
    public void setCustomerTenure(int customerTenure) {
        this.customerTenure = customerTenure;
    }
    public String getOriginalCurrency() {
        return originalCurrency;
    }
    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }
    public String getTargetCurrency() {
        return targetCurrency;
    }
    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

   
}

