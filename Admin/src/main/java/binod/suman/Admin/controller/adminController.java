package binod.suman.Admin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import binod.suman.Admin.entity.Appointment;


@Controller
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private RestTemplate restTemplate;
	
	static final String URL="http://localhost:8085/";
	
	@RequestMapping("/")
	public String home() {
		return "This is my admin page";
	}
	
	@PostMapping("/processlogin")
	public String loginProcess(@RequestParam("email") String email,@RequestParam("password") String password,Model model)
	{
		if("admin@123".equals(password) && "admin@gmail.com".equals(email))
		{
			List<Appointment> list = restTemplate.getForObject(URL+"appointment/all",List.class, HttpMethod.GET);
			System.out.println(list);
			model.addAttribute("list", list);
			return "adminWelcome";
			
		}else{
				return "index";
		}
	}
	
	@GetMapping("/changestatus/{bookId}")
	public String changeStatus(@PathVariable("bookId") int bookId,Model model)
	{
		String postForObject = restTemplate.getForObject(URL+"appointment/paidAppointment/"+bookId, String.class);
		System.out.println(postForObject);
		List<Appointment> list = restTemplate.getForObject(URL+"appointment/all",List.class, HttpMethod.GET);
		System.out.println(list);
		
		model.addAttribute("list", list);
		 return "adminWelcome";
	}
}
