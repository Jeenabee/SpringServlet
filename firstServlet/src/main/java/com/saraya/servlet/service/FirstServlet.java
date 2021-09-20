package com.saraya.servlet.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<String> list = Arrays.asList("Mima", "Badou", "Ibrahim",
				"Amadou");

		request.setAttribute("bestBatsmanList", list);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Kine", 51);
		map.put("Salif", 29);
		map.put("Adama", 34);
		map.put("Mariane", 41);

		request.setAttribute("mapping", map);

		request.setAttribute("userName", "Souleymane");

		request.getRequestDispatcher("/WEB-INF/views/first.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
