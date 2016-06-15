package com.genesiis.hra.command;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.jboss.logging.Logger;

import com.genesiis.hra.fileupload.RequestHttpWrapper;
import com.genesiis.hra.model.EmployeeImage;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.FileUploader;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddEmployeeImage implements ICommandAJX {

	static Logger log = Logger.getLogger(AddFamilyDetails.class.getName());
	HashMap<Integer, Object> entiytMap = new HashMap<Integer, Object>();
	
	@Override
	/**
	 * @param 
	 * String gsonData
	 * @return 
	 * String message
	 * 
	 * Add employee image data
	 * **/
	public String execute(String gsonData) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;

		try {
			
			
			EmployeeImage  employeeImage = (EmployeeImage)extractFromJason(gsonData);

			id = employeeImage.add(employeeImage);
			if (id != 0) {
				message = MessageList.ADDED;
			} else {
				message = MessageList.ERROR;
			}

		} catch (Exception e) { // User Defined exception. 
			//This comes from the validation of the Component
								// validateComponent()
			message = MessageList.ERROR;
			log.error("Exception - execute(): ERR" + e);
		}
		return message.message();
	}
	
	public String executeWapper(String gsonData,RequestHttpWrapper epf) {
		int id = -1; // The new row id created when a department is inserted
		MessageList message = MessageList.ERROR;
		String finalFileName = "";
		String details = "";
		try {

			
			
			for (String cd : epf.getHeader("content-disposition").split(";")) {
				if (cd.trim().startsWith("filename")) {
					String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
					finalFileName = fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
				}
			}
			
			FileUploader fileUploader = new FileUploader();
			InputStream fileContent = epf.getPart("file").getInputStream();
			String ext = FilenameUtils.getExtension(finalFileName);
			String modBy = epf.getParameter("modBy");
			String crtBy = epf.getParameter("crtBy");
			String employeeId = epf.getParameter("employeeId");
			
			String path = fileUploader.setFileToBeUpload(fileContent, finalFileName,	employeeId,ext);
			
			
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
			
			
			EmployeeImage  employeeImage = (EmployeeImage)extractFromJason(details);

			id = employeeImage.add(employeeImage);
			if (id != 0) {
				message = MessageList.ADDED;
			} else {
				message = MessageList.ERROR;
			}

		} catch (Exception e) { // User Defined exception. 
			//This comes from the validation of the Component
								// validateComponent()
			message = MessageList.ERROR;
			log.error("Exception - execute(): ERR" + e);
		}
		return message.message();
	}
	
	@Override
	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	/**
	 * @param 
	 * String gsonData
	 * @return 
	 * String EmployeeImageObject
	 * **/
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		EmployeeImage employeeImage = null;
		try {
			// convert gson into object
			employeeImage = gson.fromJson(data, EmployeeImage.class);
		} catch (Exception e) {
			// error handling
			log.info("ExtractFromgson - AddMedicalHistory - Exception "
					+ e.getMessage());
		}
		return employeeImage;
	}
	@Override
	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
