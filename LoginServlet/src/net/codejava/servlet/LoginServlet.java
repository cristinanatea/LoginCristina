package net.codejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email.equals("cristina.natea4@gmail.com") && password.equals("Ausy")) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("Home.jsp");

		} else {
			response.sendRedirect("Failure.jsp");
		}
	}
//	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
//{
//		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.write("Salut");
//}
}