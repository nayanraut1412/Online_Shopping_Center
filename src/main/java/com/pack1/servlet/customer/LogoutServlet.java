package com.pack1.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customer/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
	
		if(session==null)
		{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/customer/Logout.jsp").forward(req, resp);
		}
	
	}
	
}
