package com.Spring.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.utilizator.dao.UtilizatorDAO;
import com.Spring.utilizator.dao.impl.JdbcUtilizatorDAO;
import com.Spring.utilizator.model.Utilizator;

public class App 
{
	/*
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
        UtilizatorDAO utilizatorDAO = (UtilizatorDAO) context.getBean("UtilizatorDAO");
        Utilizator utilizator = new Utilizator(1,"cnatea","cristina.natea4@gmail.com", "Ausy");
        utilizatorDAO.insert(utilizator);
        
        JdbcUtilizatorDAO obj = new JdbcUtilizatorDAO();
    	
        Utilizator utilizator1 = utilizatorDAO.findBUtilizatorId(1);
        System.out.println(utilizator1);
        
    }*/
}