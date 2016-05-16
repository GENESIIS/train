package com.genesiis.hra.employer;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.EditEmployee;
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;
/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());
	HashMap<Integer, Object> hmap = null;

	public void init() throws ServletException {
		EditEmployee editEmployee = new EditEmployee();
		GetEmployee getEmployee = new GetEmployee();

		hmap = new HashMap<Integer, Object>();
		// hmap.put(1, addEmployee);
		hmap.put(2, editEmployee);
		// hmap.put(3, null);
		// hmap.put(4, null);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		GetEmployee empgson = new GetEmployee();
		response.setContentType("text/html");			
		response.getWriter().write(empgson.createGson());
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
		int validTask = validTaskId(task);
		Gson gson = new Gson();
		try {
			switch (validTask) {
			case 1:
				break;
			// For other operations.
			case 2:
				EditEmployee editEmployee = new EditEmployee();
				message = editEmployee.execute(employeeDetails);
				response.getWriter().write(gson.toJson(message));
				break;
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

	private int validTaskId(String task) {
		if (task.equalsIgnoreCase(MessageList.ADD.message())) {
			return 1;
		} else if (task.equalsIgnoreCase(MessageList.UPDATE.message())) {
			return 2;
		} else if (task.equalsIgnoreCase(MessageList.DELETE.message())) {
			return 3;
		} else if (task.equalsIgnoreCase(MessageList.GETALL.message())) {
			return 4;
		} else if (task.equalsIgnoreCase(MessageList.FIND.message())) {
			return 5;
		} else {
			return -1;
		}
	}

}
