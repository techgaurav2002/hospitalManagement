package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.user;

public class userDao {
	private Connection conn;
	
	public userDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean userRegister(user u) {
		boolean f = false;
		
		try {
			String sql="insert into user_dtel(full_name,email,password)values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,u.getFullname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				return true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public user login(String em,String ps) {
		user u = null;
		try {
			String sql = "select * from user_dtel where email=? and password=?";
			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setString(1, em);
			ps1.setString(2, ps);
			
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				u = new user();
				u.setId(rs.getInt(1));
				u.setFullname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return u;
	}

}
