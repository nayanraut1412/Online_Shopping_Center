package com.pack1.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.CustomerDAO;
import com.pack1.model.CustomerBean;

@WebServlet("/customer/clogin")
public class CustomerLoginServlet extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		CustomerBean cb=new CustomerDAO().Customerlogin(req.getParameter("uname"), req.getParameter("pwd"));

		if(cb==null)
		{
			req.getRequestDispatcher("/customer/CustomerLogin.html").forward(req, resp);
		}
		else
		{
			HttpSession session=req.getSession();
			session.setAttribute("CustomerBeam", cb);
			req.getRequestDispatcher("/customer/CustomerHome.jsp").forward(req, resp);
	
		}
	}
	
}
