package com.springboot.webservices.restful_web_services;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public AcceptHeaderLocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver=new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
		return acceptHeaderLocaleResolver;
	}
	
}


