package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.bean.TuitionReimbursementForm;
import com.revature.bean.Users;
import com.revature.daoimpl.TuitionReimbursementFormDAOImplementation;
import com.revature.daoimpl.UserImpl;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append("	<table class=\"table\" cellspacing=\"10\">" + "    <tr>" + "       <th scope=\"col\">#</th>"
				+ "		<th>Name</td>" + "		<th>Event Type</th>" + "		<th>Grade</th>"
				+ "		<th>Reimbursement Amount</th>" + "		<th>Start Date</th>" + "		<th>Submit Date</th>"
				+ "		<th>Submit Time</th>" + "		<th>Status</th>" + "    </tr>");
		TuitionReimbursementFormDAOImplementation impl = new TuitionReimbursementFormDAOImplementation();
		java.util.List<TuitionReimbursementForm> list;
		try {
			list = impl.getAllForms();
			UserImpl user = new UserImpl();
			List<Users> userr = new ArrayList<Users>();
			userr = user.getAllUsers();
			for (int j = 0; j < userr.size(); j++) {
				String username = (String) request.getSession().getAttribute("username");
				if (userr.get(j).getUser_username().equals(username)) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getEmployee_username().equals(username)) {

							if (list.get(i).isBc_approval() == true && list.get(i).isDh_approval() == true
									&& list.get(i).isDs_approval() == true) {

								writer.append("<tr style = \" background-color:#58D68D;\">");
								writer.append("<th  scope=\"row\">" + list.get(i).getForm_id() + "</th>");
								writer.append("	<td>" + list.get(i).getEmployee_first() + " "
										+ list.get(i).getEmployee_last() + "</td>" + "		<td>"
										+ list.get(i).getEvent_type() + "</td>" + "		<td>"
										+ list.get(i).getPassing_grade() + "</td>" + "		<td>"
										+ list.get(i).getReimbursment_amount() + "</td>" + "		<td>"
										+ list.get(i).getStart_date() + "</td>" + "		<td>"
										+ list.get(i).getSubmit_date() + "</td>" + "		<td>"
										+ list.get(i).getSubmit_time() + "</td>");
								if (list.get(i).isFinal_approval()) {
									writer.append("<td>" + "Accepted" + "</td>");
								} else {
									writer.append("<td>" + "Pending" + "</td>");
								}
								writer.append("</tr>");
							} else {
								writer.append("<tr>");
								writer.append("<th  scope=\"row\">" + list.get(i).getForm_id() + "</th>");
								writer.append("	<td>" + list.get(i).getEmployee_first() + " "
										+ list.get(i).getEmployee_last() + "</td>" + "		<td>"
										+ list.get(i).getEvent_type() + "</td>" + "		<td>"
										+ list.get(i).getPassing_grade() + "</td>" + "		<td>"
										+ list.get(i).getReimbursment_amount() + "</td>" + "		<td>"
										+ list.get(i).getStart_date() + "</td>" + "		<td>"
										+ list.get(i).getSubmit_date() + "</td>" + "		<td>"
										+ list.get(i).getSubmit_time() + "</td>");
								if (list.get(i).isFinal_approval()) {
									writer.append("<td>" + "Accepted" + "</td>");
								} else {
									writer.append("<td>" + "Pending" + "</td>");
								}
								writer.append("</tr>");
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}