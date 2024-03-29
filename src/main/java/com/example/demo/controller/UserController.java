package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.BCryptManagerUtil;
import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Client;
import com.example.demo.entities.JwtResponse;
import com.example.demo.entities.Ouvrier;
import com.example.demo.entities.Role;
import com.example.demo.entities.Services;
import com.example.demo.entities.User;
import com.example.demo.repositories.ServicesRepository;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	ServicesRepository servicesrepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void saveUser(@RequestBody Client user) {
		user.setRole(Role.client);
		userservice.saveUser(user);	
	}
	@RequestMapping(value="/addouv/{idServices}",method=RequestMethod.POST)
	public void saveUser(@RequestBody Ouvrier user , @PathVariable("idServices") int idServices) {
		
		user.setRole(Role.ouvrier);
		Services f = servicesrepository.getOne(idServices);
		user.setServices(f);
		userservice.saveOuvrier(user);
		
	}
	

	
	@RequestMapping(value="/addadmin",method=RequestMethod.POST)
	public void saveUser(@RequestBody Admin user) {
		user.setRole(Role.admin);
		userservice.saveAdmin(user);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public User  loadByEmail( @RequestBody User user) {
		User u = userservice.loadByEmail(user.getEmail());
		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User u) throws Exception {
	String cryptpwd= userservice.loadByEmail(u.getEmail()).getPassword();
	
	 boolean pwd = BCryptManagerUtil.passwordEncoder().matches(u.getPassword(),cryptpwd);
	 if(pwd == true) {
		 final User userDetails = userservice.loadByEmail(u.getEmail());
		 final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
	 }
	return ResponseEntity.of(null);
	}
	/*private void authenticate(String email, String password) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
		}
		}*/	
	@RequestMapping(value = "/pwdCheck", method = RequestMethod.GET)
	private String checkPwd(@RequestBody User u) {	
		User userdetails  = userservice.loadByEmail(u.getEmail());
		String pwdcrypt = userdetails.getPassword();
		String password = u.getPassword();
		String pwdencode = BCryptManagerUtil.passwordEncoder().encode(password); 
		 boolean pwd = BCryptManagerUtil.passwordEncoder().matches(password,pwdcrypt);
		
		return ("password apres encode = "+ pwdencode +"     password = " + password +"     password crypter de la base = "+ pwdcrypt +"     Resultat du Matches est = "+ pwd)  ;
	}
}
	


