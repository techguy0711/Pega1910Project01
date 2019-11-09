package com.revature.daoimpl;
import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.revature.bean.Users;
	import com.revature.conn.ConnFactory;
	
public class UserImpl {
		ConnFactory cf = ConnFactory.getInstance();
		public List<Users> getAllUsers() throws SQLException {
			List<Users> userList = new ArrayList<Users>();
			Connection connection = cf.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from \"user_table\"");
			Users u = null;
			while(rs.next()) {
				u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
				userList.add(u);
			}
			return userList;
		}

		// Pass in user name and password and check it in the database
		// correspond the username and password with the number(0-3) level of restriction
		// grab that value and return it back
		public Users UserAuthenticationValidation(String username, String password) throws SQLException {
			System.out.println("in user authentification");
			Users r = null; 
			Connection c = cf.getConnection();
			Statement stmt = (Statement) c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_table;");
			while (rs.next()) {
				String u = rs.getString(2);
				String pw = rs.getString(3);
				if (u.equals(username) && pw.equals(password)  ) {
					// grab the restriction from this account and return it
					r = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
					System.out.println(r);
					return r;				
				}
			}
			return r;
		}




}
