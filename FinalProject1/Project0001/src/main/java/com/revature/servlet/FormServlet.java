package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.TuitionReimbursementForm;
import com.revature.daoimpl.TuitionReimbursementFormDAOImplementation;
import com.revature.daoimpl.UserImpl;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");

		TuitionReimbursementFormDAOImplementation what = new TuitionReimbursementFormDAOImplementation();
		try {
			what.submitForm(username, request.getParameter("employee_first"), request.getParameter("employee_last"),
					request.getParameter("submit_date"), request.getParameter("start_date"),
					request.getParameter("submit_time"), request.getParameter("city"), request.getParameter("state"),
					Integer.parseInt(request.getParameter("zip")), request.getParameter("description"),
					Double.parseDouble(request.getParameter("class_cost")),
					Double.parseDouble(request.getParameter("reimbursment_amount")),
					request.getParameter("passing_grade"), request.getParameter("event_type"),
					request.getParameter("work_related_justification"),
					Integer.parseInt(request.getParameter("work_time_missed")),
					request.getParameter("requested_information"),
					Boolean.parseBoolean(request.getParameter("optional_info")));
			RequestDispatcher rs = request.getRequestDispatcher("employee.html");
			rs.forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
