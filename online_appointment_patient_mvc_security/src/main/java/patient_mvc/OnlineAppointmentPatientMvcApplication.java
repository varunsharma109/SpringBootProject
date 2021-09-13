package patient_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineAppointmentPatientMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAppointmentPatientMvcApplication.class, args);
	}

}
