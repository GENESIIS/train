package com.genesiis.hra.employer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddEmployeeBasicdata;
import com.genesiis.hra.command.GetEducation;
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.command.GetFamilyMember;
import com.genesiis.hra.command.UpdateEmployee;
import com.genesiis.hra.command.GetDepartment;
import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.model.BasicData;
import com.genesiis.hra.model.EducationData;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.validation.Operation;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods completed.
//* 20160524 AS HRA-30 doGet() changed to doPost() method 
//***********************************************/

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployeeController.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	public void init() throws ServletException {

		commands = new HashMap<Operation, ICommandAJX>();
		commands.put(Operation.GET_BASIC_DATA, new GetEmployee());
		commands.put(Operation.GET_FAMILY, new GetFamilyMember());
		commands.put(Operation.GET_EDUCATION, new GetEducation());
		commands.put(Operation.ADD_EMPLOYEE_BASICDATA,new AddEmployeeBasicdata());
	//	commands.put(Operation.ADD_FAMILY_MEMBER, new AddFamilyDetails());
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

		String details = request.getParameter("jsonData");
		String findDetaile = request.getParameter("serchVlaue");
		String task = request.getParameter("task");
		String message = "";

		// Method to verify it and return integer;
		// int validTask = validator.validTaskId(task);
		Operation o = Operation.BAD_OPERATION;
		// using the task i retrieve the operation o =
		o = Operation.getOperation(task);
		log.info(task + details + "......");
		log.info(o + ".");
		// int validTask = validator.validTaskId(task);
		Gson gson = new Gson();
		try {
			switch (o) {
			case ADD_EMPLOYEE_BASICDATA:
				message = commands.get(o).execute(details);
				break;
			case ADD_FAMILY_MEMBER:
				message = commands.get(o).execute(details);
				break;
			case GET_BASIC_DATA:
				message = commands.get(o).execute(findDetaile);
				log.info("Search Employee details" + findDetaile);
				break;
			case GET_EDUCATION:
				message = commands.get(o).execute(findDetaile);
				log.info("Search Educational details");
				break;
			case GET_FAMILY:
				message = commands.get(o).execute(findDetaile);
				log.info("Search family details");
				break;
			default:
				break;
			}
			writeResponse(gson.toJson(message), response);
		} catch (Exception e) {
			message = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: EmployeeController" + e);
			response.getWriter().write(gson.toJson(message));
		}

		response.getWriter().close();

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