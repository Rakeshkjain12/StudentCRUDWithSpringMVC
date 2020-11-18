package com.rakesh.studentcrud.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rakesh.studentcrud.model.Student;
import com.rakesh.studentcrud.service.ReportService;
import com.rakesh.studentcrud.service.StudentService;
import com.rakesh.studentcrud.utility.FileUploadUtility;

import net.sf.jasperreports.engine.JRException;

@Controller
public class PageController {
    
	@Autowired
	public StudentService studentService;
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	
	
	
	@RequestMapping(value= {"/","/index","/home"})
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("page");
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method -DEBUG");
		mv.addObject("ClickOnUserLogin", true);
		mv.addObject("title", "Home");
		return mv;
	}
	
	@RequestMapping(value= "/add")
	public ModelAndView add() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Add Student");
		mv.addObject("ClickOnaddStudent", true);
		mv.addObject("student", new Student());
		return mv;
	}
	
	@RequestMapping(value= "/save")
	public String saveStudent(@ModelAttribute("student") Student student,Model model, HttpServletRequest request) {
		if(student.getId()==0) {
		studentService.add(student);
		    if(!student.getFile().getOriginalFilename().equals("")) {
		    	FileUploadUtility.uploadFile(request, student.getFile(), student.getId());
		    }
		}else {
			studentService.update(student);
		}
		return "redirect:/add";
	}
	
	@RequestMapping(value= "/getall")
	public ModelAndView getall() {
		ModelAndView mv=new ModelAndView("page");
		List<Student> listStudents=studentService.getAllStudent();
		mv.addObject("listStudents", listStudents);
		mv.addObject("title", "All Student");
		mv.addObject("ClickOnAllStudent", true);
		return mv;
	}
	
	@RequestMapping(value= "/search")
	public ModelAndView get() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "SEARCH Student");
		mv.addObject("ClickOnsearchStudent", true);
		return mv;
	}
	
	@RequestMapping(value= "/searchStudent")
	public ModelAndView search(@RequestParam("keyword") Object keyword) {
		ModelAndView mv=new ModelAndView("page");
		List listStudent=studentService.getStudentByProperty(keyword);
		mv.addObject("title", "SEARCH Student");
		mv.addObject("ClickOnsearchStudent", true);
		mv.addObject("listStudent", listStudent);
		return mv;
	}
	
	@RequestMapping(value= "/delete")
	public String deleteStudent(HttpServletRequest req) {
		int sid=Integer.parseInt(req.getParameter("id"));
		studentService.delete(sid);
		return "redirect:/getall";
	}
	
	@RequestMapping(value= "/update")
	public ModelAndView updateStudent(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("ClickOnaddStudent", true);
		mv.addObject("title", "Edit Student");
		int sid=Integer.parseInt(req.getParameter("id"));
        Student s=studentService.getStudent(sid);
        System.out.println(req.getParameter("id"));
        mv.addObject("student", s);
		return mv;
	}
	
	@RequestMapping(value= "/singleStudent/{id}")
	public ModelAndView singleStudent(@PathVariable("id") Integer id) {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "View Student");
		mv.addObject("ClickOnSingleStudent", true);
		Student s=studentService.getStudent(id);
		mv.addObject("student", s);
		return mv;
	}
	
	//-----------------------------------------------------------

	
	
}
