package com.pack1.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.AdminLoginDAO;
import com.pack1.model.AdminBean;

@WebServlet("/alogin")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminBean ab=new AdminLoginDAO().login(req.getParameter("uname"), req.getParameter("pwd"));
		
		if(ab==null)
		{
			req.getRequestDispatcher("admin/AdminLogin.html").forward(req, resp);
		}
		else
		{
			HttpSession session=req.getSession();
			session.setAttribute("AdminBean", ab);
			req.getRequestDispatcher("admin/AdminHome.jsp").forward(req, resp);
		}
	
	}
	
}
