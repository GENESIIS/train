package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.utill.MaskValidator;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;

/**
 * 
 * 2016-05-24 class created to add medical data - entity class
 * 
 * @author thumeera @TR
 * **/
public class MedicalHistory extends Employee {

	static Logger log = Logger.getLogger(MedicalHistory.class.getName());

	private String medicalHistorycode;
	private String medicalHistoryemployeeid;
	private String medicalHistoryailment;
	private String medicalHistorydescription;
	private String medicalHistorymodby;
	private String medicalHistorymodon;
	private String medicalHistorycrtby;
	private String medicalHistorycrton;
	private String mdeicalReportDis;
	private String MedicalReportPath;

	public String getMedicalhistorycode() {
		return medicalHistorycode;
	}

	public void setMedicalhistorycode(String medicalHistorycode) {
		this.medicalHistorycode = medicalHistorycode;
	}

	public String getMedicalhistoryemployeeid() {
		return medicalHistoryemployeeid;
	}

	public void setMedicalhistoryemployeeid(String medicalHistoryemployeeid) {
		this.medicalHistoryemployeeid = medicalHistoryemployeeid;
	}

	public String getMedicalhistoryailment() {
		return medicalHistoryailment;
	}

	public void setMedicalhistoryailment(String medicalHistoryailment) {
		this.medicalHistoryailment = medicalHistoryailment;
	}

	public String getMedicalhistorydescription() {
		return medicalHistorydescription;
	}

	public void setMedicalhistorydescription(String medicalHistorydescription) {
		this.medicalHistorydescription = medicalHistorydescription;
	}

	public String getMedicalhistorymodby() {
		return medicalHistorymodby;
	}

	public void setMedicalhistorymodby(String medicalHistorymodby) {
		this.medicalHistorymodby = medicalHistorymodby;
	}

	public String getMedicalhistorymodon() {
		return medicalHistorymodon;
	}

	public void setMedicalhistorymodon(String medicalHistorymodon) {
		this.medicalHistorymodon = medicalHistorymodon;
	}

	public String getMedicalhistorycrtby() {
		return medicalHistorycrtby;
	}

	public void setMedicalhistorycrtby(String medicalHistorycrtby) {
		this.medicalHistorycrtby = medicalHistorycrtby;
	}

	public String getMedicalhistorycrton() {
		return medicalHistorycrton;
	}

	public void setMedicalhistorycrton(String medicalHistorycrton) {
		this.medicalHistorycrton = medicalHistorycrton;
	}

	public void setMedicalReportDiscription(String mdeicalReportDis) {
		this.mdeicalReportDis = mdeicalReportDis;
	}

	public void setMedicalReportPath(String MedicalReportPath) {
		this.MedicalReportPath = MedicalReportPath;
	}

	/**
	 * @param mh
	 *            - Medical History
	 * @param ps
	 *            - Prepared Statement
	 * @param rs
	 *            - Result Set
	 * **/
	public int add(Object object) {
		String query = "INSERT INTO [HRA.MEDICALHISTORY] (EMPLOYEEID, AILMENT, DESCRIPTION, MODBY, MODON, CRTBY, CRTON ) VALUES (?, ?, ?, ?,GETDATE(), ?, GETDATE())";
		int insertStatus = -1;// when invalid insert
		Connection conn = null;// when connecting to database
		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalHistory medicalHistory = (MedicalHistory) object;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, medicalHistory.getMedicalhistoryemployeeid());
			ps.setString(2, medicalHistory.getMedicalhistoryailment());
			ps.setString(3, medicalHistory.getMedicalhistorydescription());
			ps.setString(4, medicalHistory.getMedicalhistorymodby());
			ps.setString(5, medicalHistory.getMedicalhistorycrtby());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted > 0) {
				insertStatus = 1;// when valid insert
			}

			rs = ps.getGeneratedKeys();

			try {
				if (rs.next()) {
					MaskValidator.SQL_RECODE = Integer
							.parseInt(rs.getString(1));
					log.info("Medical History ID:" + MaskValidator.SQL_RECODE);
				} else {
					throw new SQLException(
							MessageList.MEDICALHISTORYNOID.message());
				}
			} catch (SQLException exception) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				exception.printStackTrace();
				log.info("Exception: Medical History Add" + exception);
			}

		} catch (SQLException exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception- Medical History - SQLException - add"
					+ exception);
		} catch (Exception exception) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			exception.printStackTrace();
			log.info("Exception- Medical History - Exception - add" + exception);
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
				log.info("Exception- Medical History - SQLException - add"
						+ exception);
			}
		}
		// insertStatus=1 ; when success
		// insertStatus=-1 ; when fails
		return insertStatus;

	}

	public String getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object findByEpf(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		MedicalHistory mh = new MedicalHistory();
		log.info(id + "//");
		try {
			String path = null;
			conn = ConnectionManager.getConnection();
			ps = conn
					.prepareStatement("SELECT [HRA.MEDICALHISTORY].EMPLOYEEID, [HRA.MEDICALHISTORY].AILMENT, [HRA.MEDICALHISTORY].DESCRIPTION, [HRA.MEDICALREPORT].REPORTDESCRIPTION, [HRA.MEDICALREPORT].REPORTPATH FROM [HRA.MEDICALHISTORY] INNER JOIN [HRA.MEDICALREPORT] ON [HRA.MEDICALHISTORY].CODE=[HRA.MEDICALREPORT].CODE WHERE [HRA.MEDICALHISTORY].EMPLOYEEID =?");
			ps.setString(1, id);

			ResultSet res = ps.executeQuery();
			if (res.next()) {
				// mh.setEmployeeepf(res.getString(2));
				mh.setMedicalhistoryailment(res.getString(2));
				mh.setMedicalhistorydescription(res.getString(3));
				mh.setMedicalReportDiscription(res.getString(4));
				// mh.setMedicalReportPath(res.getString(5));
				path = res.getString(5);
				String retvell[] = path.split("C:/sdb/ctxdeploy/hras.war");
				mh.setMedicalReportPath("http://localhost/hras" + retvell[1]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.error("Exception: Medical History Find" + exception);
			}
		}
		return mh;
	}
}