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

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//
//		TuitionReimbursementForm form = null;
//		ObjectMapper mapper= new ObjectMapper();
//		//convert JSON to a Java Object
//		//YOU NEED A DEFAULT CONSTRUCTOR IN UR JAVA OBJECT CLASS IN ORDER TO USE THIS!!
//		form=mapper.readValue(request.getInputStream(), TuitionReimbursementForm.class);
//		//System.out.println(form);
//		//Change this to our form reimbursement dao implementation
//		TuitionReimbursementFormDAOImplementation form_implementation = new TuitionReimbursementFormDAOImplementation();
//		try {
//			form_implementation.submitForm(form);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("in doPost");
		
		TuitionReimbursementFormDAOImplementation what = new TuitionReimbursementFormDAOImplementation();
		try {
			what.submitForm(request.getParameter("username"),request.getParameter("employee_first"),request.getParameter("employee_last"), request.getParameter("submit_date"),request.getParameter("start_date"), request.getParameter("submit_time"),request.getParameter("city"),request.getParameter("state"),Integer.parseInt(request.getParameter("zip")),request.getParameter("description"),Double.parseDouble(request.getParameter("class_cost")),Double.parseDouble(request.getParameter("reimbursment_amount")),request.getParameter("passing_grade"),request.getParameter("event_type"),request.getParameter("work_related_justification"),Integer.parseInt(request.getParameter("work_time_missed")),request.getParameter("requested_information"),Boolean.parseBoolean(request.getParameter("optional_info")) );
			RequestDispatcher rs = request.getRequestDispatcher("employee.html");
			rs.forward(request, response);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
