package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployee;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.model.DepartmentCrudJDBC;
import com.genesiis.hra.validation.DataValidator;
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
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		AddEmployee addEmployee = new AddEmployee();
		GetDepartment department = new GetDepartment();

		hmap = new HashMap<Integer, Object>();
		hmap.put(1, addEmployee);
		hmap.put(5, department);
		// hmap.put(3, null);
		// hmap.put(4, null);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String task = request.getParameter("task");
		String gson = null;
		int validTask = validator.validTaskId(task);
		try {
			switch (validTask) {
			case 1:
				break;
			case 5:
				GetDepartment department = (GetDepartment) hmap.get(5);
				gson = new Gson().toJson(department.execute());
				response.getWriter().write(gson);
				break;
			// For other operations.
			// case 3:
			// break;
			// case 4:
			// break;
			case -1:
			default:
				break;
			}
		} catch (Exception exception) {
			String message = MessageList.ERROR.message();
			log.error("Exception: EmployeeController " + exception);
			response.getWriter().write(message);
		}
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

		// Method to verify it and return integer;
		int validTask = validator.validTaskId(task);
		Gson gson = new Gson();

		try {
			switch (validTask) {
			case 1:
				AddEmployee addEmployee = (AddEmployee) hmap.get(1);
				message = addEmployee.execute(employeeDetails);
				response.getWriter().write(gson.toJson(message));
				break;
			// For other operations.
			// case 2:
			// break;
			// case 3:
			// break;
			// case 4:
			// break;
			default:
				break;
			}
		} catch (Exception exception) {
			message = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: EmployeeController" + exception);
			response.getWriter().write(gson.toJson(message));
		}
		response.getWriter().close();
	}

}