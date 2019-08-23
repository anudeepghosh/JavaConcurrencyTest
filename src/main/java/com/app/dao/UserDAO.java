package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.beans.User;

/**
 * @author Anudeep
 *
 */
public class UserDAO {
	
	public int saveUser(User user) {
		Connection connection = DBConnection.getConnection();
		int rows=0;
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO USER VALUES(?,?,?)");
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmailID());
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return rows;
	}
}
