package com.pack1.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack1.dao.CustomerDAO;
import com.pack1.model.CustomerBean;

@WebServlet("/customer/cregister")
public class CustomerRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerBean cb=new CustomerBean();
		
		cb.setUname(req.getParameter("uname"));
		cb.setPwd(req.getParameter("pwd"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setAdd(req.getParameter("add"));
		cb.setMail(req.getParameter("mail"));
		cb.setMob(req.getParameter("mob"));
		
		int rowCount=new CustomerDAO().CustomerRegister(cb);
		
		if(rowCount>0)
		{
			req.setAttribute("msg", "Your Registration Successfull!!");
			req.getRequestDispatcher("/customer/CustomerLogin.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Not Register");
			req.getRequestDispatcher("/customer/CustomerRegister.html").forward(req, resp);
		}
	}
	
}
