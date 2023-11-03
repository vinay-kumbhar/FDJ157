package com.cjc.pocPDFgeneratorDemo.CustomException;


public class ApplicantNotFound extends RuntimeException {
	public ApplicantNotFound(String message) {
		super(message);
	}

}
