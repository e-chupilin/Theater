package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.factory.PlayFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.utilities.ServletUtilities;

public class DeletePlayController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Delete play controller ...");
		Date date = Date.valueOf((String) request.getParameter(KEY_DELETE_PLAY_DATE));
		try {
			ServletUtilities.checkInputOnNull(date);
			IPlayDAO playDAO = PlayFactory.getClassFromFactory(PLAY_DAO);
			playDAO.deletePlay(date);
			redirect(CONTROLLER_EDIT_PLAY, response);
		} catch (DaoException | ValidationException e) {
			System.err.println(e.getMessage());
			request.setAttribute(KEY_PLAYS_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}
}