/**
 * 20160523 PN HRA-3 created SalaryComponent.java class
 */
package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;

/**
 * This class is the data access class when creating a Salary Component.
 */
public class SalaryComponent implements ICrud {
	static Logger log = Logger.getLogger(SalaryComponent.class.getName());

	String componentType, componentName, description, modBy, currency, rate;
	double minAmount, maxAmount;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponenttype(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentname() {
		return componentName;
	}

	public void setComponentname(String componentName) {
		this.componentName = componentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinamount() {
		return minAmount;
	}

	public void setMinamount(double minAmount) {
		this.minAmount = minAmount;
	}

	public double getMaxamount() {
		return maxAmount;
	}

	public void setMaxamount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	/**
	 * Salary Component empty constructor
	 * **/
	public SalaryComponent() {
	}

	/**
	 * Salary Component constructor with fields
	 */
	public SalaryComponent(String ct, String cn, String des, String mb,
			double min, double max, String r, String cr) {
		this.componentType = ct;
		this.componentName = cn;
		this.description = des;
		this.modBy = mb;
		this.minAmount = min;
		this.maxAmount = max;
		this.rate = r;
		this.currency = cr;
	}

	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.SALARYCOMPONENT] (COMPONENTTYPE, NAME, DESCRIPTION, CURRANCY, "
				+ "MINSALARY, MAXSALARY, RATE, MODBY) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;
		SalaryComponent cs = (SalaryComponent) object;
		int status = 0;

		try {
			// Use the mask here
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			
			
			ps.setString(1, cs.getComponentType());
			ps.setString(2, cs.getComponentname());
			ps.setString(3, cs.getDescription());
			ps.setString(4, cs.getCurrency());
			ps.setDouble(5, cs.getMinamount());
			ps.setDouble(6, cs.getMaxamount());
			ps.setString(7, cs.getRate());
			ps.setString(8, "SYSTEM");

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
	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String compKey) throws SQLException, Exception {
		List<Object> componentList = new LinkedList<Object>();
		String query = "SELECT * FROM [HRA.SALARYCOMPONENT] WHERE COMPONENTTYPE = ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet findData = null;
		
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,compKey);
			findData = ps.executeQuery();
			try {
				while(findData.next()){					
					// set data to entity class
					SalaryComponent salComponent = new SalaryComponent();
					salComponent.setComponenttype(findData.getString("COMPONENTTYPE"));
					salComponent.setComponentname(findData.getString("NAME"));
					salComponent.setDescription(findData.getString("DESCRIPTION"));
					salComponent.setCurrency(findData.getString("CURRANCY"));
					salComponent.setMinamount(findData.getDouble("MINSALARY"));
					salComponent.setMaxamount(findData.getDouble("MAXSALARY"));
					salComponent.setRate(findData.getString("RATE"));
					componentList.add(salComponent);
					log.info("Inside loop at find methode");
				}
			} catch (Exception e) {
				log.error("find methode "+e.toString());
			}
		} catch (Exception e) {
			log.error("find methode "+e.toString());
		}finally{
			try {
				if (ps != null) {
					ps.close();
				}
				if (findData != null) {
					findData.close();
				}
				if (conn != null) {
					conn.close();
				}				
			} catch (SQLException e) {
				log.info("find methode "+ e.toString());
			}
		}
		return componentList;
	}

	@Override
	public Object findByEpf(String empEpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
}
