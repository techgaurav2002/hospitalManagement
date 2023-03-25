package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DatabaseDetails.DATABASE_DRIVER);
			con = DriverManager.getConnection(DatabaseDetails.DATABASE_URL,DatabaseDetails.DATABASE_USE,DatabaseDetails.DATABASE_PASS);
			return con;
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

}
