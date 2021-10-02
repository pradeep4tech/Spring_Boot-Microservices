package com.springboot.currencyexchangeservice.bean;

import java.math.BigDecimal;

public class CurrencyExchangeBean {

	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;

	public CurrencyExchangeBean(int id, String from, String to, BigDecimal conversionMultiple,String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
	}

	
	public CurrencyExchangeBean() {
		// TODO Auto-generated constructor stub
	}


	public String getEnvironment() {
		return environment;
	}


	public void setEnvironment(String environment) {
		this.environment = environment;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

}
