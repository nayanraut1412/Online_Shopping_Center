package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack1.model.ProductBean;
import com.pack1.util.DBconnect;

public class ProductDAO {

	public int addProduct(ProductBean pb) throws SQLException {
	    int rowCount = 0;

	    PreparedStatement pstm = null;

	    try {
	    	Connection con = DBconnect.connect();  // static shared connection
	        pstm = con.prepareStatement("insert into product values(?,?,?,?,?)");

	        pstm.setString(1, pb.getPcode());
	        pstm.setString(2, pb.getPname());
	        pstm.setString(3, pb.getPcompany());
	        pstm.setString(4, pb.getPprice());
	        pstm.setString(5, pb.getPqty());

	        rowCount = pstm.executeUpdate();
	    } finally {
	        if (pstm != null) try { pstm.close(); } catch (Exception e) {}
	    }

	    return rowCount;
	}
	
	public int update(ProductBean pb)
	{
		int rowCount=0;
		try {
			Connection con=DBconnect.connect();
			PreparedStatement pstm=con.prepareStatement("update product set pprice=?, pqty=? where pcode=?");
			
			pstm.setString(1, pb.getPprice());
			pstm.setString(2, pb.getPqty());
			pstm.setString(3, pb.getPcode());
		
			rowCount=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return rowCount;
	}
	
	
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
	
	public int deleteProduct(String pcode)
	{
		int rowCount=0;
		try {
			Connection con=DBconnect.connect();
			PreparedStatement pstm=con.prepareStatement("delete from product where pcode=?");
			
			pstm.setString(1, pcode);
			rowCount=pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	
	

}
