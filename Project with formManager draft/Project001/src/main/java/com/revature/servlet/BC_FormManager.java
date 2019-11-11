package com.revature.servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bean.TuitionReimbursementForm;
import com.revature.bean.Users;
import com.revature.daoimpl.TuitionReimbursementFormDAOImplementation;
import com.revature.daoimpl.UserImpl;

/**
 * Servlet implementation class BC_FormManager
 */
public class BC_FormManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserImpl impl = new UserImpl();
	TuitionReimbursementFormDAOImplementation formImpl = new TuitionReimbursementFormDAOImplementation();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BC_FormManager() {
        super();
        // TODO Auto-generated constructor stub
    }

    String LogedInUser;//Cache the username for the logged in user.
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("In doGet");
 	    LogedInUser =  request.getParameter("username");
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
 				if(list.get(i).isFinal_approval() == false) {
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
 				writer.append("</tr>");
 				}
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		writer.append("</table>");
 		writer.append("<form action = \"FormManager\" method = \"POST\">"
 				+ "<input type=\"text\" name = \"row\" value=\"row\">"+
 				 "<br><input type=\"text\" name = \"Approved Cost\" value=\"Approved Cost\">"+
 				"<br><input type=\"submit\" name = \"Accept\" value=\"Accept\">" + 
 				"<span><input type=\"submit\" name = \"Decline\" value=\"Decline\">"	);
 				
 		writer.append("</body>");
 		writer.append("</html>");
 	}

 	/**
 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 	 */
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		//UserImpl impl = new UserImpl();
 		//TuitionReimbursementFormDAOImplementation formImpl = new TuitionReimbursementFormDAOImplementation();
 		try {
 			java.util.List<Users> list = impl.getAllUsers();
 			if (request.getParameter("Accept") != null){
 			       System.out.println("Accept");
 			       for (Users users : list) {
 			    	   //Bind selection to variable
 			    	   String SelectedUser = null;
 						String selectedRow = request.getParameter("row");
 						System.out.println(selectedRow);
 					if(users.getUser_username().equals(LogedInUser)) {
 						System.out.println("IN method");
 						if(users.getUser_type() == 0) {
 							//Employees can only view not accept or decline
 						}						
 						if(users.getUser_type() == 1) {
 							formImpl.DS_Aproval(selectedRow, true);
 							RequestDispatcher rs = request.getRequestDispatcher("BC_FormManager");
 							rs.forward(request, response);
 						}
 						if(users.getUser_type() == 2) {
 							formImpl.DH_Aproval(selectedRow, true);
 							RequestDispatcher rs = request.getRequestDispatcher("BC_FormManager");
 							rs.forward(request, response);
 						}
 						if(users.getUser_type() == 3) {
 							formImpl.BC_Aproval(selectedRow, true);
 							formImpl.DH_Aproval(selectedRow, true);
 							formImpl.DS_Aproval(selectedRow, true);
 							//update employee reimbusment ammount available
 							double approvedAmt = Integer.parseInt(request.getParameter("Approved Cost"));
 							UserImpl userImpl = new UserImpl();
 							TuitionReimbursementFormDAOImplementation tform = new TuitionReimbursementFormDAOImplementation();
 							java.util.List<TuitionReimbursementForm> f = tform.getAllForms();
 							for (TuitionReimbursementForm form : f) {
								if(form.getForm_id() == Integer.parseInt(selectedRow)) {
		 							userImpl.updateBalance(approvedAmt, form.getEmployee_first());
		 							//System.out.println("\n\n"++"\n\n");
								}
							}
 							RequestDispatcher rs = request.getRequestDispatcher("BC_FormManager");
 							rs.forward(request, response);
 						}												
 					}
 				}
 			       
 			 }
 			else if (request.getParameter("Decline") != null){
 			       System.out.println("Decline");
 					for (Users users : list) {
 						String selectedRow = request.getParameter("row");
 						if(users.getUser_username().equals(LogedInUser)) {
 							System.out.println("Test");
 							if(users.getUser_type() == 0) {
 								//Employees can only view not accept or decline
 							}						
 							if(users.getUser_type() == 1) {
 								formImpl.DS_Aproval(selectedRow, false);
 								RequestDispatcher rs = request.getRequestDispatcher("BC_FormManager");
 								rs.forward(request, response);
 							}
 							if(users.getUser_type() == 2) {
 								formImpl.DH_Aproval(selectedRow, false);
 								RequestDispatcher rs = request.getRequestDispatcher("BC_FormManager");
 								rs.forward(request, response);
 							}
 							if(users.getUser_type() == 3) {
 								formImpl.BC_Aproval(selectedRow, false);
 								formImpl.DH_Aproval(selectedRow, false);
 								formImpl.DS_Aproval(selectedRow, false);
 								RequestDispatcher rs = request.getRequestDispatcher("BC_FormManager");
 								rs.forward(request, response);
 							}												
 						}
 					}
 			 }
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		doGet(request, response);	
 		System.out.println("In doGet");
 	}
}