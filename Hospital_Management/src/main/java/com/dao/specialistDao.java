package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.specalist;

public class specialistDao {
public specialistDao(Connection conn) {
		super();
		this.conn = conn;
	}

private Connection conn;

public boolean addSpecialist(String spec) {
	boolean f=false;
	try {
		String sql = "insert into specialist(name) values(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, spec);
		
		int i = ps.executeUpdate();
		if(i == 1) {
			f = true;
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return f;
}
public List<specalist> getAllSpecialist(){
	specalist s = null;
	List<specalist> list = new ArrayList<specalist>();
	
	try {
		String sql = "select * from specialist";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s= new specalist();
			s.setId(rs.getInt(1));
			s.setSpecialistName(rs.getString(2));
			list.add(s);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
}
}
