/**
 * 20160523 PN HRA-31 created SchemeComponent.java class
 */

package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.genesiis.hra.utill.ConnectionManager;

/**
 * @author pabodha
 * 
 */
public class SchemeComponent implements ICrud {
	int scheme, component;
	String componenttemp, modby;

	public int getScheme() {
		return scheme;
	}

	public void setScheme(int scheme) {
		this.scheme = scheme;
	}

	public int getComponent() {
		return component;
	}

	public void setComponent(int component) {
		this.component = component;
	}

	public String getComponenttemp() {
		return componenttemp;
	}

	public void setComponenttemp(String componenttemp) {
		this.componenttemp = componenttemp;
	}

	public String getModby() {
		return modby;
	}

	public void setModby(String modby) {
		this.modby = modby;
	}

	public SchemeComponent(int scheme, int component, String componenttemp,
			String mb) {
		super();
		this.scheme = scheme;
		this.component = component;
		this.componenttemp = componenttemp;
		this.modby = mb;
	}

	public SchemeComponent() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#add(java.lang.Object)
	 */
	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.SCHEMECOMPONENT] (SCHEME, COMPONENTTEMP, MODBY) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		SchemeComponent ss = (SchemeComponent) object;
		int status = 0;

		try {
			// Use the mask here
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, ss.getScheme());
			ps.setString(2, ss.getComponenttemp());
			ps.setString(3, "SYSTEM");

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#update(java.lang.Object)
	 */
	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#delete(java.lang.Object)
	 */
	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#getId(java.lang.String)
	 */
	@Override
	public String getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#getAll()
	 */
	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#isValid(java.lang.Object)
	 */
	@Override
	public boolean isValid(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.genesiis.hra.model.ICrud#getEmployee(int)
	 */
	@Override
	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
