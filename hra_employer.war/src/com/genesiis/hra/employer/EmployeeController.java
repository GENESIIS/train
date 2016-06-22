package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.command.SearchEmployee;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods completed.
//* 20160530 PC HRA-30 doGet(), doPost() methods Modified.
//***********************************************/

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployeeController.class.getName());
	HashMap<Operation, ICommand> commands = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {		
        //Add command class object to map
		commands = new HashMap<Operation, ICommand>();		
		commands.put(Operation.SERCH_EMPLOYEE, new SearchEmployee());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String details = request.getParameter("jsonData");
		String serchVlaue = request.getParameter("serchVlaue");
		String task = request.getParameter("task");			
		Gson gson = new Gson();
		String message = "";
		 
		// Get the retrieve the operation from the task.
		Operation o = Operation.BAD_OPERATION;
		o = Operation.getOperation(task);
		log.info("task-"+task+"serchVlaue-"+serchVlaue+ "details-"+details);
		log.info("Operation"+o);
		try { 
			switch (o) {
			
			 case SERCH_EMPLOYEE:
				    //call search command class
					message = commands.get(o).execute(serchVlaue);
					log.info(message);
		        break;	
			 case REGISTER_LOAN:					
				    message =commands.get(o).execute("1");							
		        break;	
			default:
				break;
			}			
			writeResponse(gson.toJson(message), response);
			log.info(gson.toJson(message));
		} catch (Exception exception) {
			message = MessageList.FAILED_TO_CREATE.message();			
			response.getWriter().write(gson.toJson(message));
			log.error("Exception: EmployeeController" + exception+" "+ "message-"+gson.toJson(message));
		}
		response.getWriter().close();
	}

	private void writeResponse(String message, HttpServletResponse response) throws IOException {		
		try {
			response.getWriter().write(message);
			log.info(message);
		} catch (Exception e) {
			log.error("WriteResponse method error. " + e);
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}


	}

}