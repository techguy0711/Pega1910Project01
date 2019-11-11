package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.UserImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		UserImpl what = new UserImpl();
		try {
			if (what.UserAuthenticationValidation(username, password) != null) {
				if (what.UserAuthenticationValidation(username, password).getUser_type() == 0) {
					RequestDispatcher rs = request.getRequestDispatcher("employee.html");
					rs.forward(request, response);
				} else if (what.UserAuthenticationValidation(username, password).getUser_type() == 1) {
					RequestDispatcher rs = request.getRequestDispatcher("DepartmentSupervisor.html");
					rs.forward(request, response);
				} else if (what.UserAuthenticationValidation(username, password).getUser_type() == 2) {
					RequestDispatcher rs = request.getRequestDispatcher("DepartmentHead.html");
					rs.forward(request, response);
				} else if (what.UserAuthenticationValidation(username, password).getUser_type() == 3) {
					RequestDispatcher rs = request.getRequestDispatcher("BenefitsCoordinator.html");
					rs.forward(request, response);
				}
			} else {
				System.out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("home.html");
				rs.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}