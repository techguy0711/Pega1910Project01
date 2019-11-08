package com.revature.servlet;

import java.awt.List;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoimpl.TuitionReimbursementFormDAOImplementation;
import com.revature.bean.TuitionReimbursementForm;
/**
 * Servlet implementation class FormManager
 */
public class FormManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet");
		PrintWriter writer = response.getWriter();
		writer.append("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>Insert title here</title>" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">" + 
				"</head>");
		writer.append("<body>");

		writer.append("	<table class=\"table\">\r\n" + 
				"	<thead class=\"thead-dark\">\r\n" + 
				"    <tr>\r\n" + 
				"        <th scope=\"col\">#</th>\r\n" + 
				"		<th>Employee_username</td>\r\n" + 
				"		<th>Employee_first</td>\r\n" + 
				"		<th>Employee_last</th>\r\n" + 
				"		<th>City</th>\r\n" + 
				"		<th>State</td>\r\n" + 
				"		<th>Zip</th>\r\n" + 
				"		<th>Description</th>\r\n" + 
				"		<th>Event_type</th>\r\n" + 
				"		<th>Passing_grade</th>\r\n" + 
				"		<th>Reimbursment_amount</th>\r\n" + 
				"		<th>Start_date</th>\r\n" + 
				"		<th>Work_related_justification</th>\r\n" + 
				"		<th>Work_time_missed</th>	\r\n" + 
				"		<th>Submit_date</th>\r\n" + 
				"		<th>Submit_time</th>\r\n" + 
				"		<th>Requested_information</th>\r\n" + 
				"    </tr>" + 
				"  </thead>" + 
				"");
			
		TuitionReimbursementFormDAOImplementation impl = new TuitionReimbursementFormDAOImplementation();
		java.util.List<TuitionReimbursementForm> list;
		try {
			list = impl.getAllForms();
			for(int i =0; i < list.size(); i++){
				writer.append("<tr>");
				writer.append("<th scope=\"row\">"+i+"</th>");
				writer.append("	<td>"+list.get(i).getEmployee_username()+"</td>" + 
						"		<td>"+list.get(i).getEmployee_first()+"</td>" + 
						"		<td>"+list.get(i).getEmployee_last()+"</td>" + 
						"		<td>"+list.get(i).getCity()+"</td>" + 
						"		<td>"+list.get(i).getState()+"</td>" + 
						"		<td>"+list.get(i).getZip()+"</td>" + 
						"		<td>"+list.get(i).getDescription()+"</td>" + 
						"		<td>"+list.get(i).getEvent_type()+"</td>" + 
						"		<td>"+list.get(i).getPassing_grade()+"</td>\r\n" + 
						"		<td>"+list.get(i).getReimbursment_amount()+"</td>\r\n" + 
						"		<td>"+list.get(i).getStart_date()+"</td>" + 
						"		<td>"+list.get(i).getWork_related_justification()+"</td>" + 
						"		<td>"+list.get(i).getWork_time_missed()+"</td>" + 
						"		<td>"+list.get(i).getSubmit_date()+"</td>" + 
						"		<td>"+list.get(i).getSubmit_time()+"</td>\r\n" + 
						"		<td>"+list.get(i).getRequested_information()+"</td>\r\n");
				writer.append("<form id=\"f\" action=\"FormManager\" method = \"POST\">");
				
				writer.append("</form>")
				writer.append("</tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.append("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet");
		if (request.getParameter("Aprove") != null){
		       System.out.println("Aprove");
		 }
		else if (request.getParameter("Deny") != null){
		       System.out.println("Deny");
		 }
	}

}
