package com.springboot.webservices.restful_web_services.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springboot.webservices.restful_web_services.controller.CustomerDataBean;

@RestController
public class FilterController {

	
	@GetMapping("/customerlist")
	public CustomerDataBean getListOfCustomers() {
		return new CustomerDataBean("pradeep", "8939916522@Prp", "nellore");
	}
	
	//dynamic filterring
	@GetMapping("/customerdynamicfilter")
	public MappingJacksonValue getListOfcusomerDetails()
	{
		CustomerDataBean customerDataBean=	new CustomerDataBean("pradeep", "8939916522@Prp", "nellore");
		SimpleBeanPropertyFilter simpleBeanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("name","address");
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("CustomerDataBeanFilter", simpleBeanPropertyFilter); 
		MappingJacksonValue mappping=new MappingJacksonValue(customerDataBean);
		mappping.setFilters(filterProvider);
		return mappping;
	}
}
