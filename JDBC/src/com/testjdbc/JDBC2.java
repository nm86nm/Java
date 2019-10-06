package com.testjdbc;

import java.sql.*;

/**
 * @author Maciej
 */
public class JDBC2 {
    private String user, password, url;

    public static void main(String[] args) throws SQLException {
        JDBC2 jdbc = new JDBC2();
        jdbc.select();
    }

    public void select() {
        url = "url";
        user = "user";
        password = "password";

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
}
