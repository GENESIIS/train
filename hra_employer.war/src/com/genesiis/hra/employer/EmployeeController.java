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

import com.genesiis.hra.command.AddEducation;
import com.genesiis.hra.command.AddEmployee;
import com.genesiis.hra.command.AddEmployeeDim;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.model.EducationData;
//import com.genesiis.hra.model.DepartmentCrudJDBC;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.Operation;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods completed.
//* 
//***********************************************/

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployeeController.class.getName());
	// HashMap<Operation, ICommand> commands = null;
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		AddEmployeeDim addEmployee = new AddEmployeeDim();
		GetDepartment department = new GetDepartment();
		EducationData education = new EducationData();

		// commands = new HashMap<Operation, ICommand>();
		// commands.put(Operation.ADD_EDU_DETAILS, new AddEmployeeDim());
		hmap = new HashMap<Integer, Object>();
		hmap.put(1, addEmployee);
		hmap.put(5, department);
		// hmap.put(3, education);
		// commands.put(5, department);
		// hmap.put(3, null);
		// hmap.put(4, null);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String employeeDetails = request.getParameter("jsonData");
		// log.info("employeeDetails" + employeeDetails);
		// FamilyMember empgson = new FamilyMember();
		EducationData edu = new EducationData();
		Gson gson = new Gson();
		String message = "";
		try {
			message = edu.getEmployee(1);
			response.getWriter().write(gson.toJson(message));
			log.info("employeeDetails" + edu.getEmployee(Integer.parseInt("1")));
		} catch (Exception ex) {
			message = MessageList.ERROR.message();
			ex.printStackTrace();
			log.error("Exception: doGet" + ex);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String details = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = "";

		// Method to verify it and return integer;
		// int validTask = validator.validTaskId(task);
		// Operation o = Operation.NO_COMMAND;
		// using the task i retrieve the operation o =
		// Operation.fromString(task)

		int validTask = validator.validTaskId(task);
		Gson gson = new Gson();

		try {
			switch (validTask) {
			case 2:

				AddEmployeeDim dim = (AddEmployeeDim) hmap.get(1);
				if ((dim.execute(Operation.ADD_EDU_DETAILS.getValue(), details)) == 3) {
					message = MessageList.ADDED.message();
				}
				response.getWriter().write(gson.toJson(message));
				break;
			default:
				break;
			}
		} catch (Exception exception) {
			message = MessageList.ERROR.message();
			log.error("Exception: EmployeeController" + exception);
		}
		response.getWriter().write(gson.toJson(message));
		response.getWriter().close();
	}

}