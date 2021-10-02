package com.springboot.webservices.restful_web_services.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.springboot.webservices.restful_web_services")
@RestController
public class CustomResponseEntittyExceptionhandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
		System.out.println("Inside the exception");
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(ex.getBindingResult().toString(), "Validation failed",
				new Date());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

	}

}
