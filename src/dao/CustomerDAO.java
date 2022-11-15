package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DatabaseConnectionFactory;
import pojo.Customer;

public class CustomerDAO {
		private Connection connect = null;
		private PreparedStatement prepStatement = null;
		private Statement statement = null;
		private ResultSet rs = null;
	    
	    // Database connection 
	    public CustomerDAO() {
	        try {
	        	connect = new DatabaseConnectionFactory().getConnection();
	         	statement = connect.createStatement();
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Fetch customer details from database
	    public ResultSet getCustomerDAO() {
            try{
            	String query = "SELECT customer_id, customer_code, customer_code, Location, Phone, email FROM customers;";  
            	rs=statement.executeQuery(query);
                while(rs.next())  
           		System.out.println(rs.getString(2));
            }
            catch(SQLException e){
            	e.printStackTrace();
            }
			return rs;
        }
        
	    // Add customer details to database
        public void addCustomerDAO(Customer customer) {
            try{
            	String query = "INSERT INTO customers (customer_id, customer_code, customer_name, Location, Phone, email) VALUES ('" + customer.getCustomerId() +"','"+customer.getCustomerCode()+"','"+customer.getName()  +"','"+customer.getLocation() +"','"+customer.getPhone() +"','"+customer.getEmail()+"');";
            	prepStatement=connect.prepareStatement(query);
            	prepStatement.executeUpdate();
            }
            catch(SQLException e){
            	e.printStackTrace();
            }   
        }
   
        // Update customer details to database
        public void editCustomerDAO(Customer customer){        
        	try{
        		String query = "UPDATE customers SET customer_id='"+ customer.getCustomerId()+"', customer_code='"+customer.getCustomerCode()+"', customer_name='"+ customer.getName()+"', Location='" +customer.getLocation() +"', Phone ='"+ customer.getPhone()+"' WHERE email='"+customer.getEmail() + "';";
        		prepStatement = connect.prepareStatement(query);
        		prepStatement.executeUpdate(query);
        	}	
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }
}
