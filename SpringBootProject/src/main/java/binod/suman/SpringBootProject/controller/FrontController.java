package binod.suman.SpringBootProject.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import binod.suman.SpringBootProject.dao.HospitalDAO;
import binod.suman.SpringBootProject.entity.Patient;

public class FrontController {

	@Autowired
	HospitalDAO dao;
	
	
	@RequestMapping(value="/patientform")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("patientform");
	}
	
	//@RequestMapping("/viewstudent")  
   // public String viewemp(Model m){  
        //List<Student> list=dao.getAllStudents();  
        //m.addAttribute("list",list);
        //System.out.println("Number of Record :"+list.size());
        //return "viewstudent";  
    //} 
	

	
}
