package com.app.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<String> handleStudnetNotFoundException(StudentNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = FeignException.NotFound.class)
	public ResponseEntity<String> handleFeignNotFoundException(FeignException.NotFound e) {
		return new ResponseEntity<String>(e.contentUTF8(), HttpStatus.valueOf(e.status()));
	}
	
	
	@ExceptionHandler(value = FeignException.class)
	public ResponseEntity<String> handleFeignException(FeignException.NotFound e) {
		return new ResponseEntity<String>("Somthing went wrong....", HttpStatus.valueOf(e.status()));
	}
}
