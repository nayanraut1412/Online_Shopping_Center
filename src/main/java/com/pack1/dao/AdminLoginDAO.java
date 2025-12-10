package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack1.model.AdminBean;
import com.pack1.util.DBconnect;

public class AdminLoginDAO {

	public AdminBean login(String name, String pwd)
	{
		AdminBean ab=null;
		try {
			Connection con=DBconnect.connect();
			PreparedStatement  pstm=con.prepareStatement("select * from admin where uname=? and pword=?");
			
			pstm.setString(1, name);
			pstm.setString(2, pwd);
			
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next())
			{
				ab=new AdminBean(); 
				ab.setUname(rs.getString(1));
				ab.setPword(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setMid(rs.getString(6));
				ab.setPhno(rs.getString(7));
			}
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
