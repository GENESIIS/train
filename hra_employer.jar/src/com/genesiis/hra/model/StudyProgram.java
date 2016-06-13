package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;

public class StudyProgram extends Employee {
	static Logger log = Logger.getLogger(StudyProgram.class.getName());
	private String institution;
	private String typofCourse;
	private String admissionDate;
	private String duration;
	private String studyTime;
	private String ProgramEndDate;	
	
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getTypofCourse() {
		return typofCourse;
	}
	public void setTypofCourse(String typofCourse) {
		this.typofCourse = typofCourse;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}
	public String getProgramEndDate() {
		return ProgramEndDate;
	}
	public void setProgramEndDate(String programEndDate) {
		ProgramEndDate = programEndDate;
	}
	
	//add study program detail
	@Override
	public int add(Object object) {
		String query = "INSERT INTO [HRA.STUDYPROGRAM] (EMPLOYEEID, STUDYTIME, "
				+ "INSTITUTION, COURSETYPE, ADDMISIONDATE, ENDDATE, DURATION, MODBY, MODON) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE())";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		int insertStatus = 0;
		log.info("Inside add method");	
		try {
			StudyProgram employee = (StudyProgram) object;			
			conn = ConnectionManager.getConnection();			
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, employee.getEmployeeepf());
			ps.setString(2, employee.getStudyTime());
			ps.setString(3, employee.getInstitution());
			ps.setString(4, employee.getTypofCourse());
			ps.setString(5, employee.getAdmissionDate());
			ps.setString(6, employee.getProgramEndDate());
			ps.setString(7, employee.getDuration());
			ps.setString(8, "SYSTEM");		
			
			log.info("prepared statment executed");			
		int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()){
					insertStatus = rs.getInt(1);
					log.info(insertStatus);
				}
			}		

		} catch (SQLException exception) {
			log.error(exception);			
		} catch (ClassCastException e) {
			log.error(e);			
		}catch (Exception ex) {
			log.error(ex);			
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();				
			} catch (SQLException exception) {
				log.error(exception);
			}
		}
		log.error(insertStatus);
		return insertStatus;
	}
	
	@Override
	public int update(Object object, String epf) {
		String query = "UPDATE [dbo].[HRA.STUDYPROGRAM] SET EMPLOYEEID = ? ,  STUDYTIME = ? , "
				+ "  INSTITUTION = ? ,  COURSETYPE = ? ,  ADDMISIONDATE = ?,  ENDDATE = ?,  DURATION = ?, MODBY = ?, "
				+ "  MODON = GETDATE() WHERE EMPLOYEEID = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		int insertStatus = -1;
		log.info("Inside add method");	
		try {
			StudyProgram employee = (StudyProgram) object;			
			conn = ConnectionManager.getConnection();			
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,epf);
			ps.setString(2, employee.getStudyTime());
			ps.setString(3, employee.getInstitution());
			ps.setString(4, employee.getTypofCourse());
			ps.setString(5, employee.getAdmissionDate());
			ps.setString(6, employee.getProgramEndDate());
			ps.setString(7, employee.getDuration());
			ps.setString(8, "SYSTEM");	
			ps.setString(9, epf);	
			
			log.info("prepared statment executed");			
		int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				rs = ps.getGeneratedKeys();
				if(rs.next()){
					insertStatus = rs.getInt(1);
					log.info(insertStatus);
				}
			}		

		} catch (SQLException exception) {
			log.error(exception);			
		} catch (ClassCastException e) {
			log.error(e);			
		}catch (Exception ex) {
			log.error(ex);			
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.close();				
			} catch (SQLException exception) {
				log.error(exception);
			}
		}
		log.info(insertStatus);
		return insertStatus;
	}
	
	// use for View study data data 
		@Override
		public Object findByEpf(String epf) {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			StudyProgram emp = new StudyProgram();

			log.info(epf + "id String"); 
			try {
				conn = ConnectionManager.getConnection();
				preparedStatement = conn
						.prepareStatement("SELECT * FROM [dbo].[HRA.STUDYPROGRAM] WHERE EMPLOYEEID = ?");
				preparedStatement.setString(1, epf);
				ResultSet res = preparedStatement.executeQuery();
				if (res.next()) {

					emp.setStudyTime(res.getString(3));
					emp.setInstitution(res.getString(4));
					emp.setTypofCourse(res.getString(5));
					emp.setAdmissionDate(res.getString(6));
					emp.setProgramEndDate(res.getString(7));
					emp.setDuration(res.getString(8));
					log.info(epf);
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info(e);
			}
			return emp;
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
	

}
