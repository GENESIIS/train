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
		PreparedStatement preparedStatement = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);			
			preparedStatement.setString(1, lnDetail.getemployeeEpf());
			preparedStatement.setString(2, lnDetail.getLoanDueDate());
			preparedStatement.setString(3, lnDetail.getLoanAmount());
			preparedStatement.setString(4, lnDetail.getLoanGuarantor1());
			preparedStatement.setString(5, lnDetail.getLoanGuarantor2());
			preparedStatement.setString(6, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(7, lnDetail.getLoanEndDate());
			preparedStatement.setString(8, "Saman");
			
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				status = 1;
			}
		} catch (SQLException exception) {
			
			exception.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public int update(Object object) {
		String query = "UPDATE [hra-2].[dbo].[HRA.LOAN] SET EMPLOYEEID = ? ,  DUEDATE = ? , "
				+ "  TOTALOUTSTANDING = ? ,  GUARANTOR1 = ? , GUARANTOR2 = ? ,  MONTHLYPAYMENT = ?, ENDDATE = ?,  MODBY = ?  WHERE ID = ?";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);			
			preparedStatement.setString(1, lnDetail.getemployeeEpf());
			preparedStatement.setString(2, lnDetail.getLoanDueDate());
			preparedStatement.setString(3, lnDetail.getLoanAmount());
			preparedStatement.setString(4, lnDetail.getLoanGuarantor1());
			preparedStatement.setString(5, lnDetail.getLoanGuarantor2());
			preparedStatement.setString(6, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(7, lnDetail.getLoanEndDate());
			preparedStatement.setString(8, "Saman");
			preparedStatement.setString(9, "1");			

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
			}
		} catch (SQLException exception) {
			exception.printStackTrace();		
		} finally {
			try {
				preparedStatement.close();
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
		PreparedStatement preparedStatement = null;
		ResultSet retriveData = null;		
		Loan loan = new Loan();
		try {

			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, "1");			
			 retriveData = preparedStatement.executeQuery();			 
				
				try{
					if (retriveData.next()) {
						// set data to entity class						
						loan.setEmployeeId(retriveData.getString("EMPLOYEEID"));
						loan.setLoanDueDate(retriveData.getString("DUEDATE")); 						
						loan.setLoanAmount(retriveData.getString("TOTALOUTSTANDING"));
						loan.setLoanGuarantor1(retriveData.getString("GUARANTOR1"));
						loan.setLoanGuarantor2(retriveData.getString("GUARANTOR2"));
						loan.setLoanmonthlyPayment(retriveData.getString("MONTHLYPAYMENT"));
						loan.setLoanEndDate(retriveData.getString("ENDDATE"));
						loan.setmodBy(retriveData.getString("MODBY"));
						loan.setModOn(retriveData.getString("MODON"));
					}
				}catch(Exception e){
					log.info(e.toString());
				}
				
			preparedStatement.close();
			conn.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			
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
