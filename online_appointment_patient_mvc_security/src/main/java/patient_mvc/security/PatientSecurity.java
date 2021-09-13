package patient_mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import patient_mvc.service.PatientService;


@EnableWebSecurity
public class PatientSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PatientService patientService;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(patientService);
		     
	}
	
	
	@Bean
	public PasswordEncoder getPassEncoded() { 
		//return new BCryptPasswordEncoder(); 
		return NoOpPasswordEncoder.getInstance();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		.antMatchers("/patient/**").authenticated()
		.antMatchers("/**").permitAll()
		.and()
		.formLogin().loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/patient/processlogin")
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.and()
		.csrf().disable();
	}
	

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers("/","/register","/processregister");
//	}
	
	
	
	
}