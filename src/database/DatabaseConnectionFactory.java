package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionFactory {
	private Connection con = null;
	private String dbhost;
    private String user;
    private String password;
	

	public Connection getConnection(){
        dbhost="jdbc:mysql://localhost:3306/inventory_management_system";
        user="root";
        password="admin";
		
		try {
			con=DriverManager.getConnection(dbhost,user,password);  
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}  
		return con;
	}

}
