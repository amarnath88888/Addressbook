package com.addressbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addressbook.model.login.UserCreation;


/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String mobileNo = (String) request.getParameter("mobileNo");
		String emailId = (String) request.getParameter("emailId");
		
		UserCreation userCreation = new UserCreation(userName, password, firstName, lastName, mobileNo, emailId);
		if (userCreation.isUserAvailable())	{
			view = request.getRequestDispatcher("error.jsp");
		}
		else {
			if (userCreation.createUser())	{
				view = request.getRequestDispatcher("success.jsp");
			}
			else	{
				view = request.getRequestDispatcher("error.jsp");
			}
		}
		view.forward(request, response);
	}

}
