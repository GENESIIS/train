package com.genesiis.hra.department;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genesiis.hra.command.AddDepartment;


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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String departmentDetails = request.getParameter("jsonData");
		AddDepartment addDepartment = new AddDepartment();
		try {
			log.info("departmentDetails1: " + departmentDetails);
			addDepartment.execute(departmentDetails);
		} catch (Exception e) {
			log.info("Exception: DepartmentController" + e);
		}
		
		
	}

}
