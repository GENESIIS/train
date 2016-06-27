package com.genesiis.hra.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;

import java.io.InputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.genesiis.hra.command.AddBasic;
import com.genesiis.hra.command.AddEducationDetails;
import com.genesiis.hra.command.AddEmployeeBasicdata;
import com.genesiis.hra.command.AddFamilyDetails;
import com.genesiis.hra.command.AddStuddyProgram;
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.command.GetLoan;
import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.command.RegisterLoan;
import com.genesiis.hra.command.SerchEmployee;

import javax.servlet.http.Part;

import com.genesiis.hra.command.AddEmployeeHistory;
import com.genesiis.hra.command.AddMedicalHistory;
import com.genesiis.hra.command.AddMedicalReport;
import com.genesiis.hra.fileupload.FileUploadController;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.FileUploader;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployerController")
@MultipartConfig
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Login.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;

	public void init() throws ServletException {

		commands = new HashMap<Operation, ICommandAJX>();
		commands.put(Operation.SERCH_EMPLOYEE, new SerchEmployee());
		
		commands.put(Operation.REGISTER_LOAN, new RegisterLoan());
		commands.put(Operation.UPDATE_LOAN, new RegisterLoan());
		commands.put(Operation.GET_LOAN, new GetLoan());
		
		commands.put(Operation.ADD_EMPLOYEE_BASICDATA, new AddBasic());
		commands.put(Operation.GET_EMPLOYEE_BASIC, new GetEmployee());
		commands.put(Operation.UPDATE_EMPLOYEE_BASIC, new AddBasic());
		commands.put(Operation.VIEW_EMPLOYEE_DETAILS, new GetEmployee());
		
		commands.put(Operation.ADD_EMPLOYEE_HISTORY, new AddEmployeeHistory());
		commands.put(Operation.UPDATE_EMPLOYEE_HISTORY, new AddEmployeeHistory());
		commands.put(Operation.GET_EMPLOYEE_HISTORY, new GetEmployee());

		commands.put(Operation.ADD_MEDICAL_HISTORY, new AddMedicalHistory());
		commands.put(Operation.ADD_MEDICAL_REPORT, new AddMedicalReport());
		commands.put(Operation.GET_MEDICAL_HISTORY, new GetEmployee());
		commands.put(Operation.GET_MEDICAL_REPORT, new GetEmployee());
		commands.put(Operation.UPDATE_MEDICAL_HISTORY, new AddMedicalHistory());
		commands.put(Operation.UPDATE_MEDICAL_REPORT, new AddMedicalReport());
		
		commands.put(Operation.ADD_FAMILY_MEMBER,	new AddFamilyDetails());
		commands.put(Operation.UPDATE_FAMILY_MEMBER,  new AddFamilyDetails());
		commands.put(Operation.GET_FAMILY_MEMBER,  new GetEmployee());
		commands.put(Operation.GET_FAMILY, new GetEmployee());
		
		commands.put(Operation.ADD_EDU_DETAILS, new AddEducationDetails());
		commands.put(Operation.GET_EDU_DETAILS, new GetEmployee());
		commands.put(Operation.UPDATE_EDU_DETAILS, new AddEducationDetails());
		commands.put(Operation.ADD_STUDY_PROGRAM, new AddStuddyProgram());
		commands.put(Operation.GET_STUDY_PROGRAM, new GetEmployee());
		commands.put(Operation.UPDATE_STUDY_PROGRAM, new AddStuddyProgram());
		
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String details = request.getParameter("jsonData");
		
		log.info(details);
		
		String inputValue = request.getParameter("inputValue");
		String task = request.getParameter("task");
		Gson gson = new Gson();
		String message = "";

		// Get the retrieve the operation from the task.
		Operation o = Operation.BAD_OPERATION;
		o = Operation.getOperation(task);
		
		log.info(""
				+ "task-" +  task 
				+ " searchValue-" + inputValue + 
				" details-" + details);
		
		log.info("Operation" + o);
		try {
			switch (o) {

			case SERCH_EMPLOYEE:
				message = commands.get(o).execute(inputValue);
				log.info(message);
				break;
			case REGISTER_LOAN:
				message = commands.get(o).execute(details);
				break;
			case GET_LOAN: 
				message = commands.get(o).execute(inputValue);
				log.info(inputValue	+ "inputVAlue");
				break;
			case UPDATE_LOAN:
				message = commands.get(o).execute(details, inputValue);
				break;			
			case ADD_EMPLOYEE_BASICDATA:
				message = commands.get(o).execute(details);
				break;
			case GET_EMPLOYEE_BASIC:
				log.info(gson.toJson("Inside case get"));
				message = commands.get(o).execute(inputValue, task);
				break;
			case UPDATE_EMPLOYEE_BASIC:
				message = commands.get(o).execute(details,inputValue );
				break;			
			case ADD_EMPLOYEE_HISTORY:
				message = commands.get(o).execute(details);
				break;
			case GET_EMPLOYEE_HISTORY:
				message = commands.get(o).execute(inputValue, task);
				break;
			case UPDATE_EMPLOYEE_HISTORY:
				message = commands.get(o).execute(details, inputValue);
				break;				
			case ADD_MEDICAL_HISTORY:
				message = commands.get(o).execute(details);
				break;	
			case GET_MEDICAL_HISTORY:
				message = commands.get(o).execute(inputValue, task);
				break;	
			case UPDATE_MEDICAL_HISTORY:
				message = commands.get(o).execute(details,inputValue);
				break;	
			case ADD_FAMILY_MEMBER:
				message = commands.get(o).execute(details);
				break;
			case GET_FAMILY:
				message = commands.get(o).execute(inputValue, task);
				log.info("Search family details");
				break;
			case UPDATE_FAMILY_MEMBER:
				message = commands.get(o).execute(details,inputValue);
				log.info("Search family details");
				break;	
			case GET_FAMILY_MEMBER:
				message = commands.get(o).execute(inputValue, task);
				break;				
			case ADD_EDU_DETAILS:
				message = commands.get(o).execute(details);
				log.info("add education details" + details);
				break;
			case GET_EDU_DETAILS:
				message = commands.get(o).execute(inputValue, task);
				log.info("Search Educational details");
				break;
			case UPDATE_EDU_DETAILS:
				message = commands.get(o).execute(details);
				log.info("update education details" + details);
				break;
			case ADD_STUDY_PROGRAM:
				message = commands.get(o).execute(details);
				log.info("Add Study Program" + details);
				break;
			case GET_STUDY_PROGRAM:
				message = commands.get(o).execute(inputValue, task);
				log.info("Get Study Program" + inputValue);
				break;
			case UPDATE_STUDY_PROGRAM:
				message = commands.get(o).execute(details, inputValue);
				log.info("Update Study Program" + details);
				break;
			case ADD_MEDICAL_REPORT:
				FileUploadController  fileUploadController = new FileUploadController();
				details = fileUploadController.fileUpload(request);
				message = commands.get(o).execute(details);
				break;
			default:
				break;
			}
			writeResponse(gson.toJson(message), response);
			log.info(gson.toJson(message));
		} catch (Exception exception) {
			message = MessageList.FAILED_TO_CREATE.message();
			response.getWriter().write(gson.toJson(message));
			log.error("Exception: EmployeeController" + exception + " "
					+ "message-" + gson.toJson(message));
		}
		response.getWriter().close();

	}

	private void writeResponse(String message, HttpServletResponse response)
			throws IOException {
		try {
			response.getWriter().write(message);
			log.info(message);
		} catch (Exception e) {
			log.error("WriteResponse method error. " + e);
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}

	}

	private static String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1)
						.substring(fileName.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}

}
