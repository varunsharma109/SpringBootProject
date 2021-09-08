package online.doctor.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.doctor.appointment.entities.Appointment;
import online.doctor.appointment.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentServ;
	
	@GetMapping("/home")
	public String appointmentHome()
	{
		return "Welcome appointment home";
	}
	
	@PostMapping("/add")
	public String addAppointment(@RequestBody Appointment appointment) {
		return appointmentServ.addAppointment(appointment);
	}
	
	@GetMapping("/{bookId}")
	public Appointment getAppointment(@PathVariable int bookId) {
		return appointmentServ.getAppointment(bookId);
	}
	
	@GetMapping("/doctor/{name}")
	public List<Appointment> getAppointmentsOfDocName(@PathVariable String name){
		return appointmentServ.getAppointmentsByDocName(name, "unknown");
	}
	
	@GetMapping("/patient/{name}")
	public List<Appointment> getAppointmentsOfPatientcName(@PathVariable String name){
		return appointmentServ.getAppointmentsByPatientName(name);
	}
	
	@GetMapping("/payment/{id}")
	public String makePayment(@PathVariable int id) {
		return appointmentServ.makePayment(id);
	}
	
	@GetMapping("/forwardAppointment/{id}")
	public String forwardAppointment(@PathVariable int id) {
		return appointmentServ.forwardAppointment(id);
	}
	
	@GetMapping("/respondAppointment/{id}")
	public String respondAppointment(@PathVariable int id) {
		return appointmentServ.respondAppointment(id);
	}
	
	@GetMapping("/treatAppointment/{id}")
	public String treatAppointment(@PathVariable int id) {
		return appointmentServ.treatAppointment(id);
	}
	
	@GetMapping("/all")
	public List<Appointment> getAllAppointments(){
		return appointmentServ.getAllApppointments();
	}
	
	@GetMapping("/paidAppointment/{id}")
	public String paidAppointment(@PathVariable int id) {
		return appointmentServ.paidAppointment(id);
	}
}
