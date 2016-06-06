package com.genesiis.hra.department;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddDepartment;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.GetManager;
import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

///***********************************************
//* 20160416 PN HRA-3 DepartmentController.java class
//* 20160425 PN HRA-3 modified doPost()
//* 20160429 PN Modified the doPost() by separating the execute method for ADD,UPDATE,DELETE etc.
//* 20160501 PN Modified the doGet() method to display managers for Departments.
//* 20160504 PN Modified the doPost method with a Switch-Case statement and init() method with a hashMap.
//***********************************************/

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DepartmentController.class.getName());
	HashMap<Operation, ICommand> commands = null;

	public void init() throws ServletException {
		// HashMap to map commands into Operation enum.
		commands = new HashMap<Operation, ICommand>();
		commands.put(Operation.ADD_DEPARTMENT, new AddDepartment());
		commands.put(Operation.GET_MANAGER, new GetManager());
		commands.put(Operation.GET_DEPARTMENT, new GetDepartment());
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

		try {
			switch (o) {
			case ADD_DEPARTMENT:
				message = commands.get(o).execute(details);
				break;
			case GET_MANAGER:
				message = commands.get(o).execute(details);
				break;
			case GET_DEPARTMENT:
				message = commands.get(o).execute(details);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// Client see an error from here
			message = MessageList.ERROR.message();
			log.error("Department Controller Error. " + e);
		}

		writeResponse(gson.toJson(message), response);
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