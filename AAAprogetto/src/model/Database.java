package model;

import java.sql.*;
import java.util.ArrayList;


public class Database {
	public Database() {
		System.out.println("Loading driver...");

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
	}
	
	public ArrayList<ArticoloBean> getArticoli(){
		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
		    ArrayList<ArticoloBean> articoli = new ArrayList<ArticoloBean>();
			
			
			try {
				Statement query = connection.createStatement();
				ResultSet result = query.executeQuery("select * FROM articoli");
				while(result.next()) {
					ArticoloBean fagiolo = new ArticoloBean();
					fagiolo.setId(result.getInt(1));
					fagiolo.setNome(result.getString(2));
					fagiolo.setDescrizione(result.getString(3));
					fagiolo.setImg(result.getString(4));
					fagiolo.setPrezzo(result.getInt(5));
					articoli.add(fagiolo);
				}
				
			}
				catch (Exception e){
				System.out.println("Errore nell'interrogazione");
				System.err.println(e.getMessage());
				}
			
			return articoli;
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public ArticoloBean getArticolo(int id) {
		ArticoloBean fagiolo = new ArticoloBean();
		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");

			try {
				Statement query = connection.createStatement();
				ResultSet result = query.executeQuery("select * FROM articoli WHERE idarticoli = " + id);
				while(result.next()) {
					
					fagiolo.setId(result.getInt(1));
					fagiolo.setNome(result.getString(2));
					fagiolo.setDescrizione(result.getString(3));
					fagiolo.setImg(result.getString(4));
					fagiolo.setPrezzo(result.getInt(5));
				}
			}
				catch (Exception e){
				System.out.println("Errore nell'interrogazione");
				System.err.println(e.getMessage());
				}
			
			return fagiolo;
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	String url = "jdbc:mysql://localhost:3306/database?characterEncoding=latin1";
	String username = "root";
	String password = "admin";
}
