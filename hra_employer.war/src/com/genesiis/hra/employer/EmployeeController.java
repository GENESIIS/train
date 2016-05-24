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
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Leave as empty
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.info("------------------1----------------------");
		String medicalHistoryJson 		= request.getParameter("jsonData");// Method to verify it and return details set;
		log.info("-------------2----------------"+medicalHistoryJson);
		String task 					= request.getParameter("task");//json data from jquery for task identification
		log.info("-----------3----------------"+task);
		String message 					= "";
		Operation o						= null;
		
		DataValidator validator = new DataValidator();
		int validTask = validator.validTaskId(task);
		System.out.println("4"+validTask);
		
		
		
		switch (validTask) {
		case 10:
			o = Operation.ADD_MEDICAL_HISTORY;
			System.out.println("4"+o);
			break;
		default:
			break;
		}
		
		
		
		
		try {
			

			int operationValue = o.getValue();

			switch (operationValue) {

			case 7:
				message = commands.get(o).execute(medicalHistoryJson);
				writeResponse(message, response);
				break;
			default:
				break;
				
			}
			
		} catch (Exception exception) {
			writeResponse(MessageList.FAILED_TO_CREATE.message(), response);
			log.error("Exception: EmployeeController" + exception);
		}

		response.getWriter().close();
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
