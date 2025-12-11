package com.pack1.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack1.dao.ProductDAO;
import com.pack1.model.ProductBean;

@WebServlet("/admin/addproduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            req.getRequestDispatcher("/admin/AdminLogin.html").forward(req, resp);
        } else {
            ProductBean pb = new ProductBean();
            pb.setPcode(req.getParameter("pcode"));
            pb.setPname(req.getParameter("pname"));
            pb.setPcompany(req.getParameter("pcompany"));
            pb.setPprice(req.getParameter("pprice"));
            pb.setPqty(req.getParameter("pqty"));

            try {
                int rowCount = new ProductDAO().addProduct(pb);

                if (rowCount > 0) {
                    req.setAttribute("msg", "Product Added Successfully");
                } else {
                    req.setAttribute("msg", "Product not Added (no rows inserted)");
                }

                req.getRequestDispatcher("/admin/AddProduct.jsp").forward(req, resp);

            } 
            catch (SQLException e) {

                String userMsg;

                switch (e.getErrorCode()) {

                    case 1: // ORA-00001 Unique constraint
                        userMsg = "Product not added: This product code already exists.";
                        break;

                    case 12899: // ORA-12899 Value too large
                        userMsg = "Product not added: One of the fields exceeds the allowed size.";
                        break;

                    case 1400: // ORA-01400 Cannot insert NULL
                        userMsg = "Product not added: All fields are required.";
                        break;

                    default:
                        // fallback → generic
                        userMsg = "Product not added due to a database error.";
                }

                req.setAttribute("msg", userMsg);
                req.getRequestDispatcher("admin/AddProduct.jsp").forward(req, resp);
            }

        }
    }
}
