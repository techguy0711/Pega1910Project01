package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.implementation.UserDAOImplementation;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		UserDAOImplementation what = new UserDAOImplementation();
		try {
			if (what.UserAuthenticationValidation(username, password) != null) {
				if (what.UserAuthenticationValidation(username, password).getUser_id() == 0) {
					System.out.println(0);
					RequestDispatcher rs = request.getRequestDispatcher("Employee.html");
					rs.forward(request, response);
				} else if (what.UserAuthenticationValidation(username, password).getUser_id() == 1) {
					System.out.println(1);
					RequestDispatcher rs = request.getRequestDispatcher("DepartmentSupervisor.html");
					rs.forward(request, response);
				} else if (what.UserAuthenticationValidation(username, password).getUser_id() == 2) {
					System.out.println(2);
					RequestDispatcher rs = request.getRequestDispatcher("DepartmentHead.html");
					rs.forward(request, response);
				} else if (what.UserAuthenticationValidation(username, password).getUser_id() == 3) {
					System.out.println(3);
					RequestDispatcher rs = request.getRequestDispatcher("BenefitsCoordinator.html");
					rs.forward(request, response);
				}
			} else {
				System.out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("home.html");
				rs.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
