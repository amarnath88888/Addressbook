package com.addressbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addressbook.model.login.UserValidation;

/**
 * Servlet implementation class Signin
 */
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = null;
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		UserValidation userValidation = new UserValidation(userName, password);
		if (userValidation.isValidUser())	{
			session = request.getSession();
			session.setAttribute("userName", userName);
			view = request.getRequestDispatcher("welcome.jsp");
		}
		else	{
			view = request.getRequestDispatcher("error.jsp");
		}
		view.forward(request, response);
	}

}
