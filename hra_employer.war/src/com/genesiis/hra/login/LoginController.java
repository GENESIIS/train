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

import com.genesiis.hra.command.ICommandAJX;

import com.genesiis.hra.command.SerchEmployee;

import javax.servlet.http.Part;

import com.genesiis.hra.fileupload.FileUploadController;

import com.genesiis.hra.validation.MessageList;
import com.genesiis.hra.validation.Operation;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEmployeeDetails
 */
@WebServlet("/LoginController")
@MultipartConfig
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(LoginController.class.getName());
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
	
		Gson gson = new Gson();
		String message = "";

	
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
