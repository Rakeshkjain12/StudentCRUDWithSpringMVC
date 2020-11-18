package com.rakesh.studentcrud.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rakesh.studentcrud.model.Student;
import com.rakesh.studentcrud.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	

	
	@GetMapping(value= "/report")
    public void generateReport(HttpServletResponse response) throws JRException, IOException {

		reportService.expertReport(response);
    }	
	
	@GetMapping("/singleReport/{id}")
	  public void handleForexRequest(@PathVariable("id") Integer id,HttpServletResponse response) throws JRException, IOException {
		
		reportService.exportStudentReport(response, id);
		
	  }
	


	}
