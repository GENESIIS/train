/**
 * 20160523 PN HRA-31 created SchemeComponent.java class
 */

package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		ResultSet rs = null;
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
				rs = ps.getGeneratedKeys();
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
				if (rs != null) {
					rs.close();
				}
				conn.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findByEpf(String empEpf) {
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
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
