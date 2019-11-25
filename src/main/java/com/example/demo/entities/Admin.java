package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;

	//private static final long serialVersionUID = 1L;
	 @GeneratedValue(strategy=GenerationType.IDENTITY)

	 public static long getSerialversionuid() {
			return serialVersionUID;
		}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String username, String password, String adresse, String email, String tel, Role role) {
		super(id, username, password, adresse, email, tel, role);
		// TODO Auto-generated constructor stub
	}

	
		
	

}
