package by.gsu.epamlab.model.connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static by.gsu.epamlab.model.ConstantsModel.*;

import by.gsu.epamlab.model.exceptions.DaoException;

public class MySqlPoolConnection {

	public static Connection getPoolConnection() {		
		/*InitialContext initContext;
		try {
			initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
		    ds.getConnection();

		} catch (NamingException | SQLException  e1) {
			e1.printStackTrace();
		}*/		
		return null;
	}

	public static void closeConnection(Connection connection) throws DaoException {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.err.println(ERROR_SQL_FAIL_CLOSE_CONNECT);
				e.printStackTrace();
			}
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