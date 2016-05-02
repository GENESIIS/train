package com.genesiis.hra.department;

import java.io.IOException;
import java.util.List;

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

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(DepartmentController.class.getName());

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

		if (task.equalsIgnoreCase(MessageList.ADD.message())) {
			AddDepartment addDepartment = new AddDepartment();
			try {
				String message = addDepartment
						.executeAdddepartment(departmentDetails);
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