/**
 * 
 */
package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anudeep
 *
 */
public class DBConnection {

	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testthreadapi?"
					+ "user=root&password=root");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Instantiation Error", e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Illegal Access Error", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Class Not Found", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "SQL Error", e);
		}
		return connection;
		
	}
}
