package com.pack1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {

	private static Connection con=null;
	private DBconnect() {}
	static
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(DBInfo.DBurl, DBInfo.DBname, DBInfo.DBpwd);
			System.out.println("DB Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connect()
	{
		return con;
	}
}
