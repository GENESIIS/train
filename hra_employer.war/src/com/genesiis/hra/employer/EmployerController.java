package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddBasic;
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.command.GetLoan;
import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.command.RegisterLoan;
import com.genesiis.hra.command.SerchEmployee;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;

	public void init() throws ServletException {		

		commands = new HashMap<Operation, ICommandAJX>();		
		commands.put(Operation.SERCH_EMPLOYEE, new SerchEmployee());
		commands.put(Operation.REGISTER_LOAN, new RegisterLoan());
		commands.put(Operation.UPDATE_LOAN, new RegisterLoan());
		commands.put(Operation.GET_EMPLOYEE_BASIC, new GetEmployee());
		commands.put(Operation.UPDATE_EMPLOYEE_BASIC, new AddBasic());
		commands.put(Operation.GET_LOAN, new GetLoan());
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
					message = commands.get(o).execute(serchVlaue);
					log.info(message);
		        break;	
			 case REGISTER_LOAN:					
				    message =commands.get(o).execute(details);							
		        break;	
			 case GET_LOAN:					
				    message =commands.get(o).execute(serchVlaue);	
				    log.info(serchVlaue +"...............................................");
		        break;
			 case UPDATE_LOAN:					
				    message =commands.get(o).execute(details,serchVlaue);							
		        break;	
			 case GET_EMPLOYEE_BASIC:					
				    log.info(gson.toJson("Inside case get"));
				    message =commands.get(o).execute(serchVlaue, task);					
		        break;	
			 case UPDATE_EMPLOYEE_BASIC:					
				    message =commands.get(o).execute(details);							
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
