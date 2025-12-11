package com.pack1.servlet.customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.CustomerDAO;
import com.pack1.model.ProductBean;

@WebServlet("/customer/view")
public class ViewCustomerProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.getRequestDispatcher("/customer/CustomerLogin.html").forward(req, resp);
		}
		else
		{
			ArrayList<ProductBean> al=new CustomerDAO().ViewProduct();
			session.setAttribute("ProductList", al);
			req.getRequestDispatcher("/customer/ViewProduct.jsp").forward(req, resp);
		}
	}
	
}
