package com.revature.servlet;

import java.awt.List;

import java.io.IOException;
import java.io.PrintWriter;
//import java.net.http.HttpRequest;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoimpl.TuitionReimbursementFormDAOImplementation;
import com.revature.daoimpl.UserImpl;
import com.revature.bean.TuitionReimbursementForm;
import com.revature.bean.Users;

public class dsFormManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserImpl impl = new UserImpl();
	TuitionReimbursementFormDAOImplementation formImpl = new TuitionReimbursementFormDAOImplementation();

	public dsFormManager() {
		super();
	}

	String LogedInUser;// Cache the username for the logged in user.

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogedInUser = request.getParameter("username");
		PrintWriter writer = response.getWriter();

		writer.append("	<table class=\"table\" cellspacing=\"10\">" + "	<thead class=\"thead-dark\">" + "    <tr>\r\n"
				+ "        <th scope=\"col\">Form #</th>" + "		<th>Employee Username</td>"
				+ "		<th>Employee Name</th>" + "		<th>City</th>" + "		<th>State</td>"
				+ "		<th>Description</th>" + "		<th>Event Type</th>" + "		<th>Passing Grade</th>"
				+ "		<th>Reimbursment Amount</th>" + "		<th>Start Date</th>\r\n"
				+ "		<th>Work-Related Note</th>" + "		<th>Day(s) Missed</th>" + "		<th>Submit Date</th>"
				+ "    </tr>" + "  </thead>" + "");

		TuitionReimbursementFormDAOImplementation impl = new TuitionReimbursementFormDAOImplementation();
		java.util.List<TuitionReimbursementForm> list;
		try {
			list = impl.getAllForms();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).isDs_approval() == false) {
					writer.append("<tr>");
					writer.append("<th scope=\"row\">" + list.get(i).getForm_id() + "</th>");
					writer.append("	<td>" + list.get(i).getEmployee_username() + "</td>" + "		<td>"
							+ list.get(i).getEmployee_first() + " " + list.get(i).getEmployee_last() + "</td>"
							+ "		<td>" + list.get(i).getCity() + "</td>" + "		<td>" + list.get(i).getState()
							+ "</td>" + "		<td>" + list.get(i).getDescription() + "</td>" + "		<td>"
							+ list.get(i).getEvent_type() + "</td>" + "		<td>" + list.get(i).getPassing_grade()
							+ "</td>" + "		<td>" + list.get(i).getReimbursment_amount() + "</td>" + "		<td>"
							+ list.get(i).getStart_date() + "</td>" + "		<td>"
							+ list.get(i).getWork_related_justification() + "</td>" + "		<td>"
							+ list.get(i).getWork_time_missed() + "</td>" + "		<td>" + list.get(i).getSubmit_date()
							+ "</td>");
					writer.append("</tr>");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		writer.append("</table>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			java.util.List<Users> list = impl.getAllUsers();
			if (request.getParameter("Accept") != null) {
				String selectedRow = request.getParameter("row");
				int roww = Integer.parseInt(selectedRow);
				formImpl.DS_Aproval(roww, true);

				RequestDispatcher rs = request.getRequestDispatcher("DepartmentSupervisor.html");
				rs.forward(request, response);
			} else if (request.getParameter("Decline") != null) {
				String selectedRow = request.getParameter("row");
				int roww = Integer.parseInt(selectedRow);
				formImpl.DS_Aproval(roww, false);
				RequestDispatcher rs = request.getRequestDispatcher("DepartmentSupervisor.html");
				rs.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
}