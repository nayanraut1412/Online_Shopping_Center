package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.util.DBconnect;

public class DeleteProductDAO {

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
