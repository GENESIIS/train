package com.genesiis.hra.employer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployee;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.GetLoan;
import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.command.RegisterLoan;
import com.genesiis.hra.command.SerchEmployee;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods compleated.
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

		commands = new HashMap<Operation, ICommand>();		
		commands.put(Operation.REGISTER_LOAN, new RegisterLoan());		
		commands.put(Operation.SERCH_EMPLOYEE, new SerchEmployee());
		// hmap.put(4, null);
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
		log.info(task +serchVlaue+ details+ "............................................");
		log.info(o + "............................................");
		try { 
			switch (o) {
			
			 case SERCH_EMPLOYEE:					
					message = commands.get(o).execute(serchVlaue);
					log.info("SERCH_EMPLOYEE" + "............................................");
		        break;	
			 case REGISTER_LOAN:					
				    message =commands.get(o).execute("1");							
		        break;	
			default:
				break;
			}			
			writeResponse(gson.toJson(message), response);
			
		} catch (Exception exception) {
			message = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: EmployeeController" + exception);
			response.getWriter().write(gson.toJson(message));
		}
		response.getWriter().close();
	}

	private void writeResponse(String message, HttpServletResponse response) throws IOException {		
		try {
			response.getWriter().write(message);
			log.info(message + "............................................");
		} catch (Exception e) {
			log.error("WriteResponse method error. " + e);
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}


	}

}