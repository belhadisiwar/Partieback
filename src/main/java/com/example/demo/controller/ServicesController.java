package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.entities.Services;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.OuvrierRepository;
import com.example.demo.repositories.ServicesRepository;
import com.example.demo.service.ClienttService;
import com.example.demo.service.ServicesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/service")
public class ServicesController {
	@Autowired
ServicesService servicesservice;	
	@Autowired
	OuvrierRepository ouvrierrepository;
   	@Autowired
   	ServicesRepository servicesrepository;
   	@Autowired
   	ClientRepository clientrepository;
   	@Autowired
   	ClienttService clientservice;
	    
    @RequestMapping(value="/addservice/{idclient}", method=RequestMethod.POST)
    public void addservice(@RequestBody Services services, @PathVariable("idclient") Integer idclient) {
    	Client c = clientservice.getclientById(idclient);
    	services.setClient(c);
    	servicesservice.addservice(services);    	
    }
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	public void saveUser(@RequestBody Services service) {
		servicesservice.addservice(service);
		
	}
    
    @RequestMapping(value="/allservice",method=RequestMethod.GET)
    public List<Services> getAll(){
    	return servicesservice.getAll();
    }
    
    @RequestMapping(value="/updateservices/{id}", method=RequestMethod.PUT)
    public void updateservices(@RequestBody Services services , @PathVariable("id") Integer id) {
    	Services updatedService = servicesrepository.getOne(id);
    	updatedService.setDecription(services.getDecription());
    	updatedService.setDate(services.getDate());
    	updatedService.setTitre(services.getTitre());
    	servicesservice.updateservices(updatedService);
    }
	
    @RequestMapping(value="/deleteservices/{id}", method= RequestMethod.DELETE)
    public void deletes(@PathVariable("id") Integer id) {
    	Services services = servicesservice.getserviceById(id);
    	servicesservice.deleteservices(services);
    }
 
}
