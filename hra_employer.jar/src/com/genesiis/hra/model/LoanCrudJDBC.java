package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
/***********************************************
//* 20160510 PC HRA-13 created LoanCrudJDBC.java class
//* 20160513 PC HRA-13  validateEmployee() method Modified.
//***********************************************/
public class LoanCrudJDBC implements ICrud {
	static Logger log = Logger.getLogger(LoanCrudJDBC.class.getName());

	@Override
	//Add data to DB Table EMPLOYEE
	public int add(Object object) {
		String query = "INSERT INTO [HRA.LOAN] (EMPLOYEEID , DUEDATE , "
				+ "TOTALOUTSTANDING , GUARANTOR1 , GUARANTOR2, MONTHLYPAYMENT , ENDDATE, MODBY)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
		int status = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);			
			ps.setString(1, lnDetail.getemployeeEpf());
			ps.setString(2, lnDetail.getLoanDueDate());
			ps.setString(3, lnDetail.getLoanAmount());
			ps.setString(4, lnDetail.getLoanGuarantor1());
			ps.setString(5, lnDetail.getLoanGuarantor2());
			ps.setString(6, lnDetail.getLoanmonthlyPayment());
			ps.setString(7, lnDetail.getLoanEndDate());
			ps.setString(8, "Saman");
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object, String epf) {
		String query = "UPDATE [hra-2].[dbo].[HRA.LOAN] SET EMPLOYEEID = ? ,  DUEDATE = ? , "
				+ "  TOTALOUTSTANDING = ? ,  GUARANTOR1 = ? , GUARANTOR2 = ? ,  MONTHLYPAYMENT = ?, ENDDATE = ?,  MODBY = ?  WHERE ID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);			
			ps.setString(1, lnDetail.getemployeeEpf());
			ps.setString(2, lnDetail.getLoanDueDate());
			ps.setString(3, lnDetail.getLoanAmount());
			ps.setString(4, lnDetail.getLoanGuarantor1());
			ps.setString(5, lnDetail.getLoanGuarantor2());
			ps.setString(6, lnDetail.getLoanmonthlyPayment());
			ps.setString(7, lnDetail.getLoanEndDate());
			ps.setString(8, "Saman");
			ps.setString(9, epf);			

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
			}
		} catch (SQLException exception) {
			exception.printStackTrace();		
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return 1;
	}	

	@Override
	public Object find(int empEpf) {
		
		String query = "select * from [hra-2].[dbo].[HRA.LOAN] where ID = ?";
		String message = "Error";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		Loan loan = new Loan();
		try {

			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "1");			
			 rs = ps.executeQuery();			 
				
				try{
					if (rs.next()) {
						// set data to entity class						
						loan.setEmployeeId(rs.getString("EMPLOYEEID"));
						loan.setLoanDueDate(rs.getString("DUEDATE")); 						
						loan.setLoanAmount(rs.getString("TOTALOUTSTANDING"));
						loan.setLoanGuarantor1(rs.getString("GUARANTOR1"));
						loan.setLoanGuarantor2(rs.getString("GUARANTOR2"));
						loan.setLoanmonthlyPayment(rs.getString("MONTHLYPAYMENT"));
						loan.setLoanEndDate(rs.getString("ENDDATE"));
						loan.setmodBy(rs.getString("MODBY"));
						loan.setModOn(rs.getString("MODON"));
					}
				}catch(Exception e){
					log.info(e.toString());
				}
				
			ps.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		}finally{
			try {
				if (ps != null) {
					ps.close();
				}if (rs != null) {
					rs.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		
		return loan;
	}

	@Override
	public List<Object> find(String empIdenti) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findByEpf(String empEpf) {
		String query = "select * from [hra-2].[dbo].[HRA.LOAN] where ID = ?";
		String message = "Error";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		Loan loan = new Loan();
		try {

			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, empEpf);			
			 rs = ps.executeQuery();			 
				
				try{
					if (rs.next()) {
						// set data to entity class						
						loan.setEmployeeId(rs.getString("EMPLOYEEID"));
						loan.setLoanDueDate(rs.getString("DUEDATE")); 						
						loan.setLoanAmount(rs.getString("TOTALOUTSTANDING"));
						loan.setLoanGuarantor1(rs.getString("GUARANTOR1"));
						loan.setLoanGuarantor2(rs.getString("GUARANTOR2"));
						loan.setLoanmonthlyPayment(rs.getString("MONTHLYPAYMENT"));
						loan.setLoanEndDate(rs.getString("ENDDATE"));
						loan.setmodBy(rs.getString("MODBY"));
						loan.setModOn(rs.getString("MODON"));
					}
				}catch(Exception e){
					log.info(e.toString());
				}
				
			ps.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
		}finally{
			try {
				if (ps != null) {
					ps.close();
				}if (rs != null) {
					rs.close();
				}
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		
		return loan;
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
