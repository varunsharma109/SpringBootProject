package binod.suman.Admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
public class adminSecurity extends WebSecurityConfigurerAdapter{


	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
				.withUser("admin@gmail.com")
				.password("$2a$12$rutqc88b5H6DqGCrpVZJVeNIoRXA33/K8zX6Ougx3q9as5NvXDiyG")
				.roles("USER");		
	}
	
	
	private void roles(String string) {
		// TODO Auto-generated method stub
		
	}


	private void password(String string) {
		// TODO Auto-generated method stub
		
	}


	@Bean
	public PasswordEncoder getPassEncoded() { 
		return new BCryptPasswordEncoder(); 
	}
}
