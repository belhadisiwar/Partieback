package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Services;
import com.example.demo.repositories.OuvrierRepository;
import com.example.demo.repositories.ServicesRepository;
import org.springframework.stereotype.Service;

@Service("ServicesService")
public class ServicesServiceImpl  implements ServicesService{

	@Autowired
	ServicesRepository servicesrepository;
	@Autowired
	OuvrierRepository ouvrierrepository;
	
	@Override
	public void addservice(Services services) {
		servicesrepository.save(services);
	}

	public void deleteservices(Services services) {
		
		servicesrepository.delete(services);
	}

	@Override
	public void updateservices(Services services) {
		// TODO Auto-generated method stub
		servicesrepository.save(services);
	}

	@Override
	public List<Services> getAll() {
		return servicesrepository.findAll();
	}

	@Override
	public Services getserviceById(Integer id) {
		return  servicesrepository.getOne(id);
	}
	
}
