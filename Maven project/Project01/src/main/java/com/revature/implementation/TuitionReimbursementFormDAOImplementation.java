package com.revature.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import com.revature.bean.TuitionReimbursementForm;
import com.revature.bean.Users;
import com.revature.conn.ConnFactory;
import com.revature.dao.TuitionReimbursementFormDAO;

public class TuitionReimbursementFormDAOImplementation implements TuitionReimbursementFormDAO{

	@Override
	public List<TuitionReimbursementForm> getAllForms() throws SQLException {
		ConnFactory cf = ConnFactory.getInstance();
			List<TuitionReimbursementForm> formsList = new ArrayList<TuitionReimbursementForm>();
			Connection connection = cf.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from \"tuitionreimbursementforms\"");
			TuitionReimbursementForm f = null;
			while(rs.next()) {
				f = new TuitionReimbursementForm(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(15), rs.getDouble(14), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13));
				formsList.add(f);
			}
			return formsList;
	}

	@Override
	public void submitForm(String firstName, String lastName, String username, String date, String time, String city,
			String state, String zip, String description, Double cost, String gradingFormat, String typeOfEvent,
			String workRelatedJustification, int daysMissedFromWork) throws SQLException{
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn= cf.getConnection();
		String sql= "insert into tuitionreimbursementforms values(nextval (\'reimbusseq\'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, username);
		ps.setString(4, date);
		ps.setString(5, time);
		ps.setString(6, city);
		ps.setString(7, state);
		ps.setString(8, zip);
		ps.setString(9, gradingFormat);
		ps.setString(10, typeOfEvent);
		ps.setString(11, workRelatedJustification);
		ps.setInt(12, daysMissedFromWork);
		ps.setDouble(13, cost);
		ps.setString(14, description);
		ps.executeUpdate();
	}
}
