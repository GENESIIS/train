package com.genesiis.hra.utill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jboss.logging.Logger;
import com.genesiis.hra.exception.ConnectionErrorException;

// /***********************************************
// * 20160428 PN HRA-9 created ConnectionTester.java class
// * This class created only to test the ConnectionManager.java class functionality.
// * Not related with any module in HRA Project.
// ***********************************************/

public class ConnectionTester {
	static org.jboss.logging.Logger log = Logger
			.getLogger(ConnectionTester.class.getName());

	public int testing() throws Exception {
		int i = -1;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String selectQuerry = "SELECT * FROM [HRA.DEPARTMENT]";

		try {
			conn = ConnectionManager.getConnection();
			if (conn == null) {
				throw new ConnectionErrorException();
			}
			preparedStatement = conn.prepareStatement(selectQuerry);
			rs = preparedStatement.executeQuery();
			i = 1;
			log.info("Connection set from the testing class.");
		} catch (ConnectionErrorException e) {
			e.printStackTrace();
			log.error("Error in Catch 01 " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					log.info("rs.close()");
				}
				if (preparedStatement != null) {
					preparedStatement.close();
					log.info("preparedStatement.close()");
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
				log.error("Error in Catch 01 " + exception);
			}
		}
		return i;
	}
}
