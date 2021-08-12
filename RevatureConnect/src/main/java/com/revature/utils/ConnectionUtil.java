package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//This Class contains the logic that gets a connection to our database
//It will have a method called getConnection() that will return a Connection object
//We will need these Connection object in our DAO layer to interact with our database
public class ConnectionUtil {

	
	
	public static void main(String[] args) {
			
			//here we're just testing whether our connection (from the ConnectionUtil Class) is successful
			//remember - the getConnection() method will return a Connection object if you successfully reach the database
			try(Connection conn = ConnectionUtil.getConnection()) {
				System.out.println("connection successful");
			} catch (SQLException e) {
				System.out.println("No Connection");
				e.printStackTrace();
			}
			
			
	}
	
	
	//a method called getConnection that returns a Connection object
	public static Connection getConnection() throws SQLException {
		//For compatibility with other technologies/frameworks, we'll need to register our Driver
		//This process makes the application aware of what Driver class (what SQL dialect) we're using
		try {
			Class.forName("org.postgresql.Driver"); //try to find and return the postgresql Driver Class
		} catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found :(");
			e.printStackTrace(); //prints the exception message to the console if we can't find the postgresql class
		}
		

		String url = "revature-community-psql.cvtq9j4axrge.us-east-1.rds.amazonaws.com";
		String username = "postgres";
		String password = "Password123!";
		//This is what returns our actual Connection object (note how this getConnection() method has a return type of Connection
		return DriverManager.getConnection(url, username, password);
	}
}