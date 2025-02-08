package com.sears.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CustomerDOA {
	
	 // Database credentials
    String url = "jdbc:mysql://localhost:3306/protype";
    String username = "root";
    String password = "root";
    
  	String full_name =  "";
    
   
    public CustomerDOA() {
		super();
	}

	public String getFullName(int id) {
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute a SELECT query
            String query = "SELECT first_name, last_name FROM protype.customer where customer_id = " + id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            // Process the result set
            while (resultSet.next()) {
            	
            	full_name = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
            	
                System.out.println("Customers Full Name: " + full_name );

            }
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
		return full_name;
   }

}
