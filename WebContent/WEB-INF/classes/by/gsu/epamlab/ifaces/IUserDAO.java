package by.gsu.epamlab.ifaces;

import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.DaoException;

public interface IUserDAO {

	User getUser(String login, String password) throws DaoException;

	User getUser(String login, Role currentSessionRole) throws DaoException;

	void setUser(String login, String password, String fullName, String phoneNumber) throws DaoException;

	boolean isUserPresent(String login) throws DaoException;
}
