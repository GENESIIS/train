package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

///***********************************************
//* 20160427 PN HRA-9 created SqlServerConnectionManager.java class
//* 20160428 PN HRA-9 name changed to ConnectionManager.java class. 
//* 20160504 PN HRA-9 static block changed with 
//***********************************************/

public class ConnectionManager {
	static Logger log = Logger.getLogger(ConnectionManager.class.getName());

	// The DB_JNDI_NAME is the property for data source name that the
	// application looking at runtime.
	private static final String DB_JNDI_NAME = "java:/hraDatabase";
	private static DataSource dataSource;

	// This static{} block runs first when running the ConnectionManager class
	// object.
	static {
		try {
			// From the datasource name, we get the datasource which we have
			// mentioned in hra.xml file.
			dataSource = (DataSource) new InitialContext().lookup(DB_JNDI_NAME);
		} catch (NullPointerException e) {
			log.error("NullPointerException: look up dataSource: " + e);
		} catch (NamingException e) {
			log.error("NamingException: nameing the dataSource " + e);
		} catch (ClassCastException e) {
			log.error("ClassCastException: casting dataSource = (DataSource) "
					+ e);
		} catch (Exception e) {
			log.error("Exception: dataSource = (DataSource) " + e);
		} finally {
			log.error("ConnectionManager static block execution over.");
		}
	}

	// This method only return the Connection type variable for other classed,
	// to access the dataSource through that.
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}