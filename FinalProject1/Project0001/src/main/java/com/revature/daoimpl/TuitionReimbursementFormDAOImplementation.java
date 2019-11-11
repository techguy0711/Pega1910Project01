package com.revature.daoimpl;

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

public class TuitionReimbursementFormDAOImplementation {

	// @Override
	public List<TuitionReimbursementForm> getAllForms() throws SQLException {
		ConnFactory cf = ConnFactory.getInstance();
		List<TuitionReimbursementForm> formsList = new ArrayList<TuitionReimbursementForm>();
		Connection connection = cf.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from \"form_table\"");
		TuitionReimbursementForm f = null;
		while (rs.next()) {
			f = new TuitionReimbursementForm(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
					rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getString(14), rs.getString(15),
					rs.getString(16), rs.getInt(17), rs.getString(18), rs.getBoolean(19), rs.getBoolean(20),
					rs.getBoolean(21), rs.getBoolean(22), rs.getBoolean(23));
			formsList.add(f);
		}
		return formsList;
	}

	public void submitForm(String username, String firstName, String lastName, String date, String startDate,
			String time, String city, String state, int zip, String description, Double cost, Double reimbursmentAmount,
			String gradingFormat, String typeOfEvent, String workRelatedJustification, int daysMissedFromWork,
			String requested_information, boolean optional) throws SQLException {
		ConnFactory cf = ConnFactory.getInstance();

		Connection conn = cf.getConnection();
		String sql = "insert into form_table values(nextval (\'empseq\'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ps.setInt(1, form_id);
		ps.setString(1, username);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, date);
		ps.setString(5, startDate);
		ps.setString(6, time);
		ps.setString(7, city);
		ps.setString(8, state);
		ps.setInt(9, zip);
		ps.setString(10, description);
		ps.setDouble(11, cost);
		ps.setDouble(12, reimbursmentAmount);
		ps.setString(13, gradingFormat);
		ps.setString(14, typeOfEvent);
		ps.setString(15, workRelatedJustification);
		ps.setInt(16, daysMissedFromWork);
		ps.setString(17, requested_information);
		ps.setBoolean(18, false);
		ps.setBoolean(19, false);
		ps.setBoolean(20, false);
		ps.setBoolean(21, optional);
		ps.setBoolean(22, false);
		ps.executeUpdate();
	}

	// Aproval functions

	public void DS_Aproval(int aproveUser, boolean Approval) {
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn = cf.getConnection();
		String sql = "UPDATE form_table SET ds_approval = ? WHERE form_id = ?";
		try {
			System.out.println(aproveUser + " -> Connected");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, Approval);
			ps.setInt(2, aproveUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void DH_Aproval(int aproveUser, boolean Approval) {
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn = cf.getConnection();
		String sql = "UPDATE form_table SET dh_approval = ? WHERE form_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, Approval);
			ps.setInt(2, aproveUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void BC_Aproval(int aproveUser, boolean Approval) {
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn = cf.getConnection();
		String sql = "UPDATE form_table SET bc_approval = ? WHERE form_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, Approval);
			ps.setInt(2, aproveUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Final_Aproval(String aproveUser, boolean Approval) {
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn = cf.getConnection();
		String sql = "UPDATE form_table SET final_approval = ? WHERE employee_username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, Approval);
			ps.setString(2, aproveUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}