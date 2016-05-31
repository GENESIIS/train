package com.genesiis.hra.department;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
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
	HashMap<Integer, Object> hmap = null;
	DataValidator validator = new DataValidator();

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DepartmentController.class.getName());

	public void init() throws ServletException {
//		AddDepartment addDepartment = new AddDepartment();
//		GetManager manager = new GetManager();

//		hmap = new HashMap<Integer, Object>();
//		hmap.put(1, addDepartment);
//		hmap.put(5, manager);
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
		String task = request.getParameter("task");
		String gson = null;
		// Method to verify it and return integer;
		int validTask = validator.validTaskId(task);
		try {
			switch (validTask) {
			case 1:
				break;
			case 5:
//				GetManager manager = (GetManager) hmap.get(5);
//				gson = new Gson().toJson(manager.execute());
				response.getWriter().write(gson);
				break;
			// For other operations.
			// case 3:
			// break;
			// case 4:
			// break;
			case -1:
			default:
				break;
			}
		} catch (Exception exception) {
			String message = MessageList.ERROR.message();
			log.error("Exception: EmployeeController " + exception);
			response.getWriter().write(message);
		}
		response.getWriter().close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String departmentDetails = request.getParameter("jsonData");
		String task = request.getParameter("task");
		int message = 0;
		// Method to verify it and return integer;
		int validTask = validator.validTaskId(task);
		Gson gson = new Gson();

		try {
			switch (validTask) {
			case 1:
//				AddDepartment addDepartment = (AddDepartment) hmap.get(1);
//				message = addDepartment.execute(departmentDetails);
				response.getWriter().write(gson.toJson(message));
				break;
			// For other operations.
			// case 2:
			// break;
			// case 3:
			// break;
			// case 4:
			// break;
			default:
				break;
			}
		} catch (Exception exception) {
			//message = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: DepartmentController" + exception);
			response.getWriter().write(gson.toJson(message));
		}
		response.getWriter().close();
	}
}