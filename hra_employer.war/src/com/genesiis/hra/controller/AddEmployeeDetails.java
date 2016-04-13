package com.genesiis.hra.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeDao;
import com.genesiis.hra.model.IEmployeeDaoLocal;


/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/AddEmployeeDetails")
public class AddEmployeeDetails extends HttpServlet {
	@EJB
	private IEmployeeDaoLocal employeeDao;
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(AddEmployeeDetails.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String employeeNumber = request.getParameter("jsonData");
		String message ="";
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

			//convert the json string back to object
			Employee employee = gson.fromJson(br, Employee.class);
			EmployeeDao employeeDao = new EmployeeDao();
			message = employeeDao.addEmployee(employee);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		response.getWriter().write(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
