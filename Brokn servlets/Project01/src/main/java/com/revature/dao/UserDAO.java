package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Users;

public interface UserDAO {
	public List<Users>getAllUsers() throws SQLException;
	//Returns acount type if user is valid
	public int UserAuthenticationValidation(String username, String password) throws SQLException;

}
