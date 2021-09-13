package patient_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import patient_mvc.dao.PatientDao;
import patient_mvc.entity.PatientEntity;

@Service
public class PatientService implements UserDetailsService{
	@Autowired
	private PatientDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Hi");
		PatientEntity user = dao.findById(username).get();
		 System.out.println(user);
		 System.out.println("User in Service Layer :"+user);
			if(user == null) {
				throw new UsernameNotFoundException("This user does not exist");
			}
			return user;
	}

}
