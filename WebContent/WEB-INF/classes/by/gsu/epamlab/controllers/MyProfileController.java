package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.factory.PlaceFactory;
import by.gsu.epamlab.factory.PlayFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IPlaceDAO;
import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.DaoException;

public class MyProfileController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	public MyProfileController() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("My profile controller ...");
		try {
			User user = (User) request.getSession().getAttribute(KEY_USER);
			
			IPlayDAO playDAO = PlayFactory.getClassFromFactory(PLAY_DAO);
			request.setAttribute(KEY_PLAYS, playDAO.getPlays());
			IPlaceDAO placeDAO = PlaceFactory.getClassFromFactory(PLACE_DAO);
			request.setAttribute(KEY_USER_PLACES, placeDAO.getBusyPlaces(user.getLogin()));
			forward(PAGE_MY_PROFILE, request, response);

		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute(KEY_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}
}