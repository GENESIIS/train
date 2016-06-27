package com.genesiis.hra.model;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Leaves;
import com.genesiis.hra.utill.ConnectionManager;

public class LeaveType extends Leaves {

	static Logger log = Logger.getLogger(LeaveType.class.getName());

	private String leaveType;
	private String leaveDuration;
	private String leaveCount;
	private String leavePayment;
	private int leaveID;

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveDuration() {
		return leaveDuration;
	}

	public void setLeaveDuration(String leaveDuration) {
		this.leaveDuration = leaveDuration;
	}

	public String getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(String leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getLeavePayment() {
		return leavePayment;
	}

	public void setLeavePayment(String leavePayment) {
		this.leavePayment = leavePayment;
	}

	public int getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}

	public LeaveType(String leaveType, String leaveDuration, String leaveCount,
			String leavePayment, int leaveID) {
		super();
		this.leaveType = leaveType;
		this.leaveDuration = leaveDuration;
		this.leaveCount = leaveCount;
		this.leavePayment = leavePayment;
		this.leaveID = leaveID;
	}

	public int add(Object object) {
		String query = "INSERT INTO [HRA.LEAVETYPE] (LEAVETYPE, LEAVEDURATION, "
				+ "LEAVECOUNT, WITHPAYORNOPAY, ID) " + "VALUES (?, ?, ?, ?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LeaveType data = (LeaveType) object;
		int insertStatus = 0;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, data.getLeaveType());
			ps.setString(2, data.getLeaveDuration());
			ps.setString(3, data.getLeaveCount());
			ps.setString(4, data.getLeavePayment());
			ps.setInt(5, data.getLeaveID());

			insertStatus = ps.executeUpdate();

			// if (rowsInserted > 0) {
			// insertStatus = 1;// when valid insert
			// }

			rs = ps.getGeneratedKeys();

		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}

		return insertStatus;
	}
}
