package com.Spring.utilizator.model;


public class Utilizator 
{
	int utilizatorID;
	String username;
	String email;
	String password;
	
	public Utilizator(int id,String user, String mail, String parola) {
		utilizatorID=id;
		username=user;
		email=mail;
		password=parola;
	}
	
	//getter and setter methods
	public int getUtilizatorID() {
		
		return utilizatorID;
	}
	public void setUtilizatorID(int utilizatorID){
		this.utilizatorID = utilizatorID;
		
	}
	public String getUsername() {
		
		return username;
	}
	public void setUsername(String username){
		this.username = username;
		
	}

	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email){
		this.email = email;
		
	}
	

	@Override
	public String toString() {
		return "Utilizator [utilizatorID=" + utilizatorID + ", username=" + username + ", email=" + email
				+ ", password=" + password + "]";
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password){
		this.password = password;
		
	}
	

	
}
