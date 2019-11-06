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
				f = new TuitionReimbursementForm(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getString(14), rs.getString(15), rs.getString(16),rs.getInt(17), rs.getString(18), rs.getBoolean(19),rs.getBoolean(20),rs.getBoolean(21),rs.getBoolean(22), rs.getBoolean(23));
				formsList.add(f);
			}
			return formsList;
	}
	
	@Override
	public List<TuitionReimbursementForm> getFormsByUsername(String username) throws SQLException {
		ConnFactory cf = ConnFactory.getInstance();
			List<TuitionReimbursementForm> formsList = new ArrayList<TuitionReimbursementForm>();
			Connection connection = cf.getConnection();
			String sql = "select * from \\\"tuitionreimbursementforms\\\" where \\\"employee_username\\\" = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			TuitionReimbursementForm f = null;
			while(rs.next()) {
				f = new TuitionReimbursementForm(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getString(14), rs.getString(15), rs.getString(16),rs.getInt(17), rs.getString(18), rs.getBoolean(19),rs.getBoolean(20),rs.getBoolean(21),rs.getBoolean(22), rs.getBoolean(23));
				formsList.add(f);
			}
			return formsList;
	}
	

	@Override
	public void submitForm(int form_id, String username, String firstName, String lastName, String date, String startDate, String time, String city,
			String state, int zip, String description, Double cost, Double reimbursmentAmount, String gradingFormat, String typeOfEvent,
			String workRelatedJustification, int daysMissedFromWork, String requested_information, boolean ds, boolean dh, boolean dc, boolean optional, boolean finals) throws SQLException{
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn= cf.getConnection();
		String sql= "insert into tuitionreimbursementforms values(nextval (\'reimbusseq\'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, form_id);
		ps.setString(2, username);
		ps.setString(3, firstName);
		ps.setString(4, lastName);		
		ps.setString(5, date);
		ps.setString(6, startDate);
		ps.setString(7, time);
		ps.setString(8, city);
		ps.setString(9, state);
		ps.setInt(10, zip);
		ps.setString(11, description);
		ps.setDouble(12, cost);
		ps.setDouble(13, reimbursmentAmount);
		ps.setString(14, gradingFormat);
		ps.setString(15, typeOfEvent);
		ps.setString(16, workRelatedJustification);
		ps.setInt(17, daysMissedFromWork);		
		ps.setString(18, requested_information);
		ps.setBoolean(19, ds);
		ps.setBoolean(20, dh);
		ps.setBoolean(21, dc);
		ps.setBoolean(22, optional);
		ps.setBoolean(23, finals);
		ps.executeUpdate();
	}
}
