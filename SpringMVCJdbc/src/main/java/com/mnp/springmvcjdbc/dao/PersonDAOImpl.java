package com.mnp.springmvcjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mnp.springmvcjdbc.model.Person;

public class PersonDAOImpl implements PersonDAO{

	private JdbcTemplate jdbcTemplate;
	
	public PersonDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Person> listPersons() {
		String sql = "SELECT * FROM person ORDER BY id ASC";
		List<Person> listPerson = jdbcTemplate.query(sql, new RowMapper<Person>(){
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setFirstname(rs.getString("firstname"));
				person.setLastname(rs.getString("lastname"));
				
				return person;
			}			
		});
		
		return listPerson;
	}	
}
