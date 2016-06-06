package com.genesiis.hra.employer;

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
import com.genesiis.hra.command.GetEmployee;
import com.genesiis.hra.command.GetLoan;
import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.command.RegisterLoan;
import com.genesiis.hra.command.SerchEmployee;
import javax.servlet.http.Part;

import com.genesiis.hra.command.AddEmployeeHistory;
import com.genesiis.hra.command.AddMedicalHistory;
import com.genesiis.hra.command.AddMedicalReport;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.FileUploader;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;

	public void init() throws ServletException {		

		commands = new HashMap<Operation, ICommandAJX>();		
		commands.put(Operation.SERCH_EMPLOYEE, new SerchEmployee());
		commands.put(Operation.REGISTER_LOAN, new RegisterLoan());
		commands.put(Operation.UPDATE_LOAN, new RegisterLoan());
		commands.put(Operation.GET_EMPLOYEE_BASIC, new GetEmployee());
		commands.put(Operation.UPDATE_EMPLOYEE_BASIC, new AddBasic());
		commands.put(Operation.GET_LOAN, new GetLoan());
		commands.put(Operation.ADD_EMPLOYEE_HISTORY, new AddEmployeeHistory());
		commands.put(Operation.ADD_MEDICAL_HISTORY, new AddMedicalHistory());
		commands.put(Operation.ADD_MEDICAL_REPORT, new AddMedicalReport());
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
		String serchVlaue = request.getParameter("serchVlaue");
		String task = request.getParameter("task");			
		Gson gson = new Gson();
		String message = "";
		 
		// Get the retrieve the operation from the task.
		Operation o = Operation.BAD_OPERATION;
		o = Operation.getOperation(task);
		log.info("task-"+task+"serchVlaue-"+serchVlaue+ "details-"+details);
		log.info("Operation"+o);
		try { 
			switch (o) {
			
			 case SERCH_EMPLOYEE:					
					message = commands.get(o).execute(serchVlaue);
					log.info(message);
		        break;	
			 case REGISTER_LOAN:					
				    message =commands.get(o).execute(details);							
		        break;	
			 case GET_LOAN:					
				    message =commands.get(o).execute(serchVlaue);	
				    log.info(serchVlaue +"...............................................");
		        break;
			 case UPDATE_LOAN:					
				    message =commands.get(o).execute(details,serchVlaue);							
		        break;	
			 case GET_EMPLOYEE_BASIC:					
				    log.info(gson.toJson("Inside case get"));
				    message =commands.get(o).execute(serchVlaue, task);					
		        break;	
			 case UPDATE_EMPLOYEE_BASIC:					
				    message =commands.get(o).execute(details);							
		        break;	
			 case ADD_EMPLOYEE_HISTORY:
					message = commands.get(o).execute(details);
					break;
				case GET_EMPLOYEE_HISTORY:
					message = commands.get(o).execute(details);
					break;
				case UPDATE_EMPLOYEE_HISTORY:
					message = commands.get(o).execute(details,task);
					break;
				case ADD_MEDICAL_HISTORY:
					message = commands.get(o).execute(details);
					break;					
				case ADD_MEDICAL_REPORT:
					// this code segment will improve in next sprint as much as possible 
					FileUploader fileUploader = new FileUploader();
					Part filePart = request.getPart("file");
					InputStream fileContent = filePart.getInputStream();
					String fileName = getSubmittedFileName(filePart);
					String employeeId = request.getParameter("employeeId");
					String path = fileUploader.setFileToBeUpload(fileContent,fileName,employeeId);
					
					if(path!=null){
						
						details = "{\"code\":\""+MaskValidator.SQL_RECODE+"\","
								+ "\"reportDescription\":\""+request.getParameter("reportDescription")+"\","
								+ "\"reportPath\":\""+path+"\","
								+ "\"modby\":\""+request.getParameter("ehReferencemodby")+"\","
								+ "\"crtby\":\""+request.getParameter("ehReferencemodby")+"\""
								+"}";
						
						message = commands.get(o).execute(details);// do not delete need to improve

					}else{
						message = MessageList.ERROR.message();
					}
						break;
			default:
				break;
			}			
			writeResponse(gson.toJson(message), response);
			log.info(gson.toJson(message));
		} catch (Exception exception) {
			message = MessageList.FAILED_TO_CREATE.message();			
			response.getWriter().write(gson.toJson(message));
			log.error("Exception: EmployeeController" + exception+" "+ "message-"+gson.toJson(message));
		}
		response.getWriter().close();


	}

	private void writeResponse(String insertedSuccess,
			HttpServletResponse response) {

		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(insertedSuccess));
			response.getWriter().close();
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
