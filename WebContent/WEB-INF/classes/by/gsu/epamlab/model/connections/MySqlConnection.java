package by.gsu.epamlab.model.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.model.exceptions.DaoException;
import static by.gsu.epamlab.model.ConstantsModel.*;

public class MySqlConnection {
	private static Connection connection = null;

	public static Statement createStatement(Connection cn) throws DaoException {
		try {
			return cn.createStatement();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DaoException(ERROR_SQL_DAO);
		}
	}

	private static void loadDriver() throws DaoException {
		try {
			Class.forName(SQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DaoException(ERROR_SQL_DAO);
		}
	}

	private static void loadConnection() throws DaoException {
		try {
			connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new DaoException(ERROR_SQL_DAO);
		}
	}

	public static Connection getConnection() throws DaoException {
		if (connection == null) {
			loadDriver();
			loadConnection();
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection == null) {
			System.err.println(ERROR_SQL_FAIL_CLOSE_CONNECT);
		} else
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.err.println(ERROR_SQL_FAIL_CLOSE_CONNECT);
				e.printStackTrace();
			}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println(ERROR_SQL_FAIL_CLOSE_RESULT_SET);
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement... statements) {
		for (Statement statement : statements) {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ERROR_SQL_FAIL_CLOSE_STATEMENT);
					e.printStackTrace();
				}
			}
		}
	}
}
