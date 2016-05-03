package com.genesiis.hra.department;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
	int count1 = 0;
	int count2 = 0;

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DepartmentController.class.getName());

	public void init() throws ServletException {
		log.info(++count1+"Count1");
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
		log.info(++count2+"Count2");
		String departmentDetails = request.getParameter("jsonData");
		String task = request.getParameter("task");

		Map<String, String[]> m = (Map<String, String[]>) request
				.getParameterMap();
		log.info("m.toString()" + m.toString());

		try {

		} catch (Exception e) {
			log.info("Exception: DepartmentController" + e);
		}

		if (task.equalsIgnoreCase(MessageList.ADD.message())) {
			AddDepartment addDepartment = new AddDepartment();
			try {
				String message = addDepartment.execute(departmentDetails);
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(message));
			} catch (Exception e) {
				log.info("Exception: DepartmentController" + e);
			}
		} else if (task.equalsIgnoreCase(MessageList.UPDATE.message())) {

		} else if ((task.equalsIgnoreCase(MessageList.DELETE.message()))) {

		} else if ((task.equalsIgnoreCase(MessageList.FIND.message()))) {

		} else if ((task.equalsIgnoreCase(MessageList.GETALL.message()))) {

		}
		response.getWriter().close();

	}

}