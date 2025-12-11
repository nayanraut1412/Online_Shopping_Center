package com.pack1.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.ProductDAO;
import com.pack1.model.ProductBean;

@WebServlet("/admin/update")
public class UpdateProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
	
		if(session==null)
		{
			req.getRequestDispatcher("/admin/AdminLogin.html").forward(req, resp);
		}
		else
		{
			 String pcode=req.getParameter("pcode");
			 ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
			 Iterator<ProductBean> i=al.iterator();
			 ProductBean pb=null;
			 while(i.hasNext())
			 {
				 pb=i.next();
				 if(pcode.equals(pb.getPcode()))
					 break;
			 }
//			 ProductBean pb=new ProductBean(); not preferred it because remaining fields are null
			 pb.setPprice(req.getParameter("pprice"));
			 pb.setPqty(req.getParameter("pqty"));
		 
		 int rowCount=new ProductDAO().update(pb);
			
		 if(rowCount>0) {
			 req.setAttribute("msg", "Product Inventory updated!!!");
			 req.getRequestDispatcher("/admin/UpdateProduct.jsp").forward(req, resp);
		 }
		 else
		 {
			 req.setAttribute("msg", "Product Not Inventory updated!!!");
			 req.getRequestDispatcher("/admin/UpdateProduct.jsp").forward(req, resp);
		 }
		}
	}
}
