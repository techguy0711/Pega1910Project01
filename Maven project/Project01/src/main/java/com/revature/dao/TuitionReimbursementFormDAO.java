package com.revature.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import com.revature.bean.TuitionReimbursementForm;

public interface TuitionReimbursementFormDAO {
	public List<TuitionReimbursementForm>getAllForms() throws SQLException;
	public void submitForm(String firstName, String lastName, String username, String date, String time,
			String city, String state, String zip, String description, Double cost, String gradingFormat,
			String typeOfEvent, String workRelatedJustification, int daysMissedFromWork);
}
