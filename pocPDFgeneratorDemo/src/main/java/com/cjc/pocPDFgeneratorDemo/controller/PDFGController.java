package com.cjc.pocPDFgeneratorDemo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cjc.pocPDFgeneratorDemo.model.PDFGApplicant;
import com.cjc.pocPDFgeneratorDemo.service.PDFGService;
import com.lowagie.text.DocumentException;

@RestController
public class PDFGController {
	@Autowired 
	PDFGService sanctionservice;
	
	@GetMapping("/pdf/{applicantId}") 
	public void exportPdf(HttpServletResponse res,@PathVariable Integer applicantId) throws DocumentException, IOException { 
	 
	res.setContentType("Saction Leter/pdf"); 
	DateFormat date= new SimpleDateFormat("YYYY-MM-DD hh:mm:ss"); 
	String currentDate=date.format(new Date()); 
	 
	    String headerKey = "Content-Disposition"; 
	       String headerValue = "attachment; filename=Sanction_Letter_" + currentDate + ".pdf"; 
	       res.setHeader(headerKey, headerValue); 
	        
	       sanctionservice.pdf(res,applicantId); 
	}

	@RequestMapping(value = "/addapplicant", method = RequestMethod.POST)
	public ResponseEntity<PDFGApplicant> add(@RequestBody PDFGApplicant a)
	{
		PDFGApplicant apl=sanctionservice.adddata(a);
		return new ResponseEntity<PDFGApplicant>(apl,HttpStatus.CREATED);
	}

	
	@RequestMapping(value = "/getapplicant",method = RequestMethod.GET)
	public ResponseEntity<List<PDFGApplicant>> getData()
	{
		List<PDFGApplicant> ap=sanctionservice.getData();
		
		return new ResponseEntity<List<PDFGApplicant>>(ap,HttpStatus.OK);
	}
	

	@GetMapping("/applicant/{applicantId}")
	public ResponseEntity<PDFGApplicant> searcApplicant(@PathVariable Integer applicantId)
	{
		PDFGApplicant p=sanctionservice.searchproduct(applicantId);
		       
		return new ResponseEntity<PDFGApplicant>(p, HttpStatus.OK);
	}
	
	@PatchMapping("/updateapplicant/{applicantId}")
	public ResponseEntity<PDFGApplicant> updateApplicant(@PathVariable Integer applicantId,@RequestBody PDFGApplicant a)
	{
		PDFGApplicant p=sanctionservice.searchproduct(applicantId);
		sanctionservice.adddata(a);
		System.out.println(a);
		       //  int a=10/0;
		return new ResponseEntity<PDFGApplicant>(p, HttpStatus.OK);
	}





@DeleteMapping("/deleteapplicant/{applicantId}")
	public ResponseEntity<List<PDFGApplicant>>  deleteApplicant(@PathVariable Integer applicantId)
	{
	sanctionservice.deletedata(applicantId);
		List<PDFGApplicant> ap=sanctionservice.getData();
		       
		return new ResponseEntity<List<PDFGApplicant>>(ap, HttpStatus.OK);
	}

}
