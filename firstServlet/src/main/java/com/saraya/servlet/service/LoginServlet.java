package com.saraya.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//mima@saraya.com , secret
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		request.setAttribute("email", email);
		request.setAttribute("password", password);

		if (email.equalsIgnoreCase("mima@saraya.com")
				&& password.equalsIgnoreCase("secret")) {
			request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Invalid ID/Password");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}
	}

}
