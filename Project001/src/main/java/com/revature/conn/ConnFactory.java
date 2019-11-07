package com.revature.conn;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnFactory {
	private static ConnFactory cF = new ConnFactory();
	//private no args constructor
	private ConnFactory () {
		super();
	}
	//public static synchronized getter method
	public static synchronized ConnFactory getInstance() {
		if(cF==null) {
			cF = new ConnFactory();
		}
		return cF;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties properties = new Properties();
			try {
				properties.load(new FileReader("database.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:postgresql://project01.cf7qnxamadjf.us-east-2.rds.amazonaws.com/postgres","Pega1019ProjectOne", "C0delikeab055");
		} catch (SQLException e) {
			System.out.println("Failed to create connection");
			e.printStackTrace();
		}
		return conn;
	}
	
}
