package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployeeHistory;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.GetEmploymentHistory;
import com.genesiis.hra.command.UpdateEmployee;
import com.genesiis.hra.command.UpdateEmployeeHistory;
import com.genesiis.hra.validation.ClassList;
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
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {

		// initialize the commands
		//UpdateEmployee addEmployee = new UpdateEmployee();
		AddEmployeeHistory addEmployeeHistory 		= new AddEmployeeHistory();
		UpdateEmployeeHistory updateEmployeeHistory = new UpdateEmployeeHistory();
		GetEmploymentHistory getEmploymentHistory 	= new GetEmploymentHistory();
		
		GetDepartment department = new GetDepartment();

		hmap = new HashMap<Integer, Object>();
		//hmap.put(1, addEmployee);
		hmap.put(5, department);
		hmap.put(6, addEmployeeHistory);
		hmap.put(7, getEmploymentHistory);
		hmap.put(8, updateEmployeeHistory);

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

		String employeeDetails = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = MessageList.ERROR.message();
		
		List<Object> employeeHistoryList = new ArrayList<Object>();

		// Method to verify it and return integer;
		int validTask = validator.validTaskId(task);
		Gson gson = new Gson();

		try {

			switch (validTask) {
			case 1:
				UpdateEmployee dim = (UpdateEmployee) hmap.get(1);

				// For ADD FAMILLY DETAILS operations.
				if ((dim.execute(ClassList.FAMILY_MEMBER.getValue(),
						employeeDetails)) == 1) {
					message = MessageList.ADDED.message();
				}
				response.getWriter().write(gson.toJson(message));
				break;

			// For other operations.
			// case 2:
			// break;
			// case 3:
			// break;
			// case 4:
			// break;

			case 6:
				/**
				 * Add Employee History 
				 * AddEmployeeHistory > validTask-6 > task-6
				 * **/
				log.error("__________________AddEmployeeHistory_______________________");
				AddEmployeeHistory addEmployeeHistory 	= (AddEmployeeHistory) hmap.get(6);
				int insetStatus 						= addEmployeeHistory.execute(ClassList.EMPLOYMENT_HISTORY.getValue(),employeeDetails);

				// For ADD EMPLOYMENT HISTORY DETAILS operations.
				if (insetStatus == 1) {
					message = MessageList.ADDED.message();
				} else {
					message = MessageList.ERROR.message();
				}
				response.getWriter().write(gson.toJson(message));
				break;

				
			case 7:
				/**
				 * Get Employee History 
				 * GetEmploymentHistory > validTask-7 > task-7
				 * **/
				log.error("__________________GetEmploymentHistory_______________________");
				GetEmploymentHistory getEmploymentHistory 	= (GetEmploymentHistory) hmap.get(7);
				employeeHistoryList 						= getEmploymentHistory.execute(ClassList.EMPLOYMENT_HISTORY.getValue(),employeeDetails);

				// For ADD EMPLOYMENT HISTORY DETAILS operations.
//				if (ee == 1) {
//					message = MessageList.ADDED.message();
//				} else {
//					message = MessageList.ERROR.message();
//				}
				
				response.getWriter().write(gson.toJson(message));
				break;

			case 8:
				/**
				 * UpdateEmployeeHistory
				 * UpdateEmployeeHistory > validTask-8 > task-8
				 * **/
				log.error("__________________UpdateEmployeeHistory_______________________");
				UpdateEmployeeHistory updateEmployeeHistory = (UpdateEmployeeHistory) hmap.get(8);
				int updateStatus 							= updateEmployeeHistory.execute(ClassList.EMPLOYMENT_HISTORY.getValue(),employeeDetails);

				// For ADD EMPLOYMENT HISTORY DETAILS operations.
				if (updateStatus == 1) {
					message = MessageList.ADDED.message();
				} else {
					message = MessageList.ERROR.message();
				}
				
				response.getWriter().write(gson.toJson(message));
				break;
				
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



