package hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

@SuppressWarnings("deprecation")
public class Data {
	public static final SessionFactory sf;
	static{
		Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
    }
	
	public void displayPersons(){
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Persons.class)
			.addOrder(Order.asc("id"));
		List persons = criteria.list();
		
		for(Iterator it = persons.iterator(); it.hasNext();){
			Persons person = (Persons) it.next();
			System.out.println(person.getId() + "." + person.getFirstname() + " " + person.getLastname());
		}
		
		trans.commit();
		session.close();		
	}
}
