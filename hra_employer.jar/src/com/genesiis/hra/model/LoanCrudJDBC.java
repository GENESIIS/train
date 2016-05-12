package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;

public class LoanCrudJDBC implements IDataAccessor {
	static Logger log = Logger.getLogger(LoanCrudJDBC.class.getName());

	@Override
	public String add(Object object) {
		String query = "INSERT INTO [HRA.LOAN] (EMPLOYEEID , DUEDATE , "
				+ "TOTALOUTSTANDING , BORROWER , MONTHLYPAYMENT , MODBY)"
				+ "VALUES (?, ?, ?, ?, ?,?) ";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, lnDetail.getemployeeEpf());
			preparedStatement.setString(2, lnDetail.getLoanDueDate());
			preparedStatement.setString(3, lnDetail.getLoanAmount());
			preparedStatement.setString(4, lnDetail.getLoanBorrowers());
			preparedStatement.setString(5, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(6, "Saman");
			
			

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String update(Object object) {		
		String query = "UPDATE [hra-2].[dbo].[HRA.LOAN] SET EMPLOYEEID = ? ,  DUEDATE = ? , "
				+ "  TOTALOUTSTANDING = ? ,  BORROWER = ? ,  MONTHLYPAYMENT = ?,  MODBY = ?  WHERE ID = ?";
		String message = MessageList.UNKNOWN.message();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Loan lnDetail = (Loan) object;

		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, lnDetail.getemployeeEpf());
			preparedStatement.setString(2, lnDetail.getLoanDueDate());
			preparedStatement.setString(3, lnDetail.getLoanAmount());
			preparedStatement.setString(4, lnDetail.getLoanBorrowers());
			preparedStatement.setString(5, lnDetail.getLoanmonthlyPayment());
			preparedStatement.setString(6, "Saman");
			preparedStatement.setString(7, "1");
			
			log.info(lnDetail.LoanBorrowers+"////////////////////////////////////////////////////////");

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
			log.info(exception+"////////////////////////////////////////////////////////");
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String delete(Object object) {
		return null;
	}

	@Override
	public Object retrive(String id) {
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
						loan.setLoanBorrowers(retriveData.getString("BORROWER"));
						loan.setLoanmonthlyPayment(retriveData.getString("MONTHLYPAYMENT"));
						loan.setmodBy(retriveData.getString("MODBY"));
						loan.setModOn(retriveData.getString("MODON"));
						
						
						log.info(retriveData.getString("TOTALOUTSTANDING")+"////////////////////////////////////////////////////////");
						

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
	public List<Object> getAll() {
		return null;
	}

	

	
}