package com.cjc.pocPDFgeneratorDemo.Repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.pocPDFgeneratorDemo.model.PDFGApplicant;

public interface PDFGPRepository extends JpaRepository<PDFGApplicant, Integer>{

	PDFGApplicant findByApplicantId(Integer id);
}
