package by.gsu.epamlab.model.implementation;

import static by.gsu.epamlab.model.ConstantsModel.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.connections.MySqlConnection;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;

public class MySqlUserImpl implements IUserDAO {

	public User getUser(String login, Role currentSessionRole) throws DaoException {
		return getUser(login, NO_PASSWORD, currentSessionRole);
	}

	public User getUser(String login, String password) throws DaoException {
		Role role = User.makeUserRole(login, password);
		if (!Role.VIEWER.equals(role)) {
			return new User(role);
		}
		return getUser(login, password, role);
	}

	private User getUser(String login, String password, Role currentSessionRole) throws DaoException {
		// Bad way to get connection from DriverManager.getConnection
		// I could not configure TomCat pool connection, and use singleton for
		// test.
		// In next release I will use pool connection
		PreparedStatement psSelectLogin = null;
		ResultSet rsUser = null;
		Connection cn = null;

		try {
			cn = MySqlConnection.getConnection();
			psSelectLogin = cn.prepareStatement(SQL_PS_SELECT_USER);
			psSelectLogin.setString(SQL_PS_INSERT_INDEX, login);
			rsUser = psSelectLogin.executeQuery();

			if (rsUser.first()) {
				boolean isCurrentRoleAdminCourier = (Role.ADMIN.equals(currentSessionRole)
						|| Role.COURIER.equals(currentSessionRole));
				if (password.equals(rsUser.getString(SQL_PASSWORD_INDEX)) || isCurrentRoleAdminCourier) {

					return new User(rsUser.getString(SQL_LOGIN_INDEX), rsUser.getString(SQL_FULLNAME_INDEX),
							rsUser.getString(SQL_PHONENUMBER_INDEX), Role.VIEWER);
				} else
					throw new ValidationException(ERROR_USER_VERIFICATION);
			} else {
				throw new ValidationException(ERROR_USER_VERIFICATION);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(ERROR_SQL_DAO);
		} finally {
			MySqlConnection.closeStatement(psSelectLogin);
			MySqlConnection.closeResultSet(rsUser);
			MySqlConnection.closeConnection();
		}
	}

	public synchronized void setUser(String login, String password, String fullName, String phoneNumber)
			throws DaoException {
		// Bad way to get connection from DriverManager.getConnection.
		// I could not configure TomCat pool connection, and use singleton for
		// test.
		// In next release I will use pool connection.

		if (isUserPresent(login))
			throw new ValidationException(ERROR_USER_LOGIN_BUSY);

		PreparedStatement psSetUser = null;
		ResultSet rsUser = null;
		Connection cn = null;
		try {

			cn = MySqlConnection.getConnection();
			psSetUser = cn.prepareStatement(SQL_PS_INSERT_USER);
			psSetUser.setString(SQL_PS_LOGIN_INDEX, login);
			psSetUser.setString(SQL_PS_PASSWORD_INDEX, password);
			psSetUser.setString(SQL_PS_FULLNAME_INDEX, fullName);
			psSetUser.setString(SQL_PS_PHONENUMBER_INDEX, phoneNumber);
			psSetUser.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(ERROR_SQL_DAO);
		} finally {
			MySqlConnection.closeStatement(psSetUser);
			MySqlConnection.closeResultSet(rsUser);
			MySqlConnection.closeConnection();
		}
	}

	public boolean isUserPresent(String login) throws DaoException {
		// Bad way to get connection from DriverManager.getConnection.
		// I could not configure TomCat pool connection, and use singleton for
		// test.
		// In next release I will use pool connection.
		PreparedStatement psSelectLogin = null;
		ResultSet rsUser = null;
		Connection cn = null;

		if (User.isProtectedLogin(login)) {
			return true;
		}

		try {
			cn = MySqlConnection.getConnection();
			psSelectLogin = cn.prepareStatement(SQL_PS_SELECT_USER);
			psSelectLogin.setString(SQL_PS_INSERT_INDEX, login);
			rsUser = psSelectLogin.executeQuery();

			if (rsUser.first()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(ERROR_SQL_DAO);
		} finally {
			MySqlConnection.closeStatement(psSelectLogin);
			MySqlConnection.closeResultSet(rsUser);
			MySqlConnection.closeConnection();
		}
	}
}
