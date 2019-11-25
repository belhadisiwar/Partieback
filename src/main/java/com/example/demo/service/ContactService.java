package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Contact;

public interface ContactService {
public void savecontact(Contact contact);
public List<Contact> getAll();
}
