package com.genesiis.hra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genesiis.hra.model.IEmployeeDaoLocal;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/AddEmployeeDetails")
public class AddEmployeeDetails extends HttpServlet {
	@EJB
	private IEmployeeDaoLocal employeeDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String employeeNumber = request.getParameter("employeeNumber");
		System.out.print(employeeNumber);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	
}
