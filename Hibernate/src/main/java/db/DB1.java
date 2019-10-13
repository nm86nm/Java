package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB1 {
	public void select() {
		String user = "user";
		String password = "password";
		String url = "url";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();						                                       
			//ResultSet rs = st.executeQuery("SELECT table_name FROM user_tables");
			ResultSet rs = st.executeQuery("SELECT * FROM person ORDER BY id ASC");
			
			while(rs.next()){
				Integer id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				System.out.println(id + " " + firstname + " " + lastname);				
			}			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws SQLException{
		DB1 db1 = new DB1();		
		db1.select();
	}
}
