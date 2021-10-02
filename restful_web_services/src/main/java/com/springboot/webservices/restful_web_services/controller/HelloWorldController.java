package com.springboot.webservices.restful_web_services.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservices.restful_web_services.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(value = "hellow")
	public String hellow()
	{
		return "hellowworld";
	}
	
	@GetMapping("hellow-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hai Hellow");
	}
	
	@GetMapping("hellow-bean1/{name}")
	public HelloWorldBean helloWorldpathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hai Hellow , %s",name));
	}
	@GetMapping("/hellow-internailazation")
	public String restInsternailazation()
	{
		return messageSource.getMessage("message.hello", null, LocaleContextHolder.getLocale());
	}
	
	
}
