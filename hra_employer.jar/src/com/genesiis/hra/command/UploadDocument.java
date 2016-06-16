package com.genesiis.hra.command;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.jboss.logging.Logger;

import com.genesiis.hra.model.EmployeeImage;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.FileUploader;
import com.genesiis.hra.validation.HttpRequestWrapper;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

public class UploadDocument implements ICommandAJX {

	static Logger log = Logger.getLogger(UploadDocument.class.getName());

	public String execute(HttpRequestWrapper hrw, Operation o) {
		int id = -1; // The new row id created when a department is inserted
		String finalFileName = "";
		String details = "";
		String message = "";
		
		
		HashMap<Operation, ICommandAJX> commands = new HashMap<Operation, ICommandAJX>();;
		commands.put(Operation.ADD_MEDICAL_REPORT, new AddMedicalReport());
		commands.put(Operation.ADD_EMPLOYEE_IMAGE_DETAILS, new AddEmployeeImage());
		
		try {

			// extracting the filename from request wrapper
			for (String cd : hrw.getWrapperPart()
					.getHeader("content-disposition").split(";")) {
				if (cd.trim().startsWith("filename")) {
					String fileName = cd.substring(cd.indexOf('=') + 1).trim()
							.replace("\"", "");
					finalFileName = fileName.substring(
							fileName.lastIndexOf('/') + 1).substring(
							fileName.lastIndexOf('\\') + 1);
				}
			}

			// uploading file inside the file uploader
			FileUploader fileUploader = new FileUploader();

			// extracting file content from requestWrapper parts
			InputStream fileContent = hrw.getWrapperPart().getInputStream();

			// extracting extension from filename
			String ext = FilenameUtils.getExtension(finalFileName);

			// extracting employee EPF from http request wrapper
			// according to employee id its going to create the folder
			String employeeId = hrw.getWrapperEmployeeid();

			/**
			 * @param InputStream
			 *            fileContent
			 * @param String
			 *            finalFileName
			 * @param String
			 *            employeeId
			 * @param String
			 *            extension
			 * 
			 *            uploading the files
			 * 
			 * @return path of the insertion
			 * **/

			// details extracting from request
			String modBy = hrw.getWrapperModBy();
			String crtBy = hrw.getWrapperCrtBy();
			String reportDescription = hrw.getWrapperReportDescription();
			String path = null;

			switch (o) {

			case ADD_EMPLOYEE_IMAGE_DETAILS:

				path = fileUploader.setFileToBeUpload(fileContent,
						finalFileName, employeeId, ext);
				details = "{" + "\"employeeEpf\":\"" + employeeId + "\","
						+ "\"status\":\"" + "INIT" + "\"," + "\"imagePath\":\""
						+ path + "\"," + "\"modBy\":\"" + modBy + "\","
						+ "\"crtBy\":\"" + crtBy + "\"" + "}";
				
				message = commands.get(o).execute(details);
				
				break;

			case ADD_MEDICAL_REPORT:

				path = fileUploader.setFileToBeUpload(fileContent,
						finalFileName, employeeId);
				details = "{\"code\":\"" + MaskValidator.SQL_RECODE + "\","
						+ "\"reportDescription\":\"" + reportDescription
						+ "\"," + "\"reportPath\":\"" + path + "\","
						+ "\"modby\":\"" + modBy + "\"," + "\"crtby\":\""
						+ crtBy + "\"" + "}";
				
				message = commands.get(o).execute(details);
				
				break;

			default:
				break;

			}

			

		} catch (Exception e) { // User Defined exception.
			// This comes from the validation of the Component
			// validateComponent()
			log.error("Exception - execute(): ERR" + e);
		}
		return message;
		// return null;
	}

	// @tr - extracting Gson data to object for save
	public Object extractFromJason(String data) {

		Gson gson = new Gson();
		EmployeeImage employeeImage = null;
		try {
			// convert gson into object
			employeeImage = gson.fromJson(data, EmployeeImage.class);
		} catch (Exception e) {
			// error handling
			log.info("ExtractFromgson - AddMedicalReports - Exception "
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

	@Override
	public String execute(String gsonData) {

		return null;
	}

	@Override
	public String execute(String inputValue, String epf) {
		// TODO Auto-generated method stub
		return null;
	}
}
