package com.revature.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import com.revature.bean.TuitionReimbursementForm;

public interface TuitionReimbursementFormDAO {
	public List<TuitionReimbursementForm>getAllForms() throws SQLException;
	
	public void submitForm(int form_id, String username, String firstName, String lastName, String date, String startDate, String time, String city,
			String state, int zip, String description, Double cost, Double reimbursmentAmount, String gradingFormat, String typeOfEvent,
			String workRelatedJustification, int daysMissedFromWork, String requested_information, boolean ds, boolean dh, boolean dc, boolean optional, boolean finalg) throws SQLException;
		
	public List<TuitionReimbursementForm> getFormsByUsername(String username) throws SQLException;
}
