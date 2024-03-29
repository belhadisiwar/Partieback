package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
	//private static final long serialVersionUID = 5926468583005150707L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;	
	
	@Column(unique = true)
	private String email;
	private String tel;
	private Role role;
	private String adresse;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	


	public User(int id, String username, String password, String adresse, String email, String tel, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", tel="
				+ tel + ", role=" + role + ", adresse=" + adresse + "]";
	}




	
    	

}
