package com.pack1.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.ViewProductDAO;
import com.pack1.model.ProductBean;

@WebServlet("/view1")
public class ViewProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.getRequestDispatcher("admin/AdminLogin.html").forward(req, resp);
		}
		else
		{
			ArrayList<ProductBean> al=new ViewProductDAO().viewProduct();
			session.setAttribute("ProductList", al);
			req.getRequestDispatcher("admin/ViewProduct.jsp").forward(req, resp);
		
		}
	}
}
