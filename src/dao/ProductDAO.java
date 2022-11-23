package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnectionFactory;
import pojo.Product;

public class ProductDAO {
	private Connection con=null;
	private ResultSet result=null;
	private Statement stmt=null;
	private PreparedStatement pstmt=null;
	
	//Get database connection
	public ProductDAO() {
		try {
			DatabaseConnectionFactory dc=new DatabaseConnectionFactory();
			con=dc.getConnection();
			stmt=con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Get list of all products
	public ResultSet getAllProducts() {
		try {
			String prodQuery="select * from products";
			result=stmt.executeQuery(prodQuery);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//Add new product
	public void addProduct(Product prod) {
		try {
			String addQuery="INSERT INTO products(product_code,product_name,quantity,product_price) VALUES(?,?,?,?)";
			 pstmt = (PreparedStatement) con.prepareStatement(addQuery);
			 pstmt.setString(1, prod.getProductCode());
			 pstmt.setString(2, prod.getProductName());
			 pstmt.setInt(3, prod.getQuantity());
			 pstmt.setDouble(4, prod.getPrice());
			 pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Delete existing product
	public void deleteProduct(Product prod) {
		try {
			String query="delete from products where product_id=?";
			 pstmt = (PreparedStatement) con.prepareStatement(query);
			 pstmt.setInt(1,prod.getProductId());
	         pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Get list of product ids
	public List<Integer> getProductIds(){
		List<Integer> list=new ArrayList<>();
		try {
			 String query = "SELECT product_id from products";
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
	
	//Update product details
	public void updateProduct(Product prod) {
		try {
			 String updateQuery="UPDATE products set product_code=?,product_name=?,quantity=?,product_price=? where product_id=?";
			 pstmt = (PreparedStatement) con.prepareStatement(updateQuery);
			 pstmt.setString(1, prod.getProductCode());
			 pstmt.setString(2, prod.getProductName());
			 pstmt.setInt(3, prod.getQuantity());
			 pstmt.setDouble(4, prod.getPrice());
			 pstmt.setInt(5, prod.getProductId());
			 pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
