package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Ouvrier;
import com.example.demo.entities.User;

public interface OuvrierService {
	
	public void saveUser( Ouvrier ouvrier);
	public void suppouvrier(Ouvrier ouvrier);
	public Ouvrier getouvrierById(Integer id);
	public List<Ouvrier> getall();
	public void save(Ouvrier ouvrier);
	List<Ouvrier> getAvailable(boolean available);
	List<Ouvrier> getNotAvailable(boolean available);
	public void setEtatOuvrier (Ouvrier ouvrier);	
}
