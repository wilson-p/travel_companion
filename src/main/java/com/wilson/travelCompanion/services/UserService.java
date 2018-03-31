package com.wilson.travelCompanion.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wilson.travelCompanion.model.User;

public class UserService {
	
	private String url = "jdbc:mysql://localhost:3306/travel_companion";
	private String username = "root";
	private String password = "p@Ul@Uh01";
	private Connection connection = null;
	
	public UserService() {
		
	}
	
	public void createDataBaseConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "select * from user";
		
		try{
			
			createDataBaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				User user = new User();
				
				user.setUserId(resultSet.getInt(1));
				user.setUserName(resultSet.getString(2));
				user.setEmailId(resultSet.getString(3));
				user.setEmailVerified(resultSet.getBoolean(4));
				user.setFirstName(resultSet.getString(5));
				user.setLastName(resultSet.getString(6));
				user.setCreatedDate(resultSet.getTimestamp(7));
				user.setCreatedBy(resultSet.getString(8));
				user.setUpdatedDate(resultSet.getTimestamp(9));
				user.setUpdatedBy(resultSet.getString(10));
				
				users.add(user);
 			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Exception occured in getAllUsers method: "+e);
		}
		
		return users;
	}
	
	
	
	public User getUser(int userId) {
		
		String sql = "select * from user WHERE user_id = "+userId;
		User user = new User();
		
		try{
			
			createDataBaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()){
					
				user.setUserId(resultSet.getInt(1));
				user.setUserName(resultSet.getString(2));
				user.setEmailId(resultSet.getString(3));
				user.setEmailVerified(resultSet.getBoolean(4));
				user.setFirstName(resultSet.getString(5));
				user.setLastName(resultSet.getString(6));
				user.setCreatedDate(resultSet.getTimestamp(7));
				user.setCreatedBy(resultSet.getString(8));
				user.setUpdatedDate(resultSet.getTimestamp(9));
				user.setUpdatedBy(resultSet.getString(10));
				
 			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Exception occured in getAllUsers method: "+e);
		}
		
		return user;
	}

	
	public User addUser(User user) {
		
		String sql = "insert into user (username, email, is_email_verified, first_name, last_name, create_date, created_by, update_date, updated_by) values (?,?,?,?,?,?,?,?,?)";
		
		try{
			
			createDataBaseConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUserName());
			statement.setString(2,  user.getEmailId());
			statement.setBoolean(3, user.isEmailVerified());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
			statement.setString(7, user.getCreatedBy());
			statement.setTimestamp(8, new java.sql.Timestamp(new java.util.Date().getTime()));
			statement.setString(9, user.getUpdatedBy());
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (Exception e) {	
			System.out.println("Exception occurred while creating new user"+ e);
		}
		
		return user;
	}


	
	public User updateUser(int userId, User user) {
		
		String sql = "UPDATE user SET username = ?, email = ?, is_email_verified = ?, first_name = ?, last_name = ?, update_date = ?, updated_by = ? WHERE user_id = " + userId;
		
		try{
			
			createDataBaseConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUserName());
			statement.setString(2,  user.getEmailId());
			statement.setBoolean(3, user.isEmailVerified());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
			statement.setString(7, user.getUpdatedBy());
			
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (Exception e) {	
			System.out.println("Exception occurred while creating new user"+ e);
		}
		
		return user;
	}

	
	public void removeUser(int userId) {
		
		String sql = "DELETE FROM user WHERE user_id = " + userId;
		
		try{
			
			createDataBaseConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
					
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (Exception e) {	
			System.out.println("Exception occurred while creating new user"+ e);
		}
	}
	
}
