package com.revature.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TuitionReimbursementFormServlet
 */
public class TuitionReimbursementFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet (reimbursementform)");
		String first_name = request.getParameter("EmployeeFirstFame");
		String last_name = request.getParameter("EmloyeeLastName");
		String username = request.getParameter("EmployeeUsername");
		String date = request.getParameter("Date");
		String time = request.getParameter("Time");
		String city = request.getParameter("City");
		String state = request.getParameter("State");
		String zip = request.getParameter("Zip");
		String description = request.getParameter("Description");
		String gradingformat = request.getParameter("GradingFormat");
		String typeofevent = request.getParameter("TypeOfEvent");
		String workrelatedjustification = request.getParameter("WorkRelatedJustification");
		String timeoffWork = request.getParameter("TimeOffWork");
		String cost = request.getParameter("Cost");
		PrintWriter writer = response.getWriter();
		writer.write(first_name);
		writer.write(last_name);
		writer.write(username);
		writer.write(date);
		writer.write(time);
		writer.write(city);
		writer.write(state);
		writer.write(zip);
		writer.write(description);
		writer.write(gradingformat);
		writer.write(typeofevent);
		writer.write(workrelatedjustification);
		writer.write(timeoffWork);
		writer.write(cost);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost (reimbursementform)");
	}

}
