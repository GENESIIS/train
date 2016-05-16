package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.UpdateEmployee;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.UpdateEmployeeDim;
import com.genesiis.hra.model.FamilyMember;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods completed.
//* 20160430 PN HRA-1 doGet() method modified to get the details from the table.
//***********************************************/

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployeeController.class.getName());
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		UpdateEmployee addEmployee = new UpdateEmployee();
		GetDepartment department = new GetDepartment();

		hmap = new HashMap<Integer, Object>();
		hmap.put(1, addEmployee);
		hmap.put(5, department);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String employeeDetails = request.getParameter("jsonData");
		log.info("employeeDetails" + employeeDetails);
		FamilyMember empgson = new FamilyMember();
		String message = "";
		Gson gson = new Gson();

		try {
			message = empgson.getEmployee(Integer.parseInt(employeeDetails));
			log.info("employeeDetails"
					+ empgson.getEmployee(Integer.parseInt(employeeDetails)));
		} catch (Exception ex) {
			log.error("Exception: doGet" + ex);
			message = MessageList.ERROR.message();
		}//
		response.getWriter().write(gson.toJson(message));
		response.getWriter().close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String employeeDetails = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = "";
		Gson gson = new Gson();

		try {
			UpdateEmployeeDim dim = new UpdateEmployeeDim();
			int result = dim.execute(task, employeeDetails);
			if (result == 1) {
				message = MessageList.ADDED.message();
			} else {
				message = MessageList.FAILED_TO_CREATE.message();
			}
		} catch (Exception exception) {
			message = MessageList.ERROR.message();
			log.error("Exception: EmployeeController" + exception);

		}
		response.getWriter().write(gson.toJson(message));
		response.getWriter().close();
	}

	public Object extractFromJason(String className, String gsonData)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Gson gson = new Gson();
		Class<?> clazz = Class.forName(className);
		Object object = clazz.newInstance();
		try {
			object = gson.fromJson(gsonData, clazz);
		} catch (Exception e) {
			log.error("ExtractFromgson - Exception " + e);
		}
		return object;
	}

}