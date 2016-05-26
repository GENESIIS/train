package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployeeHistory;
import com.genesiis.hra.command.AddMedicalHistory;
import com.genesiis.hra.command.AddMedicalReport;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.GetEmploymentHistory;
import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.command.UpdateEmployee;
import com.genesiis.hra.command.UpdateEmployeeHistory;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmploymentHistory;
import com.genesiis.hra.validation.AilmentEnum;
import com.genesiis.hra.validation.ClassList;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
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

	HashMap<Operation, ICommand> commands = null;

	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		// initialize the commands
		commands = new HashMap<Operation, ICommand>();
		commands.put(Operation.ADD_MEDICAL_HISTORY, new AddMedicalHistory());// MEDICAL_HISTORY==7
		commands.put(Operation.ADD_MEDICAL_REPORT, new AddMedicalReport());// MEDICAL_REPORT==10
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get the retrieve the operation from the task . initialization only
		Operation operation = Operation.BAD_OPERATION;
				
		String details = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = "";

		operation = Operation.getOperation(task);

		Gson gson = new Gson();

		try {
			switch (operation) {
			case ADD_MEDICAL_HISTORY:
				message = commands.get(operation).execute(details);
				break;
			case ADD_MEDICAL_REPORT:
				message = commands.get(operation).execute(details);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// Client see an error from here
			message = MessageList.ERROR.message();
			log.error("Payroll Controloler Error. " + e);
		}
		
		writeResponse(gson.toJson(message), response);
	}

	private void writeResponse(String insertedSuccess,HttpServletResponse response) {
		
		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(insertedSuccess));
		} catch (Exception e) {
			insertedSuccess = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: EmployeeController - writeResponse" + e);
		}
	}
}
