package model;

import java.sql.*;


public class test {

	public static void main(String[] args) {
		/*
			try {
				Connection con = null ;
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/database" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true" + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String username = "root";
				String pwd = "admin";
				con = DriverManager.getConnection(url,username,pwd);
				System.out.println("aaa");
			}
			catch(Exception e){
				System.out.println("Connessione fallita!!!");
				System.err.println(e.getMessage());
				 throw new IllegalStateException("Cannot connect the database!", e);
			}
			*/
		System.out.println("Loading driver...");

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		String url = "jdbc:mysql://localhost:3306/database?characterEncoding=latin1";
		String username = "root";
		String password = "admin";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
		    Statement query = connection.createStatement();
			ResultSet result = query.executeQuery("select * FROM articoli");
			while(result.next()) {
				System.out.println(result.getInt(1) + ": " + result.getString(2));
			}
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}
