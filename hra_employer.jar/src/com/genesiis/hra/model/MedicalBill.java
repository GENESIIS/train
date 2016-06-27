package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.MessageList;

public class MedicalBill {
	static Logger log = Logger.getLogger(MedicalHistory.class.getName());

	private String medicalBillId;
	private String medicalBillEmployeeId;
	private String medicalBillDescription;
	private String medicalBillPath;
	private String medicalBillcrtby;
	private String medicalBillcrton;

	public String getMedicalBillId() {
		return medicalBillId;
	}

	public void setMedicalBillId(String medicalBillId) {
		this.medicalBillId = medicalBillId;
	}

	public String getMedicalBillEmployeeId() {
		return medicalBillEmployeeId;
	}

	public void setMedicalBillEmployeeId(String medicalBillEmployeeId) {
		this.medicalBillEmployeeId = medicalBillEmployeeId;
	}

	public String getMedicalBillPath() {
		return medicalBillPath;
	}

	public void setMedicalBillPath(String medicalBillPath) {
		this.medicalBillPath = medicalBillPath;
	}

	public String getMedicalBillDescription() {
		return medicalBillDescription;
	}

	public void setMedicalBillDescription(String medicalBillDescription) {
		this.medicalBillDescription = medicalBillDescription;
	}

	public String getMedicalBillcrton() {
		return medicalBillcrton;
	}

	public void setMedicalBillcrton(String medicalBillcrton) {
		this.medicalBillcrton = medicalBillcrton;
	}

	public int add(Object object) {
		String query = "INSERT INTO [HRA.MEDICALBILL] (ID, EMPLOYEEID, BILLDESCRIPTION, BILLPATH, CRTBY, CRTON ) VALUES (?, ?, ?, ?, ?,GETDATE())";
		int insertStatus = -1;// when invalid insert
		Connection conn = null;// when connecting to database
		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalBill medicalBill = (MedicalBill) object;


		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, medicalBill.getMedicalBillId());
			ps.setString(2, medicalBill.getMedicalBillEmployeeId());
			ps.setString(3, medicalBill.getMedicalBillDescription());
			ps.setString(4, medicalBill.getMedicalBillPath());
			ps.setString(5, medicalBill.getMedicalBillcrtby());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted > 0) {
				insertStatus = 1;// when valid insert
			}

			rs = ps.getGeneratedKeys();

			try {
				if (rs.next()) {
					MaskValidator.SQL_RECODE = Integer
							.parseInt(rs.getString(1));
					log.info("Medical Bill ID:" + MaskValidator.SQL_RECODE);
				} else {
					throw new SQLException(
							MessageList.MEDICALBILLNOID.message());
				}
			} catch (SQLException exception) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				exception.printStackTrace();
				log.info("Exception: Medical Bill Add" + exception);
			}

		} catch (SQLException exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception- Medical Bill - SQLException - add"
					+ exception);
		} catch (Exception exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception- Medical Bill - Exception - add" + exception);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.info("Exception- Medical Bill - SQLException - add"
						+ exception);
			}
		}
		// insertStatus=1 ; when success
		// insertStatus=-1 ; when fails
		return insertStatus;

	}

	public String getMedicalBillcrtby() {
		return medicalBillcrtby;
	}

	public void setMedicalBillcrtby(String medicalBillcrtby) {
		this.medicalBillcrtby = medicalBillcrtby;
	}


}
