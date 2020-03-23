package com.example.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailsService implements UserDetailsService{
	 
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		System.out.println("The User Name is "+ phoneNumber+ " The password is ");
		User user = userRepository.findByPhoneNumber(phoneNumber);
				 
		 	if(user==null) {
				System.out.println("I got here ");

			    throw new UsernameNotFoundException("User 404");
		 	}else {
		 		System.out.println("WE Get am");
			    return new UserPrincipalDetails (user);
		 	}
		}
	}

