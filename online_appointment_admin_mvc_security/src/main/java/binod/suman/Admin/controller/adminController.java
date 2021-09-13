package binod.suman.Admin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import binod.suman.Admin.entity.Appointment;
import binod.suman.Admin.entity.Doctor;
import binod.suman.Admin.entity.Patient;


@Controller

public class adminController {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
//	static final String URL="http://localhost:8085/";
	static final String URL="http://RESTAPI-SERVER/";
	
	@GetMapping("/")
	public String welcomeHome()
	{
		return "home";
	}
	
	@GetMapping("/admin")
	public String loginProcess(Model model)
	{
		List<Appointment> list = restTemplate.getForObject(URL+"appointment/all",List.class, HttpMethod.GET);
		model.addAttribute("list", list);
		return "adminWelcome";
	}
	
	@GetMapping("/admin/changestatus/{bookId}")
	public String changeStatus(@PathVariable("bookId") int bookId,Model model)
	{
		String postForObject1 =  restTemplate.getForObject(URL+"appointment/payment/"+bookId, String.class);
		String postForObject2 =  restTemplate.getForObject(URL+"appointment/forwardAppointment/"+bookId, String.class);
		 return "redirect:/admin";
	}
	
	@GetMapping("/admin/delete/{bookId}")
	public String Delete(@PathVariable("bookId") int bookId,Model model)
	{
		String forObject = restTemplate.getForObject(URL+"appointment/delete/"+bookId,String.class);
		System.out.println(forObject);
		
		return "redirect:/admin";
	}
	
	
	
	@GetMapping("/admin/doctors")
	public String showAllDoctor(Model model)
	{
		List<Doctor> list = restTemplate.getForObject(URL+"doctor/all",List.class, HttpMethod.GET);
		model.addAttribute("list",list);
		return "alldoctors";
	}
	
	@GetMapping("/admin/deletedoctor/{email}")
	public String deleteDoctor(@PathVariable String email,Model model)
	{
		String forObject = restTemplate.getForObject(URL+"doctor/delete/"+email,String.class);
		System.out.println(forObject);
		return "redirect:/admin/doctors";
	}
	
	@GetMapping("/admin/patients")
	public String showAllPatient(Model model)
	{
		List<Patient> list = restTemplate.getForObject(URL+"patient/all",List.class, HttpMethod.GET);
		model.addAttribute("list",list);
		return "allpatients";
	}
	
	
	@GetMapping("/admin/deletepatient/{email}")
	public String deletePatient(@PathVariable String email,Model model)
	{
		String forObject = restTemplate.getForObject(URL+"patient/delete/"+email,String.class);
		System.out.println(forObject);
		return "redirect:/admin/patients";
	}
}
