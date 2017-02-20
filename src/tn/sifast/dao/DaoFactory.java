package tn.sifast.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DaoFactory {
	    private String url;
	    private String username;
	    private String password;

	    DaoFactory(String url, String username, String password) {
	        this.url = url;
	        this.username = username;
	        this.password = password;
	    }

	    public static DaoFactory getInstance() {
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	           
	           
	        } catch (ClassNotFoundException e) {

	        }
	          String url = "jdbc:mysql://127.0.0.1:3306/sifast?useSSL=false";
		      String user = "root";
		      String passwd = "toor";;
		   

	        DaoFactory instance = new DaoFactory(url,user, passwd);
	        return instance;
	    }

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }

	     
	     public IngenieurDao getIngenieurDao() {
	        return new IngenieurDaoImpl(this);
	    } 
	   
	

}
