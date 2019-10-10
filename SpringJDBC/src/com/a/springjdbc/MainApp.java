package com.a.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.a.springjdbc.dao.PersonDAOImpl;
import com.a.springjdbc.model.Person;

public class MainApp {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");		
		PersonDAOImpl personDAOImpl = (PersonDAOImpl) context.getBean("personDAOImpl");
		List<Person> listPerson = personDAOImpl.listPerson();
				
		for(Person person : listPerson){
			System.out.print("id: " + person.getId() + ",");
			System.out.print(" firstname: " + person.getFirstname() + ",");
			System.out.println(" lastname: " + person.getLastname());
		}
	}
}