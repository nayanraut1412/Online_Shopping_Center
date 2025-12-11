package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.pack1.model.CustomerBean;
import com.pack1.model.ProductBean;
import com.pack1.util.DBconnect;

public class CustomerDAO {

	public int CustomerRegister(CustomerBean cb)
	{
		int rowCount=0;
		try {
			Connection con=DBconnect.connect();
			PreparedStatement pstm=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			
			pstm.setString(1, cb.getUname());
			pstm.setString(2, cb.getPwd());
			pstm.setString(3, cb.getFname());
			pstm.setString(4, cb.getLname());
			pstm.setString(5, cb.getAdd());
			pstm.setString(6, cb.getMail());
			pstm.setString(7, cb.getMob());
			
			rowCount=pstm.executeUpdate();

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public CustomerBean Customerlogin(String uname,String pwd)
	{
		CustomerBean cb=null;
		try {
			Connection con=DBconnect.connect();
			PreparedStatement pstm=con.prepareStatement("select * from customer where uname=? and pword=?");
			
			pstm.setString(1, uname);
			pstm.setString(2, pwd);
			
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next())
			{
				cb=new CustomerBean();
				cb.setUname(rs.getString(1));
				cb.setPwd(rs.getString(2));
				cb.setFname(rs.getString(3));
				cb.setLname(rs.getString(4));
				cb.setAdd(rs.getString(5));
				cb.setMail(rs.getString(6));
				cb.setMob(rs.getString(7));
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}
	
	public ArrayList<ProductBean> ViewProduct()
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
			e.printStackTrace();
		}
		
		return al;
	}
	
	public ProductBean BuyProduct(String pcode)
	{
		ProductBean pb=null;
		try {
			Connection con=DBconnect.connect();
			PreparedStatement pstm=con.prepareStatement("select * from product where pcode=?");
			pstm.setString(1, pcode);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next())
			{
				pb=new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setPname(pcode);
				pb.setPcompany(pcode);
				pb.setPprice(pcode);
				pb.setPqty(pcode);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pb;
	}
}


