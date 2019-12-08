package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Services implements Serializable {
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String decription;
	private Date date  ;
	


	@OneToOne( fetch = FetchType.EAGER)
	private Client client;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Ouvrier> ouvrier = new ArrayList<Ouvrier>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Ouvrier> getOuvrier() {
		return ouvrier;
	}

	public void setOuvrier(List<Ouvrier> ouvrier) {
		this.ouvrier = ouvrier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}