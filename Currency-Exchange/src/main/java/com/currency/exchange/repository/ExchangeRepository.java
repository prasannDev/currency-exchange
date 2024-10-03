package com.currency.exchange.repository;

import com.currency.exchange.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Bill,Long> {
}
