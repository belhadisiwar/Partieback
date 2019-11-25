package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "files")

public class Ouvrier extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
		
	@OneToMany(mappedBy="ouvriers", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comments> comments = new ArrayList<Comments>();

	
	@OneToMany(mappedBy="ouvrier", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Services> services = new ArrayList<Services>();



	
	}
