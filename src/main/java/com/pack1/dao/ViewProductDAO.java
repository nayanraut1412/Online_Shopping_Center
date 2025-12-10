package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pack1.model.ProductBean;
import com.pack1.util.DBconnect;

public class ViewProductDAO {

	public ArrayList<ProductBean> viewProduct()
	{
		ArrayList<ProductBean> al=new ArrayList<ProductBean>();
		try {
			Connection con=DBconnect.connect();
			 PreparedStatement pstm=con.prepareStatement("select * from product");
			
			 ResultSet rs=pstm.executeQuery();
			 
			 while(rs.next())
			 {
				 ProductBean pb=new ProductBean();
				 
				 pb.setPcode(rs.getString(1));
				 pb.setPname(rs.getString(2));
				 pb.setPcompany(rs.getString(3));
				 pb.setPprice(rs.getString(4));
				 pb.setPqty(rs.getString(5));
				 al.add(pb);
			 }
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return al;
	}
}
