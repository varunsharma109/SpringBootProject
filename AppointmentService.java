package online.doctor.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import online.doctor.appointment.dao.AppointmentRepository;
import online.doctor.appointment.entities.Appointment;

@Service
public class AppointmentService{

	@Autowired
	private AppointmentRepository appointmentRep;
	
	public String addAppointment(Appointment appointment) {
		appointmentRep.save(appointment);
		return "New appointment is booked for "+appointment.getPatientName()+" with doctor "+appointment.getDoctorName();
	}

	public Appointment getAppointment(int bookId) {
		return appointmentRep.findById(bookId).get();
	};
	
	public List<Appointment> getAppointmentsByDocName(String docName, String status){
		return appointmentRep.findByDoctorName(docName, status);
	};
	
	public List<Appointment> getAppointmentsByPatientName(String patientName){
		return appointmentRep.findByPatientName(patientName);
	}

	public String makePayment(int id) {
		Appointment a = appointmentRep.findById(id).get();
		a.setPayment("paid");
		appointmentRep.save(a);
		return "Payment Successful";
	}

	public String forwardAppointment(int id) {
		Appointment a = appointmentRep.findById(id).get();
		a.setStatus("requested");
		appointmentRep.save(a);
		return "Status is Set to requested";
	}

	public String respondAppointment(int id) {
		Appointment a = appointmentRep.findById(id).get();
		a.setStatus("responded");
		appointmentRep.save(a);
		return "Status is Set to responded";
	}

	public String treatAppointment(int id) {
		Appointment a = appointmentRep.findById(id).get();
		a.setStatus("treated");
		appointmentRep.save(a);
		return "Status is Set to treated";
	}
	
	public List<Appointment> getAllApppointments(){
		return appointmentRep.findAll();
	}
	
	public String paidAppointment(int id) {
		Appointment a = appointmentRep.findById(id).get();
		a.setStatus("Paid");
		appointmentRep.save(a);
		return "Payment is Set to paid";
	}
}
