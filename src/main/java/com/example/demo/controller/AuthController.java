package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SigninRequest;
import com.example.demo.model.SigninResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("api/auth")
public class AuthController 
{
	
	Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninRequest signinRequest, BindingResult result, User user)
	{
		log.info("USER SIGNIN");
		
		Authentication authenticate = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(signinRequest.getName(), signinRequest.getPassword()));
		
		
		Long userId = getUserIdforUser(user);
		
		Optional<User> opt = userrepo.findUser(userId);
		
		User user1;
		
		if(!opt.isPresent())
		{
			return new ResponseEntity("User is not Found", HttpStatus.BAD_REQUEST);
		}
		
		String name = user.getName() == null ? "" : user.getName();
		String password = user.getPassword() == null ? "" : user.getPassword();
		
		SigninResponse signinresponse = new SigninResponse();
		signinresponse.setName(null);
		signinresponse.setPassword(null);
		
		return ResponseEntity.ok(signinresponse);
	}
	
	public void createAdmin()
	{
		Optional<User> admin = null;
		
		try {
			admin = userrepo.findFirstAdmin();
		} catch(Exception e)
		{
			log.error("Unable to find Admin");
		}
		
		if(admin != null && !admin.isPresent())
		{
			User user = new User("sysadmin", "welcome@123");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			try
			{
				userrepo.save(user);
			} catch(Exception e) {
				log.error("unable to create admin");
			}
		}
	}
	private Long getUserIdforUser(User user)
	{
		Long userId = user.getUserId();
		return userId;
	}
}
