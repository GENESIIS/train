package com.genesiis.hra.validation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;



public class FileUploader{

	static Logger log = Logger.getLogger(FileUploader.class.getName());

	
	public String setFileToBeUpload(InputStream inputStream,String filename,String folder){
		
		String path =null;
		
		//folder name is employee id
		String filePath = "C:/sdb/ctxdeploy/hras.war/"+folder+"/";
		
		OutputStream outputStream = null;
		try {
			//genarate for the file front name
			Random randomGenerator = new Random();
			
			//parameter genarator
			int randomInt = randomGenerator.nextInt(100000);
			
			//home folder creation
			boolean folderCreated = createFolder(filePath);

			//folder exists
			if(folderCreated){
				
				//file path witch going to share
				filePath = filePath +randomInt + "_" +filename;
				outputStream = new FileOutputStream(filePath);

				
				byte[] buffer = new byte[10 * 1024];

				for (int length; (length = inputStream.read(buffer)) != -1;) 
				{
					outputStream.write(buffer, 0, length);
					outputStream.flush();
				}
				
				path=filePath;
				
			}
			else{
				
				path=null;
				log.info("Error while folder creation");
				
			}
			
			
		} catch (Exception e) {
			
			path=null;
			log.info("Error while recode insert");
			e.printStackTrace();
			
		} finally {

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					path=null;
					log.info("Error while closing input stream");
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					path=null;
					log.info("Error while closing output stream");
				}
			}

		}

		return path;
	}
	
	
	
	public boolean createFolder(String path){
		
		boolean created = true;
		try{
			File theDir = new File(path);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
			    try{
			        theDir.mkdir();
			        created = true;
			    } 
			    catch(SecurityException se){
			    	 created = false;
			        log.info("Directory not created"+se.getMessage());
			    }
			    catch(Exception se){
			    	 created = false;
			        log.info("Directory not created"+se.getMessage());
			    }
			    if(created) {    
			    	log.info("Directory created");  
			    }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return created;
	}
	
}