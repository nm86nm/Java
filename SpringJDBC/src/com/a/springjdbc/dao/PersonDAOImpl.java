package com.a.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.a.springjdbc.PersonMapper;
import com.a.springjdbc.model.Person;

public class PersonDAOImpl implements PersonDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Person> listPerson() {
		String sql = "SELECT * FROM person ORDER BY id ASC";
		List<Person> listPerson = jdbcTemplate
				.query(sql, new PersonMapper());
		return listPerson;
	}

	/*public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
}