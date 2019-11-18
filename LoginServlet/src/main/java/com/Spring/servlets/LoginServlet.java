package com.Spring.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.Spring.utilizator.dao.UtilizatorDAO;
import com.Spring.utilizator.model.Utilizator;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
    UtilizatorDAO utilizatorDAO;
	private WebApplicationContext webApplicationContext;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

    	@SuppressWarnings("resource")
		ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
        utilizatorDAO = (UtilizatorDAO) context.getBean("UtilizatorDAO");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		String email = request.getParameter("email");
		String parola = request.getParameter("password");

        Utilizator utilizator1 = utilizatorDAO.getUser(email, parola);
              
		if (utilizator1!= null)
		{
			request.setAttribute("user", utilizator1);		
            requestDispatcher = request.getRequestDispatcher("/Home.jsp");		
		}
		else
		{	
			request.setAttribute("errorMessage", "Invalid username or password");		
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
		}

		requestDispatcher.forward(request, response);
	}
}