package com.cjc.pocPDFgeneratorDemo.CustomException;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ApplicantNotFound.class)
	public ResponseEntity<AllErrorCode> applicantNotFound(ApplicantNotFound app,HttpServletRequest request)
	{
		AllErrorCode error=new AllErrorCode(HttpStatus.NOT_FOUND, new Date(), app.getMessage(),HttpStatus.NOT_FOUND.value(),request.getRequestURI());
		return new ResponseEntity<AllErrorCode>(error,HttpStatus.NOT_FOUND);
		
	}
	//app.getMessage(),HttpStatus.NOT_FOUND.value());
	
}
