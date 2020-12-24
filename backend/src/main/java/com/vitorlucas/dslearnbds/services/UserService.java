package com.vitorlucas.dslearnbds.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.dslearnbds.dto.UserDTO;
import com.vitorlucas.dslearnbds.entities.User;
import com.vitorlucas.dslearnbds.repositories.UserRepository;
import com.vitorlucas.dslearnbds.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repositoy;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		authService.validateSelfOrAdmin(id);
		Optional<User> obj = repositoy.findById(id);
		User user = obj.orElseThrow(() -> new ResourceNotFoundException("User not Found"));
		return new UserDTO(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repositoy.findByEmail(username);
		if (user == null) {
			logger.error("Username: "+ username+" not found");
			throw new UsernameNotFoundException("Username not found");
		}
		logger.info("User found: " + username);
		return user;
	}
}
