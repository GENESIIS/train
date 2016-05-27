package com.genesiis.hra.command;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.genesiis.hra.model.MedicalHistory;
import com.genesiis.hra.model.MedicalReport;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class AddMedicalReport implements ICommand{

static Logger log = Logger.getLogger(AddMedicalReport.class.getName());
	
	@Override
	public String execute(String gsonData) {
		String insertedSuccess = "";
		try {

			MedicalReport medicalReport = (MedicalReport) extractFromJason(gsonData);

			// Only a valid object will added to the database.
			String hasError = medicalReport.isValidObject(medicalReport);
			
			if (hasError=="pass") {
				
				//adding medical history to database table
				int hasInserted = medicalReport.add(medicalReport);
				
				 //For ADD EMPLOYMENT HISTORY DETAILS operations.
				if (hasInserted == 1) {
					insertedSuccess = MessageList.ADDED.message();
				} else {
					insertedSuccess = MessageList.ERROR.message();
				}
				
			}else{
				return hasError;
			}
		} catch (Exception e) {
			log.info("execute - Exception " + e);
		}
		return insertedSuccess;
	}
/**
 * Sending data  with part data
 * **/
	public String executePart(Part partData,String description) {
		
		String insertedSuccess = "";
		
		String filePath ="";
		try {

			InputStream fileContent = partData.getInputStream();
			log.info("---fileContent---" + fileContent);
			
			OutputStream outputStream = null;
			try {
				Random randomGenerator = new Random();
				//parameter genarator
				int randomInt = randomGenerator.nextInt(100000);
				//file path wich going to share
				filePath = "C:/sdb/ctxdeploy/hras.war/"+ randomInt + "_image.jpg";
				outputStream = new FileOutputStream(filePath);
				
				byte[] buffer = new byte[10 * 1024];

				for (int length; (length = fileContent.read(buffer)) != -1;) {
					outputStream.write(buffer, 0, length);
					outputStream.flush();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (fileContent != null) {
					try {
						fileContent.close();
					} catch (IOException e) {
						log.info("Error while closing input stream");
					}
				}
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						log.info("Error while closing output stream");
					}
				}

			}
			//Omite this also keep this as same has to go more
			//MedicalReport medicalReport = (MedicalReport) extractFromJason(gsonData);
			MedicalReport medicalReport = new  MedicalReport();
			medicalReport.setCode(6);
			medicalReport.setReportdescription(description);
			medicalReport.setReportpath(filePath);
			
			
			// Only a valid object will added to the database.
			String hasError = medicalReport.isValidObject(medicalReport);
			
			if (hasError=="pass") {
				
				//adding medical history to database table
				int hasInserted = medicalReport.add(medicalReport);
				
				 //For ADD EMPLOYMENT HISTORY DETAILS operations.
				if (hasInserted == 1) {
					insertedSuccess = MessageList.ADDED.message();
				} else {
					insertedSuccess = MessageList.ERROR.message();
				}
				
			}else{
				return hasError;
			}
		} catch (Exception e) {
			log.info("execute - Exception " + e);
		}
		return insertedSuccess;
	}
	
	@Override
	public Object extractFromJason(String data) {
		Gson gson = new Gson();
		MedicalHistory medicalHistory = null;
		try {
			medicalHistory = gson.fromJson(data, MedicalHistory.class);
		} catch (Exception e) {
			log.info("ExtractFromgson - Exception " + e);
		}
		return medicalHistory;
	}


	@Override
	public boolean validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateValue(HashMap<Integer, Object> entiytMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int validTaskId(String task) {
		DataValidator validator = new DataValidator();
		int validTask = validator.validTaskId(task);
		return validTask;
	}
	
}
