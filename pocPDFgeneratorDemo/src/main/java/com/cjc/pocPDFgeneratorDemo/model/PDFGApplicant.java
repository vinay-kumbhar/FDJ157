package com.cjc.pocPDFgeneratorDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PDFGApplicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer applicantId;
	private String applicantName;
	private String applicantEmail;
	private long applicantMobile;
	private String applicantPassword;
}
