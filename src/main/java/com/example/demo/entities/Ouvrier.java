package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "files")

public class Ouvrier extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
		private Typedouvrier typedouvrier;
		private boolean available ;
	


	@OneToOne( fetch = FetchType.EAGER)
	private Services services;

	


	public Services getServices() {
		return services;
	}


	public void setServices(Services services) {
		this.services = services;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Typedouvrier getTypedouvrier() {
		return typedouvrier;
	}


	public void setTypedouvrier(Typedouvrier typedouvrier) {
		this.typedouvrier = typedouvrier;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}



	
	}
