package com.csis3275.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperRegister implements RowMapper<registerData> {

	@Override
	public registerData mapRow(ResultSet rs, int rowNum) throws SQLException {
		//name, email, paswords, fullName, gender, phone
		registerData register = new registerData();
		register.setId(rs.getInt("id"));
		register.setName(rs.getString("name"));
		register.setEmail(rs.getString("email"));
		register.setPaswords(rs.getString("paswords"));
		register.setFullName(rs.getString("fullName"));
		register.setGender(rs.getString("gender"));
		register.setPhone(rs.getString("phone"));
		
		
		
		return register;
	}
	

}
