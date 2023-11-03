package com.cjc.pocPDFgeneratorDemo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cjc.pocPDFgeneratorDemo.model.PDFGApplicant;

public interface PDFGService {

		public void pdf(HttpServletResponse response,Integer apId);
		
		public void approvedSansaction(Integer applicantId);
		public void notApprovedSansaction(Integer applicantId);


		public void randomNumber(Integer applicantId);

		public void deletedata(Integer applicantId);

		public PDFGApplicant adddata(PDFGApplicant a);

		public PDFGApplicant searchproduct(Integer applicantId);

		public List<PDFGApplicant> getData();



}
