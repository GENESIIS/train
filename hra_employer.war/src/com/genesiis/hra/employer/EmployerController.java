package com.genesiis.hra.employer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.genesiis.hra.model.Employee;
import com.genesiis.hra.model.EmployeeDao;
import com.genesiis.hra.model.IEmployeeDaoLocal;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {
	@EJB
	private IEmployeeDaoLocal employeeDao;
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String employeeDetails = request.getParameter("jsonData");
		String message = "";
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(
							employeeDetails.getBytes(StandardCharsets.UTF_8))));
			// convert the json string back to object
			Employee employee = gson.fromJson(br, Employee.class);
			EmployeeDao employeeDao = new EmployeeDao();
			message = employeeDao.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String json = gson.toJson("Hello");
		response.getWriter().write(json);
		// response.getWriter().print(message);
		response.getWriter().close();

		// ToTest
		log.info("EMPLOYEE: " + employeeDetails);
	}
	
	public void extractEmployeeDetails() {		
		try {
			
		} catch (Exception e) {

		}
		
	}
	
}
