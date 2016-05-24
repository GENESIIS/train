/**
 * 20160523 PN HRA-3 created SalaryComponent.java class
 */
package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.genesiis.hra.utill.ConnectionManager;

/**
 * This class is the data access class when creating a Salary Component.
 */
public class SalaryComponent implements ICrud {
	String componentType, componentName, description, modBy, currency;
	double minAmount, maxAmount, rate;

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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
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
			double min, double max, double r, String cr) {
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
		PreparedStatement preparedStatement = null;
		SalaryComponent cs = (SalaryComponent) object;
		int status = 0;
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, cs.getComponentType());
			preparedStatement.setString(2, cs.getComponentname());
			preparedStatement.setString(3, cs.getDescription());
			preparedStatement.setDouble(4, cs.getMinamount());
			preparedStatement.setString(5, cs.getCurrency());
			preparedStatement.setDouble(6, cs.getMaxamount());
			preparedStatement.setDouble(7, cs.getRate());
			preparedStatement.setString(8, "SYSTEM");

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				status = rowsInserted;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object) {
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
