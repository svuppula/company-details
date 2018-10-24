package com.sencha.grid.companydetails.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sencha.grid.companydetails.entity.CustomUserDetails;
import com.sencha.grid.companydetails.entity.Users;
import com.sencha.grid.companydetails.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findByName(username);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Use Name Not Found !"));
		return optionalUsers.map(CustomUserDetails::new).get();		 
	}

}
