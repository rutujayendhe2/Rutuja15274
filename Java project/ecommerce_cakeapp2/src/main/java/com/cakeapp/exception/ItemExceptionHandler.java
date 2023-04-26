package com.cakeapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItemExceptionHandler  {

	 @ExceptionHandler(ItemNotFoundException.class)
	    public ResponseEntity<ItemErrorResponse> handleException(ItemNotFoundException ine){
	        ItemErrorResponse errorResponse = new ItemErrorResponse();
	        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	        errorResponse.setMessage(ine.getMessage());
	        errorResponse.setTimeStamp(System.currentTimeMillis());
	        return new ResponseEntity<ItemErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler
	    public ResponseEntity<ItemErrorResponse> handleException(Exception ex){
	        ItemErrorResponse errorResponse = new ItemErrorResponse();
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	        errorResponse.setMessage(ex.getMessage());
	        errorResponse.setTimeStamp(System.currentTimeMillis());
	        return new ResponseEntity<ItemErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	    }
	    
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String,String> MethodArgumentNotFoundException(MethodArgumentNotValidException ex)

	   {
			
			Map<String, String> errorMap = new HashMap<>();
			ex.getBindingResult().getFieldErrors().forEach(error ->{
				errorMap.put(error.getField(), error.getDefaultMessage());
			});
			return errorMap;
		}
	  
}
