package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contact;
import com.example.demo.service.ContactService;

@RequestMapping("/contact")
@CrossOrigin("*")
@RestController
public class ContactController {

	@Autowired
	ContactService contactservice;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void savecontact(@RequestBody Contact contact) {
		contactservice.savecontact(contact);
	}
	@RequestMapping(value="/allcontact", method=RequestMethod.GET)
	public List<Contact> getcontact(){
		return contactservice.getAll();
	}
}
