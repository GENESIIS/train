package com.genesiis.hra.fileupload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebServlet("/RequestHttpWrapper")
public class RequestHttpWrapper extends HttpServletRequestWrapper{

	public RequestHttpWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

}
