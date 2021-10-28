package com.csis3275.DAOIm;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.csis3275.model.RowMapperRegister;
import com.csis3275.model.registerData;

@Service
public class RegisterDAoImpl {

	//jdbc for implemnteation
	JdbcTemplate jdbcTemplate;
	
	// Query
	private final String SQL_Get_AllREGISETER = "SELECT * FROM registers";
	private final String SQL_CREATE_REGISETER= "INSERT INTO registers (name, email, paswords, fullName, gender, phone) VALUES (?, ?,?,?,?,?)";

	private final String SQL_CREATE_Edit= "UPDATE registers set name = ?, email  = ?  , paswords= ? , fullName= ? , gender= ? , phone = ?   WHERE id = ?";


	
	
	//Default Constructor
		@Autowired
		public RegisterDAoImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		//get all users
		public ArrayList<registerData> allRegisterUser() {
			
			ArrayList<registerData> allRegister = new ArrayList<registerData>();
			
			allRegister= (ArrayList<registerData>) jdbcTemplate.query(SQL_Get_AllREGISETER, new RowMapperRegister());
			
			return allRegister;
			
		}
		
		// create user
		public boolean createRegisterUser(registerData newRegster) {
			return jdbcTemplate.update(SQL_CREATE_REGISETER,
									
										newRegster.getName(),
										newRegster.getEmail(),
										newRegster.getPaswords(),
										newRegster.getFullName(),
										newRegster.getGender(),
										newRegster.getPhone())>0;
		}
		
	
		//Update the student (based on the given id)
		public boolean updateRigister(registerData Regster) {
			return jdbcTemplate.update(SQL_CREATE_Edit,
					
					Regster.getName(),
					Regster.getEmail(),
					Regster.getPaswords(),
					Regster.getFullName(),
					Regster.getGender(),
					Regster.getPhone(),
					Regster.getId())>0;
			}
}
	

	

