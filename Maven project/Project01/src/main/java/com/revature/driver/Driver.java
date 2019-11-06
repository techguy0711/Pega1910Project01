package com.revature.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.bean.TuitionReimbursementForm;
import com.revature.implementation.TuitionReimbursementFormDAOImplementation;

public class Driver {
	
	public static void main(String[] args)throws SQLException, FileNotFoundException, IOException {
		ArrayList<TuitionReimbursementForm> listOfForms = new ArrayList<TuitionReimbursementForm>();
		TuitionReimbursementFormDAOImplementation adi = new TuitionReimbursementFormDAOImplementation();


		for (TuitionReimbursementForm cust : adi.getAllForms()) {
			cust.toString();
		}
	}

}
