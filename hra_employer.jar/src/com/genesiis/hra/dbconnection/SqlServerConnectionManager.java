package com.genesiis.hra.dbconnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

///***********************************************
//* 20160427 PN HRA-9 created SqlServerConnectionManager.java class
//*
//***********************************************/

public final class SqlServerConnectionManager {
	private static final String DB_JNDI_NAME = "java:/hraDatabase";
	private static DataSource dataSource;
	private volatile static SqlServerConnectionManager connectionManager ;
	Context context;
	
	private SqlServerConnectionManager() {		
		try {			
			this.context = new InitialContext(); 						
			dataSource = (DataSource) this.context.lookup(DB_JNDI_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return SqlServerConnection Database connection object
	 */
	public static synchronized SqlServerConnectionManager getConnection() {
		if (connectionManager == null) {
			connectionManager = new SqlServerConnectionManager();
		}
		return connectionManager;
	}
}
