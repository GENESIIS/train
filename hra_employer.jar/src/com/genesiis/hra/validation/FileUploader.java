package com.genesiis.hra.validation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class FileUploader{

	static Logger log = Logger.getLogger(FileUploader.class.getName());
	
	public HashMap<Integer, String> setFileToBeUpload(InputStream inputStream,String filename,String folder){
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//folder name is employee id
		String filePath = "C:/sdb/ctxdeploy/hras.war/"+folder+"/";
		
		OutputStream outputStream = null;
		try {
			Random randomGenerator = new Random();
			//parameter genarator
			int randomInt = randomGenerator.nextInt(100000);
			//file path wich going to share
			filePath = filePath +randomInt + "_" +filename;
			outputStream = new FileOutputStream(filePath);
			log.info("filePath:-"+filePath);
			map.put(1, filePath);
			byte[] buffer = new byte[10 * 1024];

			for (int length; (length = inputStream.read(buffer)) != -1;) {
				outputStream.write(buffer, 0, length);
				outputStream.flush();
			}
			map.put(2, "fileSaved");
			
		} catch (Exception e) {
			map.put(3, "fileNotSaved");
			e.printStackTrace();
		} finally {

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					map.put(3, "fail");
					log.info("Error while closing input stream");
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					map.put(3, "fail");
					log.info("Error while closing output stream");
				}
			}

		}

		return map;
	}
}
