package com.revature.implementation;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import com.revature.bean.TuitionReimbursementForm;
import com.revature.dao.TuitionReimbursementFormDAO;

public class TuitionReimbursementFormDAOImplementation implements TuitionReimbursementFormDAO{

	@Override
	public List<TuitionReimbursementForm> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitForm(String firstName, String lastName, String username, Date date, Timer time, String city,
			String state, String zip, String description, Double cost, String gradingFormat, String typeOfEvent,
			String workRelatedJustification, int daysMissedFromWork) {
		// TODO Auto-generated method stub
		
	}

}
