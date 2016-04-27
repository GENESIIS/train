package com.genesiis.hra.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public final class SqlServerConnection {
	public Connection conn;
	private Statement statement;
	public static SqlServerConnection db;

	private SqlServerConnection() {
		String url = "";
		String dbName = "";
		String driver = "";
		String userName = "";
		String password = "";
		
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName,
					userName, password);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * 
	 * @return SqlServerConnection Database connection object
	 */
	public static synchronized SqlServerConnection getConnection() {
		if (db == null) {
			db = new SqlServerConnection();
		}
		return db;
	}
}
