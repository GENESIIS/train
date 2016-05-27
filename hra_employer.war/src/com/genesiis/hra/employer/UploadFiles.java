package com.genesiis.hra.employer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.jboss.logging.Logger;

@WebServlet("/upload")
@MultipartConfig
public class UploadFiles extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(EmployeeController.class.getName());

	private final String UPLOAD_DIRECTORY = "C:/sdb/ctxdeploy/hras.war/";

	public void init() throws ServletException {
		// initialize the commands
	}

	/**
	 * @see HttpServlet#doGost(HttpServletRequest request, HttpServletResponse
	 *      response)
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

		// log.info("*****************************************************************************");
		//
		// boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//
		// // process only if its multipart content
		// if (isMultipart) {
		// // Create a factory for disk-based file items
		// FileItemFactory factory = new DiskFileItemFactory();
		//
		// // Create a new file upload handler
		// ServletFileUpload upload = new ServletFileUpload(factory);
		// try {
		// // Parse the request
		// List<FileItem> multiparts = upload.parseRequest(request);
		//
		// for (FileItem item : multiparts) {
		// if (!item.isFormField()) {
		// String name = new File(item.getName()).getName();
		// item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
		// }
		// }
		// }
		// catch (Exception e)
		// {
		// System.out.println("File upload failed");
		// }
		// }
		//
		// log.info("*****************************************************************************");

		log.info("*****************************************************************************");

		// Retrieves <input type="text" name="description">
		String user_id = request.getParameter("user_id");
		log.info("---user_id---:" + user_id);

		// Retrieves <input type="file" name="file">
		Part filePart = request.getPart("file");
		log.info("---filePart---:" + filePart);

		// Retrieves <input type="text" name="task">
		String task = request.getParameter("task");
		log.info("---task---:" + task);

		String fileName = filePart.toString();
		log.info("---fileName---" + fileName);

		InputStream fileContent = filePart.getInputStream();
		log.info("---fileContent---" + fileContent);

		OutputStream outputStream = null;
		try {

			outputStream = new FileOutputStream("C:/sdb/ctxdeploy/hras.war/" + "image.jpg");

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
					log("Error while closing input stream", e);
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					log("Error while closing output stream", e);
				}
			}

		}

		log.info("*****************************************************************************");

	}

}
