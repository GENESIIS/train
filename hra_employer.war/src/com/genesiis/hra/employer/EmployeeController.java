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
import com.genesiis.hra.command.RegisterLoan;
import com.genesiis.hra.command.SerchEmployee;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.DataTableObject;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.StudentDataService;
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
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		AddEmployee addEmployee = new AddEmployee();
		GetDepartment department = new GetDepartment();
		RegisterLoan  loan = new RegisterLoan();
		SerchEmployee sEmp = new SerchEmployee();

		hmap = new HashMap<Integer, Object>();
		hmap.put(1, addEmployee);
		hmap.put(2, loan);
		hmap.put(5, department);
	    hmap.put(6, sEmp);
		// hmap.put(4, null);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String task = request.getParameter("task");
		Gson gson = new Gson();
		String lnGson = null;
		int validTask = validator.validTaskId(task);
		
		try {
			GetLoan lndetail = new GetLoan();
			lnGson =lndetail.execute("1");
			response.getWriter().write(lnGson);
			
		} catch (Exception exception) {
			String message = MessageList.ERROR.message();
			log.error("Exception: EmployeeController " + exception);
			response.getWriter().write(gson.toJson(message));
		}
		response.getWriter().close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String employeeDetails = request.getParameter("jsonData");
		String serchVlaue = request.getParameter("serchVlaue");
		String task = request.getParameter("task");
		Gson gson = new Gson();
		String message = "";
		// Method to verify it and return integer;
		//int validTask = validator.validTaskId(task);
			
		try {
			switch (3) {
			case 1:				
				break;
			// For other operations.
			 case 2:
				    RegisterLoan regLoan = (RegisterLoan) hmap.get(2);
					message = regLoan.execute(employeeDetails);
					response.getWriter().write(gson.toJson(message));
		        break;		
			 case 3:
					SerchEmployee sEmp = (SerchEmployee) hmap.get(6);
					message = sEmp.execute(serchVlaue);
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