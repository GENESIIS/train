package com.genesiis.hra.department;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddDepartment;
import com.genesiis.hra.model.EmployeeManager;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

///***********************************************
//* 20160416 PN HRA-3 DepartmentController.java class
//* 20160425 PN HRA-3 modified doPost()
//* 20160429 PN Modified the doPost() by separating the execute method for ADD,UPDATE,DELETE etc.
//* 20160501 PN Modified the doGet() method to display managers for Departments.
//***********************************************/

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	HashMap<Integer, Object> hmap = null;

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DepartmentController.class.getName());

	public void init() throws ServletException {
		AddDepartment addDepartment = new AddDepartment();

		hmap = new HashMap<Integer, Object>();
		hmap.put(1, addDepartment);
		// hmap.put(2, null);
		// hmap.put(3, null);
		// hmap.put(4, null);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			EmployeeManager employeeManager = new EmployeeManager();
			List<String> list = employeeManager.getManagers();
			String gson = null;
			gson = new Gson().toJson(list);
			response.getWriter().write(gson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String departmentDetails = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = "";
		// Method to verify it and return integer;
		int validTask = 1;

		try {
			switch (validTask) {
			case 1:
				AddDepartment addDepartment = (AddDepartment) hmap.get(1);
				message = addDepartment.execute(departmentDetails);
				break;
//For other operations.				
//			case 2:
//				break;
//			case 3:
//				break;
//			case 4:
//				break;
			default:
				break;
			}
		} catch (Exception exception) {
			message = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: DepartmentController" + exception);
		}	
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(message));
	}
}