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
	private int leaveCount;
	private String leavePayment;
	

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

	
	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getLeavePayment() {
		return leavePayment;
	}

	public void setLeavePayment(String leavePayment) {
		this.leavePayment = leavePayment;
	}

	public LeaveType() {
	
	}

	public LeaveType(String leaveType, String leaveDuration, int leaveCount,
			String leavePayment) {
		super();
		this.leaveType = leaveType;
		this.leaveDuration = leaveDuration;
		this.leaveCount = leaveCount;
		this.leavePayment = leavePayment;
		
	}

	public int add(Object object) {
		String query = "INSERT INTO [HRA.LEAVETYPE] (LEAVETYPE, LEAVEDURATION, "
				+ "LEAVECOUNT, WITHPAYORNOPAY) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LeaveType data = (LeaveType) object;
		int insertStatus = 0;
		/*System.out.print(data.getLeaveType()+" "+data.getLeaveDuration()+" "+data.getLeaveCount()+" inside query");*/
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, data.getLeaveType());
			ps.setString(2, data.getLeaveDuration());
			ps.setInt(3, data.getLeaveCount());
			ps.setString(4, data.getLeavePayment());
		
			insertStatus = ps.executeUpdate();
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

	@Override
	public int update(Object object, String epf) {
		// TODO Auto-generated method stub
		return super.update(object, epf);
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return super.delete(object);
	}

	@Override
	public Object find(int empEpf) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return super.find(empEpf);
	}

	@Override
	public List find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return super.find(empIdenti);
	}

	@Override
	public Object findByEpf(String empEpf) {
		// TODO Auto-generated method stub
		return super.findByEpf(empEpf);
	}

	@Override
	public String getId(String id) {
		// TODO Auto-generated method stub
		return super.getId(id);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return super.isValidObject(object);
	}
	
}
