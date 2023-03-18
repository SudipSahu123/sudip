package com.lcwd.user.service.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payLoad.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFountException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFountException ex){
		String message = ex.getMessage();
		ApiResponse response =	ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	//ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	
	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
