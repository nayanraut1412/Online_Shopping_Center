package com.pack1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pack1.model.ProductBean;
import com.pack1.util.DBconnect;

public class AddProductDAO {

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

}
