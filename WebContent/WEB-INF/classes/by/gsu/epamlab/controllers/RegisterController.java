package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.factory.UserFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.utilities.ServletUtilities;

public class RegisterController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Register controller ...");

		String regLogin = request.getParameter(KEY_REGISTER_LOGIN);
		String regFullName = request.getParameter(KEY_REGISTER_FULL_NAME);
		String regPhoneNumber = request.getParameter(KEY_REGISTER_PHONE_NUMBER);
		String regPassword = request.getParameter(KEY_REGISTER_PASSWORD);
		String regPasswordRepeat = request.getParameter(KEY_REGISTER_PASSWORD_REPEAT);

		try {
			checkInput(regLogin, regFullName, regPhoneNumber, regPassword, regPasswordRepeat);

			IUserDAO userDAO = UserFactory.getClassFromFactory(USER_DAO);
			userDAO.setUser(regLogin.trim(), regPassword, regFullName, regPhoneNumber);

			User user = userDAO.getUser(regLogin.trim(), regPassword);
			HttpSession session = request.getSession();

			session.setAttribute(KEY_USER, user);
			forward(CONTROLLER_PLAY, request, response);
		} catch (ValidationException | DaoException e) {
			forwardError(e.getMessage(), PAGE_REGISTER, request, response);
		}

	}

	private static void checkInput(String regLogin, String regFullName, String regPhoneNumber, String regPassword,
			String regPasswordRepeat) {

		ServletUtilities.checkInputOnNull(regLogin, regFullName, regPhoneNumber, regPassword, regPasswordRepeat);

		regLogin = regLogin.trim();
		if (EMPTY.equals(regLogin)) {
			throw new ValidationException(ERROR_LOGIN_EMPTY);
		}

		regFullName = regFullName.trim();
		if (EMPTY.equals(regFullName)) {
			throw new ValidationException(ERROR_FULL_NAME_EMPTY);
		}

		regPhoneNumber = regPhoneNumber.trim();
		if (EMPTY.equals(regPhoneNumber)) {
			throw new ValidationException(ERROR_PHONE_EMPTY);
		}
		if (!ServletUtilities.checkPhoneNumber(regPhoneNumber)) {
			throw new ValidationException(ERROR_PHONE_FORMAT);
		}

		regPassword = regPassword.trim();
		regPasswordRepeat = regPasswordRepeat.trim();

		if (EMPTY.equals(regPhoneNumber) | EMPTY.equals(regPasswordRepeat)) {
			throw new ValidationException(ERROR_PASSWORD_EMPTY);
		}

		if (!regPassword.equals(regPasswordRepeat)) {
			throw new ValidationException(ERROR_PASSWORD_NOT_EQUAL);
		}
	}
}