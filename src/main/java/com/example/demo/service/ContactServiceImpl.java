package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contact;
import com.example.demo.repositories.ContactRepository;
@Service("ContactService")
public class ContactServiceImpl implements ContactService{
@Autowired
ContactRepository contactrepositorry;
	@Override
	public void savecontact(Contact contact) {
		contactrepositorry.save(contact);
	}
	@Override
	public List<Contact> getAll() {
		return contactrepositorry.findAll();
	}

}
