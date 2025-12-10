package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pack1.model.ProductBean;
import com.pack1.util.DBconnect;

public class UpdateProductDAO {

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
}
