package com.hra.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hra.controller.EmployeeDetailsController;
import com.hra.dao.Employee;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/AddEmployeeDetails")
public class AddEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			// Catch the values coming through the manageEmployee.jsp
			String employeeNumber = request.getParameter("employeeNumber");
			String employeeName = request.getParameter("employeeName");
			String employeeDesignation = request
					.getParameter("employeeDesignation");
			String employeeDateofBoth = request
					.getParameter("employeeDateofBoth");
			String employeeGender = request.getParameter("employeeGender");
			String employeeAddress = request.getParameter("employeeAddress");
			String employeeMobileNumber = request
					.getParameter("employeeMobileNumber");
			String employeeOtherNumber = request
					.getParameter("employeeOtherNumber");
			String employeeEmail = request.getParameter("employeeEmail");
			String employeeDepartment = request
					.getParameter("employeeDepartment");
			String employeeJoinDate = request.getParameter("employeeJoinDate");

			Employee employee = new Employee();
			employee.setDateOfJoin(employeeJoinDate);
			employee.setEmployeeID(employeeNumber);
			employee.setEmployeeName(employeeName);
			employee.setEmployeeDesignation(employeeDesignation);
			employee.setEmployeeDOB(employeeDateofBoth);
			employee.setEmployeeGender(employeeGender);
			employee.setEmployeeAddress(employeeAddress);
			employee.setEmployeeMobileNO(employeeMobileNumber);
			employee.setEmployeeOtherNO(employeeOtherNumber);
			employee.setDepartmentID(employeeDepartment);
			employee.setEmployeeEmail(employeeEmail);

			EmployeeDetailsController empController = new EmployeeDetailsController();
			boolean status = empController.inserEmployeeDetails(employee);

			if (status) {
				response.getWriter().write("Success");
			} else {
				response.getWriter().write("False");
			}

		} catch (Exception e) {

		}
	}

}
