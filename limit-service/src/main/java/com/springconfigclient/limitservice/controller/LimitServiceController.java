package com.springconfigclient.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springconfigclient.limitservice.bean.LimistServiceBean;
import com.springconfigclient.limitservice.configuration.Configuration;

@RestController
public class LimitServiceController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping(value = "/limit-service")
	public LimistServiceBean getLimitService()
	{
		return new LimistServiceBean(configuration.getMinimum(), configuration.getMaximum());
		
	}
}
