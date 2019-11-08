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

	//@Override
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
	
	//@Override
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
//	int form_id, String username, String firstName, String lastName, String date, String startDate, String time, String city,
//	String state, int zip, String description, Double cost, Double reimbursmentAmount, String gradingFormat, String typeOfEvent,
//	String workRelatedJustification, int daysMissedFromWork, String requested_information, boolean ds, boolean dh, boolean dc, boolean optional, boolean finals


	public void submitForm(String username, String firstName, String lastName, String date, String startDate, String time, String city,
			String state, int zip, String description, Double cost, Double reimbursmentAmount, String gradingFormat, String typeOfEvent,
			String workRelatedJustification, int daysMissedFromWork, String requested_information, boolean optional) throws SQLException{
		ConnFactory cf = ConnFactory.getInstance();
		Connection conn= cf.getConnection();
		String sql= "insert into form_table values(nextval (\'custseq\'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		//ps.setInt(1, form_id);
		ps.setString(1, username);
		ps.setString(2, firstName);
		ps.setString(3, lastName);		
		ps.setString(4, date);
		ps.setString(5, startDate);
		ps.setString(6, time);
		ps.setString(7, city);
		ps.setString(8, state);
		ps.setInt(9,zip);
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
	
	
	
	//@Override
//	public void submitForm(TuitionReimbursementForm form) throws SQLException{
//		ConnFactory cf = ConnFactory.getInstance();
//		Connection conn= cf.getConnection();
//		String sql= "insert into form_table values(nextval (\'custseq\'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		PreparedStatement ps= conn.prepareStatement(sql);
//		//ps.setInt(1, form_id);
//		ps.setString(2, form.getEmployee_username());
//		ps.setString(3, form.getEmployee_first());
//		ps.setString(4, form.getEmployee_last());		
//		ps.setString(5, form.getSubmit_date());
//		ps.setString(6, form.getStart_date());
//		ps.setString(7, form.getSubmit_time());
//		ps.setString(8, form.getCity());
//		ps.setString(9, form.getState());
//		ps.setInt(10, form.getZip());
//		ps.setString(11, form.getDescription());
//		ps.setDouble(12, form.getClass_cost());
//		ps.setDouble(13, form.getReimbursment_amount());
//		ps.setString(14, form.getPassing_grade());
//		ps.setString(15, form.getEvent_type());
//		ps.setString(16, form.getWork_related_justification());
//		ps.setInt(17, form.getWork_time_missed());		
//		ps.setString(18, form.getRequested_information());
//		ps.setBoolean(19, false);
//		ps.setBoolean(20, false);
//		ps.setBoolean(21, false);
//		ps.setBoolean(22, form.isOptional_info());
//		ps.setBoolean(23, false);
//		ps.executeUpdate();
//	}
}
