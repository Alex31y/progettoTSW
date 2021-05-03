package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;




public class Database implements ProductModel{


	public Database() {
		System.out.println("Loading driver...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
	}

	@Override
	public void doSave(ArticoloBean product) throws SQLException {

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println("Database connected!");

			ArrayList<ArticoloBean> articoli = new ArrayList<ArticoloBean>();

			PreparedStatement preparedStatement = null;
			String insertSQL = "INSERT INTO " + Database.TABLE_NAME
					+ " (IDARTICOLI, NOME, DESCRIZIONE, IMMAGINE, PREZZO) VALUES (?, ?, ?, ?, ?)";

			try {
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setInt(1, product.getId());
				preparedStatement.setString(2, product.getNome());
				preparedStatement.setString(3, product.getDescrizione());
				preparedStatement.setString(4, product.getImg());
				preparedStatement.setFloat(5, product.getPrezzo());


				preparedStatement.executeUpdate();

				connection.commit();
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
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
	
	
	public ArrayList<ArticoloBean> getArticoli(String order) {
		System.out.println("Connecting database...");
		PreparedStatement preparedStatement = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println("Database connected!");

			ArrayList<ArticoloBean> articoli = new ArrayList<ArticoloBean>();
			String selectSQL = "SELECT * FROM " + Database.TABLE_NAME;	

			if (order != null && !order.equals("")) {
				selectSQL += " ORDER BY " + order;
			}

			try {
				Statement query = connection.createStatement();
				ResultSet result = query.executeQuery("select * FROM" + Database.TABLE_NAME);

				preparedStatement = connection.prepareStatement(selectSQL);


				while(result.next()) {
					ResultSet rs = preparedStatement.executeQuery();	
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

	public ArticoloBean getArticolo(int id)  {
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




	@Override
	public boolean doDelete(int code) throws SQLException {


		try (Connection connection = DriverManager.getConnection(url, username, password)) {

			System.out.println("Database connected!");
			PreparedStatement preparedStatement = null;

			int result = 0;

			String deleteSQL = "DELETE FROM " + Database.TABLE_NAME + " WHERE IDARTICOLI = ?";

			try {
				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setInt(1, code);

				result = preparedStatement.executeUpdate();

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}

			return (result != 0);


		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

	String url = "jdbc:mysql://localhost:3306/database?characterEncoding=latin1";
	String username = "root";
	String password = "root";
	private static final String TABLE_NAME = "articoli";


	}


