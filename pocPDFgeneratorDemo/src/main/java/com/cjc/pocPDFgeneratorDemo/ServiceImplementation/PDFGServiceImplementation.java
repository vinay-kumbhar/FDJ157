package com.cjc.pocPDFgeneratorDemo.ServiceImplementation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.pocPDFgeneratorDemo.CustomException.ApplicantNotFound;
import com.cjc.pocPDFgeneratorDemo.Repositorty.PDFGPRepository;
import com.cjc.pocPDFgeneratorDemo.model.PDFGApplicant;
import com.cjc.pocPDFgeneratorDemo.service.PDFGService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PDFGServiceImplementation implements PDFGService{ 

		@Autowired 
		PDFGPRepository aprepo;
		
		@Override
		public void pdf(HttpServletResponse response,Integer apId){
			
	 
			Optional<PDFGApplicant> ap= aprepo.findById(apId);
			PDFGApplicant a=ap.get();
			
					a.getApplicantName();
				
					
			
			
					DateFormat date= new SimpleDateFormat("dd-MM-yyyy");
					String currentDate=date.format(new Date());
			
			
			
			Document doc=new Document(PageSize.A4);
			try {
				PdfWriter.getInstance(doc, response.getOutputStream());
			} catch (DocumentException | IOException e) {
				
				e.printStackTrace();
			}
			doc.open();
			Font fontTitle=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTitle.setSize(18);
			
			Paragraph p=new Paragraph("Sacntion Letter",fontTitle);
			p.setAlignment(p.ALIGN_CENTER);
			Paragraph p20= new Paragraph("   \r\n");
			Paragraph p21= new Paragraph("   \r\n");
			
			Font fontpara=FontFactory.getFont(FontFactory.TIMES_ROMAN);
			fontpara.setSize(10);
//			Paragraph p3=new Paragraph("date"+currentDate);
//			p.setAlignment(p3.ALIGN_RIGHT);
//			
			
			
			Paragraph p1=new Paragraph("Dear Applicant "+a.getApplicantName()+","+"\n with reference to your Application,We are pleased to inform you that the loan has been sanctioned. "+"\r\n"
			+"The Sanction Letter and related documents have been forwarded to 'ACCOUNT MANAGER'\n"
			+ "\n"
			+ "please visit Institute eith original document and do KYC and after that disbursment proocess will continue...\n"
			+ "\n"
			+ "Loan Details\n"
			+" applicant name   :   "+ a.getApplicantName()+"\r\n");
			p1.setAlignment(p1.ALIGN_LEFT);
			
			Paragraph p5= new Paragraph("  ");
			Paragraph p6= new Paragraph("  ");
			Paragraph p7= new Paragraph("  ");
			Paragraph p8= new Paragraph("  ");
			Paragraph p9= new Paragraph("  ");
			Paragraph p10= new Paragraph("  ");
			Paragraph p11= new Paragraph("  ");
			Paragraph p12= new Paragraph("  ");
			
			Paragraph p2=new Paragraph("manager");
			p2.setAlignment(p2.ALIGN_RIGHT);
			
			doc.add(p);
			doc.add(p1);
			doc.add(p2);
			doc.close();
		}
		
		
		@Override
		public void approvedSansaction(Integer applicantId) 
		{
		Optional <PDFGApplicant> app=aprepo.findById(applicantId);
		PDFGApplicant ap=app.get();
			aprepo.save(ap);	
		}

	      @Override
	     public void notApprovedSansaction(Integer applicantId) {
		
		Optional <PDFGApplicant> app=aprepo.findById(applicantId);
		PDFGApplicant ap=app.get();
		
	
		aprepo.save(ap);
	}
	      
	      Random random=new Random();

	      @Override
	  	public void randomNumber(Integer applicantId)
	  	{
	  		Optional <PDFGApplicant> app=aprepo.findById(applicantId);
	  		PDFGApplicant ap=app.get();
	  		
	  		Integer no=random.nextInt(30);
	  		if(no>20)
	  		{
	  				
	  				aprepo.save(ap);
	  		}
	  		else
	  		{
	  			
	  			aprepo.save(ap);
	  		}
	  	}

		
	      @Override
	  	public PDFGApplicant adddata(PDFGApplicant a) {
	  	return	aprepo.save(a);
	  		
	  		
	  	}

	  	@Override
	  	public List<PDFGApplicant> getData() {
	  		
	  		return aprepo.findAll();
	  		
	  	}

	  	@Override
	  	public PDFGApplicant searchproduct(Integer applicantId)  {
	  		
	  		PDFGApplicant ap=	aprepo.findByApplicantId(applicantId);
	  	if(ap!=null)
	  	{
	  		return ap;	
	  	}
	  	else
	  	{
	  		throw new ApplicantNotFound("This Id is not available !");
	  	}
	  		
	  	}
	  	
	  	@Override
		public void deletedata(Integer applicantId) {
	  		aprepo.deleteById(applicantId);
			
		}

	
}
