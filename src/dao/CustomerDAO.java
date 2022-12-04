package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnectionFactory;
import pojo.Customer;
import pojo.User;
import ui.AddCustomerPage;

public class CustomerDAO {
	private Connection con=null;
	private ResultSet result=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
	    
	    // Database connection 
	    public CustomerDAO() {
	        try {
	        	con = new DatabaseConnectionFactory().getConnection();
	        	stmt = con.createStatement();
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Fetch customer details from database
	    public ResultSet getCustomerDAO() {
			try {
				String query="select * FROM customers";
				result=stmt.executeQuery(query);
				System.out.println(query);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	    	      
	    // Add customer details to database
        public void addCustomerDAO(Customer customer) {
            try{
            	String query = "INSERT INTO customers (customer_id, customer_code, customer_name, Location, Phone, email) VALUES ('" + customer.getCustomerId() +"','"+customer.getCustomerCode()+"','"+customer.getName()  +"','"+customer.getLocation() +"','"+customer.getPhone() +"','"+customer.getEmail()+"');";
            	pstmt=con.prepareStatement(query);
            	pstmt.executeUpdate();
            }
            catch(SQLException e){
            	e.printStackTrace();
            }   
        }
        
        // Update customer details in database
        public void editCustomerDAO(Customer customer){  
    		try {
    			 String updateQuery="UPDATE customers SET customer_id=?,customer_name=?,Location=?,Phone=?,customer_code=? Where email=?";
    			 pstmt = (PreparedStatement) con.prepareStatement(updateQuery);
    			 pstmt.setString(1, customer.getCustomerId());
    			 pstmt.setString(2, customer.getName());
    			 pstmt.setString(3, customer.getLocation());
    			 pstmt.setString(4,customer.getPhone());
    			 pstmt.setString(5, customer.getCustomerCode());
    			 pstmt.setString(6, customer.getEmail());
    			 pstmt.executeUpdate();
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}
        
    	//Get list of customer ids
    	public List<String> getCustomerIds(){
    		List<String> list=new ArrayList<>();
    		try {
    			 String query = "SELECT email from customers";
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
}
