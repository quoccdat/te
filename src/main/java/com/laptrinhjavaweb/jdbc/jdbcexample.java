package com.laptrinhjavaweb.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbcexample {
	static final String DB_URL = "jdbc:mysql://localhost:3306/javasql22022";
	   static final String USER = "root";
	   static final String PASS = "12345678";
	   static final String QUERY = "SELECT name FROM building";

	   public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
	      ) {		      
	         while(rs.next()){
	            System.out.println("Name: " + rs.getString("name"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
}
