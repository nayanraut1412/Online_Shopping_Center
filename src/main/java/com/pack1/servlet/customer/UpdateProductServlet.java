package com.pack1.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.CustomerDAO;
import com.pack1.dao.ProductDAO;
import com.pack1.model.ProductBean;

@WebServlet("/customer/buy")
public class UpdateProductServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.getRequestDispatcher("index.html").forward(req, resp);
		}
		else
		{
			ProductBean pb=new ProductDAO().ProductByCode(req.getParameter("pcode"));
			int availableQty = Integer.parseInt(pb.getPqty());
			int requestedQty = Integer.parseInt(req.getParameter("preq"));  
			if(availableQty>=requestedQty)
			{
				String updatedqty = Integer.toString(availableQty - requestedQty);
				int rowCount=new ProductDAO().UpdateQty(req.getParameter("pcode"), updatedqty);
				if(rowCount>0)
				{
					int price = Integer.parseInt(pb.getPprice());  
					req.setAttribute("msg1", "You Have Charged");
					req.setAttribute("charged", requestedQty*price);
					req.getRequestDispatcher("/customer/OrderConfirmed.jsp").forward(req, resp);
				}
				else
				{
					req.setAttribute("charged", -1);
					req.setAttribute("msg1", "Database error <br> Pls try again");
					req.getRequestDispatcher("/customer/OrderConfirmed.jsp").forward(req, resp);
				}
			
			}
			else
			{	
				req.setAttribute("charged", -1);
				req.setAttribute("msg1", "Quantity Updated <br> Pls try again");
				req.getRequestDispatcher("/customer/OrderConfirmed.jsp").forward(req, resp);

			}
		
		}
	}
}
