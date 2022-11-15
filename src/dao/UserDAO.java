package dao;

import java.sql.*;
import pojo.User;
import database.DatabaseConnectionFactory;

public class UserDAO{
	private Connection connect = null;
	private PreparedStatement prepStatement = null;
	private Statement statement = null;
	private ResultSet rs = null;

    // Database connection 
    public UserDAO() {
        try {
        	connect = new DatabaseConnectionFactory().getConnection();
        	statement = connect.createStatement();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Delete User based on user_id
    public void deleteUserDAO(User user){
    	try{
                 String query="DELETE from users WHERE user_id='"+user.getUserId()+"';";
                 prepStatement=connect.prepareStatement(query);
                 prepStatement.executeUpdate();
             }    	
    	catch(SQLException e){
                e.printStackTrace();
              }
         }

    // Get User details from database
    public ResultSet getUserDAO() {
    	try{
    			String query = "SELECT user_id, name, Location, Phone, Category, email FROM users;";  
             	rs=statement.executeQuery(query);
                 while(rs.next())  
            		System.out.println(rs.getString(2));
             }
    	catch(SQLException e){
               	e.printStackTrace();
             }
			return rs;
         }
        
    // Add user to database
    public void addUserDAO(User user) {
    	try{             	
               String query = "INSERT INTO users (user_id, name, Location, Phone, Category, email) VALUES ('" + user.getUserId() +"','"+user.getName()+"','"+user.getLocation()  +"','"+user.getPhone() +"','"+user.getCategory() +"','"+user.getEmail()+"');";
               prepStatement=connect.prepareStatement(query);
               prepStatement.executeUpdate();
             }
    	catch(SQLException e){
              	e.printStackTrace();
             }   
         }
    
    // Update user details
    public void editUserDAO(User user){        
        try{
            String query = "UPDATE users SET user_id='"+ user.getUserId()+"', name='"+user.getName()+"', Location='"+ user.getLocation()+"', Phone='" +user.getPhone() +"', Category ='"+ user.getCategory()+"' WHERE email='"+user.getEmail() + "';";
            prepStatement = connect.prepareStatement(query);
            prepStatement.executeUpdate(query);
        	}
        catch(Exception e){
        	e.printStackTrace();
    	}
    }
}



