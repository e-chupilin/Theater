package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.CONTROLLER_EDIT_PLAY;
import static by.gsu.epamlab.controllers.ConstantsControllers.KEY_PLAYS_ERROR_MESSAGE;
import static by.gsu.epamlab.controllers.ConstantsControllers.PAGE_MAIN;
import static by.gsu.epamlab.controllers.ConstantsControllers.PLAY_DAO;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.factory.PlayFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;

public class AddPlayController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	public AddPlayController() {
	}

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Add play controller ...");

		try {

			Play playToSet = new Play(new Date(1L), "test", "test", "test", "test");
			System.out.println(playToSet);

			IPlayDAO playDAO = PlayFactory.getClassFromFactory(PLAY_DAO);
			playDAO.addPlay(playToSet);
			redirect(CONTROLLER_EDIT_PLAY, response);
		} catch (DaoException | ValidationException e) {
			System.err.println(e.getMessage());
			request.setAttribute(KEY_PLAYS_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}

	}

}
