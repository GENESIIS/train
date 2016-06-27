package com.genesiis.hra.leave;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.genesiis.hra.command.AddLeaveTypes;
import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;


import com.google.gson.Gson;

import org.jboss.logging.Logger;

/**
 * 20160524 PN created PayrollController.java class. doPost() method created.
 */
@WebServlet("/LeaveController")
public class LeaveController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(LeaveController.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;

	public void init() throws ServletException {
		// HashMap to map commands into Operation enum.
		commands = new HashMap<Operation, ICommandAJX>();
		commands.put(Operation.ADD_LEAVE_TYPES, new AddLeaveTypes());
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

		String details = request.getParameter("data");
		String task = request.getParameter("task");
		String message = "";

		// Get the retrieve the operation from the task.
		Operation o = Operation.BAD_OPERATION;

		o = Operation.getOperation(task);

		Gson gson = new Gson();

		try {
			switch (o) {
			case ADD_LEAVE_TYPES:
				message = commands.get(o).execute(details);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// Client see an error from here
			message = MessageList.ERROR.message();
			log.error("Leave Controloler Error. " + e);
		}
		log.info("message" + message);
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
