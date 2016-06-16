package com.genesiis.hra.fileupload;

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

import org.apache.commons.io.FilenameUtils;
import org.jboss.logging.Logger;

import com.genesiis.hra.command.ICommandAJX;
import com.genesiis.hra.employer.EmployerController;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.FileUploader;
import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;

@WebServlet("/FileUploadController")
@MultipartConfig
public class FileUploadController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(EmployerController.class.getName());
	HashMap<Operation, ICommandAJX> commands = null;

	public void init() throws ServletException {

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
		log.info(inputValue);
		String task = request.getParameter("task");
		log.info(task);

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

	/**
	 * @PARM request,response
	 * @return jsonString
	 * **/
	public String fileUpload(HttpServletRequest req, Operation operation) {

		String details = "";
		try {


			
			switch (operation) {
			case ADD_MEDICAL_REPORT:
				details = AddMedicalDetails(req);
				break;
			case UPDATE_MEDICAL_REPORT:
				details = AddMedicalDetails(req);
				break;
			case ADD_EMPLOYEE_IMAGE_DETAILS:
				details = AddEmployeeImage(req);
				break;

			default:
				break;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return details;

	}

	private String AddMedicalDetails(HttpServletRequest req) {
		
		String details = "";

		try {

			FileUploader fileUploader = new FileUploader();
			Part filePart = req.getPart("file");
			InputStream fileContent = filePart.getInputStream();
			
			String fileName = getSubmittedFileName(filePart);
			String employeeId = req.getParameter("employeeId");
			String path = fileUploader.setFileToBeUpload(fileContent, fileName,	employeeId);
			
			log.info(":" + fileName + ":" + employeeId + ":" + path + ":");
			
			if (path != null) {

				
				details = "{\"code\":\"" + MaskValidator.SQL_RECODE + "\","
						+ "\"reportDescription\":\""+ req.getParameter("reportDescription") + "\","
						+ "\"reportPath\":\"" + path + "\"," 
						+ "\"modby\":\""+ req.getParameter("ehReferencemodby") + "\","
						+ "\"crtby\":\"" + req.getParameter("ehReferencemodby") + "\"" 
						+ "}";

				log.info(details);

			} else {
				details = MessageList.ERROR.message();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return details;
	}
	
	
	private String AddEmployeeImage(HttpServletRequest req) {
		String details = "";

		try {
			FileUploader fileUploader = new FileUploader();
			Part filePart = req.getPart("file");

			InputStream fileContent = filePart.getInputStream();
			String fileName = getSubmittedFileName(filePart);
			String ext = FilenameUtils.getExtension(fileName);
			
			String modBy = req.getParameter("modBy");
			String crtBy = req.getParameter("crtBy");
			
			String employeeId = req.getParameter("employeeId");

			String path = fileUploader.setFileToBeUpload(fileContent, fileName,	employeeId,ext);


			if (path != null) {

				details = "{\"code\":\"" + MaskValidator.SQL_RECODE + "\","
						+ "\"employeeEpf\":\""+ employeeId + "\","
						+ "\"status\":\"" + "INIT" + "\","
						+ "\"imagePath\":\"" + path + "\","
						+ "\"modBy\":\""+ modBy + "\","
						+ "\"crtBy\":\"" + crtBy + "\"" 
						+ "}";

				log.info(details);

			} else {
				details = MessageList.ERROR.message();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return details;
	}
	

}
