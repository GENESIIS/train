package com.genesiis.hra.validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;

public class HttpRequestWrapper extends HttpServletRequestWrapper {

	Part wrapperPart = null;
	String wrapperHeader = null;
	String wrapperEmployeeid = null;
	String wrapperModBy = null;
	String wrapperCrtBy = null;
	String wrapperReportDescription = null;

	public HttpRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public Part getWrapperPart() {
		return wrapperPart;
	}

	public void setWrapperPart(Part wrapperPart) {
		this.wrapperPart = wrapperPart;
	}

	public String getWrapperHeader() {
		return wrapperHeader;
	}

	public void setWrapperHeader(String wrapperHeader) {
		this.wrapperHeader = wrapperHeader;
	}

	public String getWrapperEmployeeid() {
		return wrapperEmployeeid;
	}

	public void setWrapperEmployeeid(String wrapperEmployeeid) {
		this.wrapperEmployeeid = wrapperEmployeeid;
	}

	public String getWrapperModBy() {
		return wrapperModBy;
	}

	public void setWrapperModBy(String wrapperModBy) {
		this.wrapperModBy = wrapperModBy;
	}

	public String getWrapperCrtBy() {
		return wrapperCrtBy;
	}

	public void setWrapperCrtBy(String wrapperCrtBy) {
		this.wrapperCrtBy = wrapperCrtBy;
	}

	public String getWrapperReportDescription() {
		return wrapperReportDescription;
	}

	public void setWrapperReportDescription(String wrapperReportDescription) {
		this.wrapperReportDescription = wrapperReportDescription;
	}

}
