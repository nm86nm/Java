package com.testjdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maciej
 */
public class JDBC1 {
    private String user, password, url;

    JDBC1() {
        //url="jdbc:derby://localhost:1527/DerbyDatabase;create=true";
        //url="jdbc:hsqldb:hsql://localhost/";
        //url="jdbc:oracle:thin:@localhost:1521:OracleDataba";
        //url="jdbc:postgresql://localhost:5432/postgres";
    	//url = "jdbc:mysql://remotemysql.com:3306/database_name";
        
    	url="url";
        user = "user";
        password = "password";		
   }	
    
    public static void main(String[] args) throws SQLException {
        JDBC1 jdbc1 = new JDBC1();
        jdbc1.select();
    }

    public void alterTable() {        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            String sql = "ALTER TABLE person ALTER COLUMN fistname RENAME TO firstname";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void copyTable() {
        String user1 = "user1", password1 = "password1", url1 = "url1";
        String user2 = "user2", password2 = "password2", url2 = "url2";

        try {
            Connection conn1 = DriverManager.getConnection(url1, user1, password1);
            Statement st1 = conn1.createStatement();
            ResultSet rs = st1.executeQuery("SELECT * FROM person ORDER BY id ASC");

            List<Integer> ids = new ArrayList<Integer>();
            List<String> firstnames = new ArrayList<String>();
            List<String> lastnames = new ArrayList<String>();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");

                ids.add(id);
                firstnames.add(firstname);
                lastnames.add(lastname);
            }

            Connection conn2 = DriverManager.getConnection(url2, user2, password2);
            Statement st2 = conn2.createStatement();

            int index = 0;
            for (int i : ids) {
                //System.out.println(ids.get(index) + ". " + firstnames.get(index) + " " + lastnames.get(index));
                st2.executeUpdate("INSERT INTO person(id, firstname, lastname) VALUES (" + ids.get(index) + ",'" + firstnames.get(index) + "','" + lastnames.get(index) + "')");
                index++;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
        String sql = "CREATE TABLE Person(id INT NOT NULL, firstname VARCHAR(20), lastname VARCHAR(20))";

        st.executeUpdate(sql);
    }

    public void delete() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.execute("DELETE contact_hobby_detail");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void dropTable() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            st.executeUpdate("DROP TABLE person");
            System.out.println("Everything is OK. Table was dropped.");
            //for(int index=0; index < table_names.size(); index++)
            //st.executeQuery("DROP TABLE " + table_names.get(index));

        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
            System.out.println("Tabe not dropped.");
        }
    }

    public void insert() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();

        List<String> listSQL = new ArrayList<String>();
        listSQL.add("INSERT INTO Person(id, firstname, lastname) values (1, 'Matthew','Nowotka')");

        //st.execute(listSQL.get(0));
        for (int i = 0; i < listSQL.size(); i++)
            st.executeUpdate(listSQL.get(i));
    }

    public void select() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            //ResultSet rs = st.executeQuery("SELECT table_name FROM user_tables ORDER BY table_name ASC");
            ResultSet rs = st.executeQuery("SELECT * FROM person ORDER BY id ASC");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                System.out.println(id + ". " + firstname + " " + lastname);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void update() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            String sql1 = "UPDATE users SET enabled=1, id=2 WHERE username='user'";
            String sql2 = "UPDATE users SET id=3, enabled=1 WHERE username='guest'";
            st.executeUpdate(sql2);
        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        }
    }
}