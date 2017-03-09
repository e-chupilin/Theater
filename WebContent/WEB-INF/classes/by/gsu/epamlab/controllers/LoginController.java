package by.gsu.epamlab.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import by.gsu.epamlab.factory.UserFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.utilities.ServletUtilities;

public class LoginController extends AbstractBaseController {

	private static final long serialVersionUID = 1L;
	
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter(KEY_LOGIN);
		String password = request.getParameter(KEY_PASSWORD);

		try {
			System.out.println("Login Controller ...");
			checkInput(login, password);

			IUserDAO userDAO = UserFactory.getClassFromFactory(USER_DAO);
			User user = userDAO.getUser(login.trim(), password);
			HttpSession session = request.getSession();
			session.setAttribute(KEY_USER, user);
			
			if (Role.COURIER.equals(user.getRole())) {
				forward(PAGE_ADD_ORDER, request, response);
				return;
			}
			
			if (Role.ADMIN.equals(user.getRole())) {
				forward(PAGE_MAIN , request, response);
				return;
			}
			
			forward(CONTROLLER_PLAY, request, response);

		} catch (ValidationException | DaoException e) {
			System.err.println(e.getMessage());
			request.setAttribute(KEY_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}

	private static void checkInput(String login, String password) {
		if (login == null || password == null) {
			throw new ValidationException(ERROR_LOGIN_OR_PASSWORD_ABSENT);
		}
		login = login.trim();
		if (EMPTY.equals(login)) {
			throw new ValidationException(ERROR_LOGIN_EMPTY);
		}
	}
}