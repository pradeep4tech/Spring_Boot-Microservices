package com.springboot.currencyexchangeservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.currencyexchangeservice.bean.CurrencyExchangeBean;
import com.springboot.currencyexchangeservice.jpa.CurrencyExchangeEntitty;
import com.springboot.currencyexchangeservice.model.CurrencyExchange;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeEntitty currencyExchangeEntitty;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeBean convertCurrency(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange=new CurrencyExchange();
		CurrencyExchange currencyExchangeModel = currencyExchangeEntitty.findByFromAndTo(from, to);
		currencyExchangeModel.setEnvironment(port);
		// return new CurrencyExchangeBean(1000, from, to, BigDecimal.valueOf(65),port);
		CurrencyExchangeBean currencyExchangeBean = new CurrencyExchangeBean();
		BeanUtils.copyProperties(currencyExchangeModel, currencyExchangeBean);
		return currencyExchangeBean;
	}

}
