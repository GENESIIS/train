package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployeeBasicdata;
import com.genesiis.hra.command.AddFamilyDetails;
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;


///***********************************************
//* 20160427 PN HRA-3 created EmployeeController.java class
//* 20160428 PN HRA-3 name changed to EmployerController.java class. 
//* 20160531 PN HRA-3 modified doPost() method. 
//***********************************************/
/**
 * Servlet implementation class EmployerController
 */
@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;

	public void init() throws ServletException {
		// HashMap to map commands into Operation enum.
		commands = new HashMap<Operation, ICommandAJX>();
		commands.put(Operation.ADD_EMPLOYEE_BASICDATA,
				new AddEmployeeBasicdata());
		commands.put(Operation.ADD_FAMILY_MEMBER, 
				new AddFamilyDetails());
		commands.put(Operation.UPDATE_FAMILY_MEMBER, 
				new AddFamilyDetails());
		commands.put(Operation.GET_FAMILY_MEMBER, 
				new GetEmployee());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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
		String details = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = "";
		// Get the retrieve the operation from the task.
		Operation o = Operation.BAD_OPERATION;
		o = Operation.getOperation(task);
		Gson gson = new Gson();
		log.info("1");
		try {
			switch (o) {
			case ADD_EMPLOYEE_BASICDATA:
				message = commands.get(o).execute(details);
				break;
			case ADD_FAMILY_MEMBER:
				message = commands.get(o).execute(details);
				break;
			case UPDATE_FAMILY_MEMBER:
				message = commands.get(o).execute(details,o);
				break;
			case GET_FAMILY_MEMBER:
				message = commands.get(o).execute(details,o);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// Client see an error from here
			message = MessageList.ERROR.message();
			log.error("Employer Controller Error. " + e);
		}

		writeResponse(gson.toJson(message), response);
	}

	private void writeResponse(String message, HttpServletResponse response)
			throws IOException {
		try {
			System.out.println("writeResponse"+message);
			response.getWriter().write(message);
		} catch (Exception e) {
			log.error("WriteResponse method error. " + e);
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}

	}
}
