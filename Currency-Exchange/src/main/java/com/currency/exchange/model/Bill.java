package com.currency.exchange.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> items;
    private List<String> categories;
    private double totalAmount;
    private UserType userType;
    private int customerTenure; // in years
    private String originalCurrency;
    private String targetCurrency;


}

