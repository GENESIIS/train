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
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.command.UpdateEmployee;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.ICommandAJX;
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
	HashMap<Operation, ICommandAJX> commands = null;
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		// UpdateEmployee addEmployee = new UpdateEmployee();
		// GetDepartment department = new GetDepartment();
		// EducationData education = new EducationData();

		// commands = new HashMap<Operation, ICommand>();
		// commands.put(Operation.ADD_EDU_DETAILS, new AddEmployeeDim());
		// hmap = new HashMap<Integer, Object>();
		// hmap.put(1, addEmployee);
		// hmap.put(5, department);
		// hmap.put(3, education);
		// commands.put(5, department);
		// hmap.put(3, null);
		// hmap.put(4, null);
		commands = new HashMap<Operation, ICommandAJX>();
		commands.put(Operation.BASIC_DATA, new UpdateEmployee());
		commands.put(Operation.BASIC_DATA, new GetEmployee());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
		// response.setContentType("application/json");
		// String employeeDetails = request.getParameter("jsonData");
		// // log.info("employeeDetails" + employeeDetails);
		// // FamilyMember empgson = new FamilyMember();
		//
		// EducationData edu = new EducationData();
		// Gson gson = new Gson();
		// String message = "";
		// try {
		//
		// message = edu.getEmployee(1);
		// response.getWriter().write(message);
		// // log.info("employeeDetails" +
		// // edu.getEmployee(Integer.parseInt("1")));
		// log.info(message);
		// } catch (Exception ex) {
		// message = MessageList.ERROR.message();
		// ex.printStackTrace();
		// log.error("Exception: doGet" + ex);
		//
		// }
		// response.getWriter().close();

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
		Operation o = Operation.BAD_OPERATION;
		// using the task i retrieve the operation o =
		o = Operation.getOperation(task);

		// int validTask = validator.validTaskId(task);
		Gson gson = new Gson();
		try {
			switch (o) {
			case ADD_EDU_DETAILS:
				message = commands.get(o).execute(details);
				break;
			case FAMILY_MEMBER:
				message = commands.get(o).execute(details);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			message = MessageList.ERROR.message();
			log.error("Employee Controloler error " + e);
		}

		writeResponse(gson.toJson(message), response);
		// try {
		// switch (validTask) {
		// case 2:
		//
		// UpdateEmployee dim = (UpdateEmployee) hmap.get(1);
		// if ((dim.execute(Operation.ADD_EDU_DETAILS.getValue(), details)) ==
		// "EDU") {
		// message = MessageList.ADDED.message();
		// }
		// response.getWriter().write(gson.toJson(message));
		// break;
		// default:
		// break;
		// }
		// } catch (Exception exception) {
		// message = MessageList.ERROR.message();
		// log.error("Exception: EmployeeController" + exception);
		// }

	}

	private void writeResponse(String message, HttpServletResponse response)
			throws IOException {
		try {
			response.getWriter().write(message);
		} catch (Exception e) {
			log.error("WriteResponse method error. " + e);
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}

	}

}