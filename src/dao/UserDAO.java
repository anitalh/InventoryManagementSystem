package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojo.User;
import database.DatabaseConnectionFactory;


public class UserDAO{
	private Connection con=null;
	private ResultSet result=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;

    // Database connection 
    public UserDAO() {
        try {
        	con = new DatabaseConnectionFactory().getConnection();
        	stmt = con.createStatement();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Delete User based on user_id
    public void deleteUserDAO(User user){
    	try{
            String query="DELETE from users WHERE user_id='"+user.getUserId()+"';";
            pstmt=con.prepareStatement(query);
            pstmt.executeUpdate();
        }    	
	catch(SQLException e){
           e.printStackTrace();
         }
    }
    

    // Get User details from database
    public ResultSet getUserDAO() {
		try {
			String query="SELECT * from users";
			result=stmt.executeQuery(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
        
    // Add user to database
    public void addUserDAO(User user) {
    	try{             	
            String query = "INSERT INTO users (name, Location, Phone, Category, email) VALUES ('"+user.getName()+"','"+user.getLocation()  +"','"+user.getPhone() +"','"+user.getCategory() +"','"+user.getEmail()+"');";
            pstmt=con.prepareStatement(query);
            pstmt.executeUpdate();
          }
 	catch(SQLException e){
           	e.printStackTrace();
          }   
      }
    
    // Update user details
    public void editUserDAO(User user){  
		try {
			 String updateQuery="UPDATE users SET name=?,Location=?,Phone=?,Category=?,email=? Where user_id=?";
			 pstmt = (PreparedStatement) con.prepareStatement(updateQuery);
			 pstmt.setString(1, user.getName());
			 pstmt.setString(2, user.getLocation());
			 pstmt.setString(3, user.getPhone());
			 pstmt.setString(4,user.getCategory());
			 pstmt.setString(5, user.getEmail());
			 pstmt.setInt(6, user.getUserId());
			 pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    
    //Get list of user names
    public List<String> getUserNames(){
		List<String> list=new ArrayList<>();
		try {
			 String query = "SELECT name from users";
			 result=stmt.executeQuery(query);
			 while(result.next()) {
				 list.add(result.getString(1));
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
    
    //Get role corresponding to user
    public String getRole(String userName) {
    	String role="";
    	try {
    		String query="SELECT * from users where name=?";
    		pstmt = con.prepareStatement(query);
    		pstmt.setString(1,userName);
            result=pstmt.executeQuery();
			 while(result.next()) {
				 role=result.getString(5);
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    	
    	return role;
    }
    
 	//Get list of User ids
	public List<Integer> getUserIds(){
		List<Integer> list=new ArrayList<>();
		try {
			 String query = "SELECT user_id from users";
			 result=stmt.executeQuery(query);
			 while(result.next()) {
				 list.add(result.getInt(1));
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
 
}



