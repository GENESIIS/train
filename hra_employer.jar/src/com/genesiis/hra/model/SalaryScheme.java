/**
 * 20160523 PN HRA-31 created SalaryScheme.java class
 * 20160627 PC HRA-16 Modify and create addSheme method SalaryScheme.java class
 */
package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;

/**
 * This class is the data access class when creating a Salary Scheme.
 */
public class SalaryScheme implements ICrud { 
	
	static Logger log = Logger.getLogger(SalaryScheme.class.getName());

	private String[] component_id;
	private String description, criteria, modBy, title;

	public String[] getcomponent_id() {
		return component_id;
	}

	public void setcomponent_id(String[] component_id) {
		this.component_id = component_id;
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
	public SalaryScheme(int[] cc, String[] c_id, String des, String cr, String mb) {
		// this.componentCode = cc;
		this.description = des;
		this.criteria = cr;
		this.modBy = mb;
		this.component_id = c_id;
	}

	/**
	 * Salary Scheme empty Constructor
	 * **/
	public SalaryScheme() {
	}

	@Override
	public int add(Object object) {
		String schemeQuery = "INSERT INTO [HRA.SALARYSCHEME] (TITLE, CRITERIA, DESCRIPTION, MODBY) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SalaryScheme ss = (SalaryScheme) object;
		int status = 0;

		try {
			// Use the mask here
			// Create connection
			conn = ConnectionManager.getConnection();
			//initialize ps prepared Statement
			ps = conn.prepareStatement(schemeQuery, Statement.RETURN_GENERATED_KEYS);
            // add data to SalaryScheme table 
			ps.setString(1, ss.getTitle());
			ps.setString(2, ss.getCriteria());
			ps.setString(3, ss.getDescription());
			ps.setString(4, "Prabath");

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				rs = ps.getGeneratedKeys();
				int generatedKey = 0;
				if (rs.next()) {
					//get generated key as SalaryScheme id
					generatedKey = rs.getInt(1);
				}
				status = generatedKey;
                //check weather component ids are existing 
				if ((ss.getcomponent_id() != null)
						|| (ss.getcomponent_id().length == 0)) {
					//call addScheme method to add 
					addSheme(ss.getcomponent_id(),generatedKey,conn);					
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}if (rs != null) {
					rs.close();
				}
				//closing connection
				conn.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	private int addSheme(String[] comp_id,int scheme_id, Connection conn) throws Exception{		
		String schemeCompQuery = "INSERT INTO [HRA.SCHEMECOMPONENT] (SCHEME, COMPONENT, MODBY) VALUES (?, ?, ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int status = 0;

		try {
			// Use the mask here
			// Create connection
			conn = ConnectionManager.getConnection();
			//initialize ps prepared Statement
			ps = conn.prepareStatement(schemeCompQuery, Statement.RETURN_GENERATED_KEYS);

			//get each component id s and add it in to schema table with schema id
			for (String c_id : comp_id) {
				log.info(c_id+"...............................................................");
				ps.setInt(1, scheme_id);
				ps.setString(2, c_id);
				ps.setString(3, "Prabath");
			}			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				rs = ps.getGeneratedKeys();
				int generatedKey = 0;
				if (rs.next()) {
					// get generated id 
					generatedKey = rs.getInt(1);
				}
				status = generatedKey;				
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} //Connection closing is belong to parent method add
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
