package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.genesiis.hra.model.EmploymentHistory;

//* 20160504 PN HRA-9 static block changed with 
//***********************************************/


public class ConnectionManager {
	static Logger log = Logger.getLogger(ConnectionManager.class.getName());

	private static final String DB_JNDI_NAME = "java:/hraDatabase";
	private static DataSource dataSource;

	static {
		try {
			dataSource = (DataSource) new InitialContext().lookup(DB_JNDI_NAME);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
			log.info("NullPointerException: look up dataSource: " + e);
		} catch (ClassCastException e) {
			log.info("ClassCastException: casting dataSource = (DataSource) "+ e);
		} finally {
			log.info("ConnectionManager static block execution over.");
		}
	}

	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}