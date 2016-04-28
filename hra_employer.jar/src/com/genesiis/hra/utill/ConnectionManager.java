package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

import com.genesiis.hra.exception.ConnectionErrorException;

///***********************************************
//* 20160427 PN HRA-9 created SqlServerConnectionManager.java class
//* 20160428 PN HRA-9 name changed to ConnectionManager.java class. 
//***********************************************/

public class ConnectionManager {
	static Logger log = Logger.getLogger(ConnectionManager.class.getName());
	private static final String DB_JNDI_NAME = "java:/hraDatabase";
	private static DataSource dataSource;

	static {
		try {
			Context context;
			context = new InitialContext();
			dataSource = (DataSource) context.lookup(DB_JNDI_NAME);
			log.info("Datasource assigned Successfully.");
		} catch (Exception e) {
			log.error("Datasource NULL ", e);
		}
	}

	static Connection getConnection() throws SQLException, ConnectionErrorException {
		return dataSource.getConnection();
	}
}
