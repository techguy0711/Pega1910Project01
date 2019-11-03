package com.revature.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Users;
import com.revature.conn.ConnFactory;
import com.revature.dao.UserDAO;

public class UserDAOImplementation implements UserDAO {
	ConnFactory cf = ConnFactory.getInstance();
	public List<Users> getAllUsers() throws SQLException {
		List<Users> userList = new ArrayList<Users>();
		Connection connection = cf.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from \"users\"");
		Users u = null;
		while(rs.next()) {
			u = new Users(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(3));
			userList.add(u);
		}
		return userList;
	}

	public String UserAuthenticationValidation(String username, String password) throws SQLException {
		return null;//TODO Create logic
	}
	public static void main(String[] args) {
		UserDAOImplementation userDAOImpl = new UserDAOImplementation();
		try {
			System.out.println(userDAOImpl.getAllUsers().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
