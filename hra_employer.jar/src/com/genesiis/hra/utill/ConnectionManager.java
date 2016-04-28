package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.genesiis.hra.exception.ConnectionErrorException;

///***********************************************
//* 20160427 PN HRA-9 created SqlServerConnectionManager.java class
//* 20160428 PN HRA-9 name changed to ConnectionManager.java class. 
//***********************************************/

public class ConnectionManager {
	private static final String DB_JNDI_NAME = "java:/hraDatabase";
	private static DataSource dataSource;

	static {
		try {
			dataSource = (DataSource) new InitialContext().lookup(DB_JNDI_NAME);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
