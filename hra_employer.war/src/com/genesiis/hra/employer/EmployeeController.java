package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployee;
import com.genesiis.hra.model.DepartmentManager;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods compleated.
//* 
//***********************************************/

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployeeController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		try {
			DepartmentManager departmentManager = new DepartmentManager();
			List<String> list = departmentManager.getDepartments();
			String gson = null;
			gson = new Gson().toJson(list);
			response.getWriter().write(gson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String employeetDetails = request.getParameter("jsonData");
		log.info(employeetDetails);
		String task = request.getParameter("task");

		if (task.equalsIgnoreCase(MessageList.ADD.message())) {
			AddEmployee addEmployee = new AddEmployee();
			try {
				String message = addEmployee
						.executeAddemployee(employeetDetails);
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(message));
			} catch (Exception e) {
				log.info("Exception: EmployeeController" + e);
			}
		} else if (task.equalsIgnoreCase(MessageList.UPDATE.message())) {

		} else if ((task.equalsIgnoreCase(MessageList.DELETE.message()))) {

		} else if ((task.equalsIgnoreCase(MessageList.FIND.message()))) {

		} else if ((task.equalsIgnoreCase(MessageList.GETALL.message()))) {

		}
		response.getWriter().close();
	}
}