package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

///***********************************************
//* 20160427 PN HRA-9 created SqlServerConnectionManager.java class
//* 20160428 PN HRA-9 name changed to ConnectionManager.java class. 
//* 20160525 AS HRA-32 static block changed 
//***********************************************/


public class ConnectionManager {
	static Logger log = Logger.getLogger(ConnectionManager.class.getName());

	private static final String DB_JNDI_NAME = "java:/hraDatabase";
	// The DB_JNDI_NAME is the property for data source name that the
	// application looking at runtime.	 
	private static DataSource dataSource;

	// This static{} block runs first when running the ConnectionManager class
	// object.
	static {
		try {
			// From the datasource name, we get the datasource which we have
			// mentioned in hra.xml file.
			dataSource = (DataSource) new InitialContext().lookup(DB_JNDI_NAME);
		} catch (NullPointerException e) {
			log.info("NullPointerException: look up dataSource: " + e);
		} catch (NamingException e) {
			e.printStackTrace();
			log.info("NullPointerException: look up dataSource: " + e);
		} catch (ClassCastException e) {
			log.info("ClassCastException: casting dataSource = (DataSource) " + e);
		} finally {
			log.info("ConnectionManager static block execution over.");
		}
	}

	// This method only return the Connection type variable for other classed,
	// to access the dataSource through that.
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}