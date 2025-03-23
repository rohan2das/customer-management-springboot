package com.test.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> productNotFoundException(ResourceNotFoundException pnfe, WebRequest request){
		
		ErrorMessage msgData = new ErrorMessage();
		int statusCode = HttpStatus.NOT_FOUND.value();
		
		String desc = request.getDescription(false);
		
		msgData.setTimeStamp(new Date());
		msgData.setMessage(pnfe.getMessage());
		msgData.setUrl(desc);
		msgData.setStatusCode(statusCode);
		
		return new ResponseEntity<ErrorMessage>(msgData, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> unknownExceptions(Exception e, WebRequest request){
		ErrorMessage msgData = new ErrorMessage();
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String url = request.getDescription(false);
		

		msgData.setTimeStamp(new Date());
		msgData.setMessage(e.getMessage());
		msgData.setUrl(url);
		msgData.setStatusCode(statusCode);
		
		return new ResponseEntity<ErrorMessage>(msgData, HttpStatus.BAD_REQUEST);
		
	}
}
