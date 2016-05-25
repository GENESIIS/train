/**
 * 20160523 PN HRA-3 created SalaryScheme.java class
 */
package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.genesiis.hra.utill.ConnectionManager;

/**
 * This class is the data access class when creating a Salary Scheme.
 */
public class SalaryScheme implements ICrud{
	int[] componentCode;
	String description, criteria, modBy, title;

	public int[] getComponentcode() {
		return componentCode;
	}

	public void setComponentcode(int[] componentCode) {
		this.componentCode = componentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getModby() {
		return modBy;
	}

	public void setModby(String modBy) {
		this.modBy = modBy;
	}

	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Salary Scheme constructor with Fields
	 */
	public SalaryScheme(int[] cc, String des,
			String cr, String mb) {
		super();
		this.componentCode = cc;
		this.description = des;
		this.criteria = cr;
		this.modBy = mb;
	}

	/**
	 * Salary Scheme empty Constructor
	 * **/
	public SalaryScheme() {
	}

	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.SALARYSCHEME] (TITLE, CRITERIA, DESCRIPTION, MODBY) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		SalaryScheme ss = (SalaryScheme) object;
		int status = 0;

		try {
			// Use the mask here
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, ss.getTitle());
			ps.setString(2, ss.getCriteria());
			ps.setString(3, ss.getDescription());
			ps.setString(4, "SYSTEM");

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				int generatedKey = 0;
				if (rs.next()) {
					generatedKey = rs.getInt(1);
				}
				status = generatedKey;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
