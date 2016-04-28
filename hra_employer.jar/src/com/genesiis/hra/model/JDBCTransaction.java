package com.genesiis.hra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.genesiis.hra.utill.ConnectionManager;
import com.genesiis.hra.validation.MessageList;

public class JDBCTransaction implements IDataAccessor {
	private Connection conn;

	@Override
	public String add(Object object) {
		String sql = "INSERT INTO HRA.DEPARTMENT (ID, NAME, LOCATION, MANAGERID, MODBY, MODON) VALUES (?, ?, ?, ?)";
		String message = MessageList.UNKNOWN.message();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "");
			statement.setString(2, "");
			statement.setString(3, "");
			statement.setString(4, "");
			statement.setString(5, "");
			statement.setString(6, "");

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				message = MessageList.ADDED.message();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			message = MessageList.ERROR.message();
		}
		return null;
	}

	@Override
	public String update(Object object) {
		String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "123456789");
		statement.setString(2, "William Henry Bill Gates");
		statement.setString(3, "bill.gates@microsoft.com");
		statement.setString(4, "bill");

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("An existing user was updated successfully!");
		}
		return null;
	}

	@Override
	public String delete(Object object) {
		String sql = "DELETE FROM Users WHERE username=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "bill");

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("A user was deleted successfully!");
		}
		return null;
	}

	@Override
	public String getObjectid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		String sql = "SELECT * FROM Users";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		int count = 0;

		while (result.next()) {
			String name = result.getString(2);
			String pass = result.getString(3);
			String fullname = result.getString("fullname");
			String email = result.getString("email");

			String output = "User #%d: %s - %s - %s - %s";
			System.out.println(String.format(output, ++count, name, pass,
					fullname, email));
		}
		return null;
	}

}
