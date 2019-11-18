package com.Spring.utilizator.dao;

import com.Spring.utilizator.model.Utilizator;

public interface UtilizatorDAO 
{
	public void insert(Utilizator utilizator);
	public Utilizator findBUtilizatorId(int utilizatorID) ;
	public Utilizator getUser(String email, String password);	
}
