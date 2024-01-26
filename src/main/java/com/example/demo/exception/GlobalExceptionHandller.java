package com.example.demo.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandller {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new LinkedHashMap<>();
		ex.getBindingResult().getAllErrors().forEach(err->{
			String feildName = ((FieldError)err).getField();
			String errorMessage = err.getDefaultMessage();
			errors.put(feildName, errorMessage);
		});
		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<T>
}
