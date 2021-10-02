package com.springboot.currencyexchangeservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.currencyexchangeservice.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeEntitty extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}
