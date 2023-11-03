package com.cjc.pocPDFgeneratorDemo.CustomException;





import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AllErrorCode {
	private HttpStatus errormsg;
	private Date date;
	private String customMsg;
	private int statusCode;
	private String path;
	
	

}
