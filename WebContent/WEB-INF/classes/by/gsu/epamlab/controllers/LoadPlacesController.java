package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.factory.PlaceFactory;
import by.gsu.epamlab.factory.PlayFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IPlaceDAO;
import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.utilities.ServletUtilities;

public class LoadPlacesController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Load Places Controller ...");
		try {
			String dateString = request.getParameter(KEY_PLAY_DATE);

			ServletUtilities.checkInputOnNull(dateString);

			Date date = Date.valueOf(dateString);

			IPlayDAO playDAO = PlayFactory.getClassFromFactory(PLAY_DAO);
			HttpSession session = request.getSession();
			session.setAttribute(KEY_USER_PLAY, playDAO.getPlay(date));

			IPlaceDAO placeDAO = PlaceFactory.getClassFromFactory(PLACE_DAO);
			request.setAttribute(KEY_PLACE, placeDAO.getAllPlaces(date));

			forward(PAGE_BOOK_TICKET, request, response);
		} catch (DaoException | ValidationException e) {
			e.printStackTrace();
			request.setAttribute(KEY_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}
}