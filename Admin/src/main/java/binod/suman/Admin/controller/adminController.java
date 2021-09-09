package binod.suman.Admin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
@RequestMapping("/")
public class adminController {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	static final String URL="http://localhost:8085/";
	
	
	@GetMapping("/")
	public String loginProcess(Model model)
	{
		List<Appointment> list = restTemplate.getForObject(URL+"appointment/all",List.class, HttpMethod.GET);
		model.addAttribute("list", list);
		return "adminWelcome";
	}
	
	@GetMapping("/admin/changestatus/{bookId}")
	public String changeStatus(@PathVariable("bookId") int bookId,Model model)
	{
		String postForObject1 = restTemplate.getForObject(URL+"appointment/payment/"+bookId, String.class);
		String postForObject2 = restTemplate.getForObject(URL+"appointment/forwardAppointment/"+bookId, String.class);
		List<Appointment> list = restTemplate.getForObject(URL+"appointment/all",List.class, HttpMethod.GET);
		System.out.println(list);
		
		model.addAttribute("list", list);
		 return "adminWelcome";
	}
}
