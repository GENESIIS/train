package com.genesiis.hra.employer;


import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.genesiis.hra.command.EditEmployee;
import com.genesiis.hra.command.GetEmployee;


/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,  
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//Integer userId =null;
		//userId = Integer.parseInt(request.getParameter("user_id"));
		GetEmployee empgson= new GetEmployee();
		response.setContentType("text/plain");
		response.getWriter().write(empgson.createGson());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
        
		String employeeDetails = request.getParameter("jsonData");
		
		EditEmployee addEmployee = new EditEmployee();
		
		try {
			
			
			
			
			//String upaDate = request.getParameter("update");
	       // if (upaDate.equalsIgnoreCase("true"))
	      //  {
	        	addEmployee.executeAddEmployee(employeeDetails);
	      //  }
	       // else
	       // {
	        //	addEmployee.executeAddEmployee(employeeDetails);
	        	
	       // }
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void extractEmployeeDetails() {		
		try {
			
		} catch (Exception e) {

		}
		
	}
	
}
