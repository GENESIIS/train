package com.genesiis.hra.employer;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddMedicalHistory;
import com.genesiis.hra.command.AddMedicalReport;
import com.genesiis.hra.command.ICommand;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.FileUploader;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

///***********************************************
//* 20160407 PN HRA-1 created EmployeeController.java class
//* 20160430 PN HRA-1 doGet(), doPost() methods completed.
//* 
//***********************************************/

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployeeController")
@MultipartConfig
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(EmployeeController.class.getName());

	HashMap<Operation, ICommand> commands = null;

	DataValidator validator = new DataValidator();

	public void init() throws ServletException {
		// initialize the commands
		commands = new HashMap<Operation, ICommand>();
		commands.put(Operation.ADD_MEDICAL_HISTORY, new AddMedicalHistory());// MEDICAL_HISTORY==7
		commands.put(Operation.ADD_MEDICAL_REPORT, new AddMedicalReport());// MEDICAL_REPORT==10
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

		// Get the retrieve the operation from the task . initialization only
		Operation operation = Operation.BAD_OPERATION;
				
		String details = request.getParameter("jsonData");
		String task = request.getParameter("task");
		String message = "";

		operation = Operation.getOperation(task);

		Gson gson = new Gson();

		try {
			switch (operation) {
			case ADD_MEDICAL_HISTORY:
				message = commands.get(operation).execute(details);
				break;
			case ADD_MEDICAL_REPORT:
				
				Part filePart = request.getPart("file");log.info("---filePart---" + filePart);
				InputStream fileContent = filePart.getInputStream();
				String fileName = getSubmittedFileName(filePart);
				String employeeId = request.getParameter("employeeId");
				
				FileUploader fileUploader = new FileUploader();
				HashMap<Integer, String> map = fileUploader.setFileToBeUpload(fileContent,fileName,employeeId);
				
				message = map.get(2);

				if(message == "fileSaved"){
					
					details = "{\"code\":\""+MaskValidator.SQL_RECODE+"\","
							+ "\"reportDescription\":\""+request.getParameter("reportDescription")+"\","
							+ "\"reportPath\":\""+map.get(1)+"\","
							+ "\"modby\":\""+request.getParameter("ehReferencemodby")+"\","
							+ "\"crtby\":\""+request.getParameter("ehReferencemodby")+"\""
							+"}";
					log.info("details1"+details);
					message = commands.get(operation).execute(details);// do not delete need to improve
					
				}else{
					message = MessageList.ERROR.message();
				}
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// Client see an error from here
			message = MessageList.ERROR.message();
			log.error("Payroll Controloler Error. " + e);
		}
		
		writeResponse(gson.toJson(message), response);
	}

	private void writeResponse(String insertedSuccess,HttpServletResponse response) {
		
		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(insertedSuccess));
		} catch (Exception e) {
			insertedSuccess = MessageList.FAILED_TO_CREATE.message();
			log.error("Exception: EmployeeController - writeResponse" + e);
		}
	}
	
	
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); 
	        }
	    }
	    return null;
	}
	
	
}
