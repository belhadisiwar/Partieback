package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Services;
public interface ServicesService {

	public void addservice(Services services);
	public void updateservices(Services services  );
	public void deleteservices(Services services);
	public Services getserviceById (Integer id);
	public List<Services> getAll();
}
