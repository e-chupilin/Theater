package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.factory.PlayFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;

public class EditPlayController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;
       
    public EditPlayController() {
        super();        
    }

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Edit Play Controller ...");	
		IPlayDAO playDAO = PlayFactory.getClassFromFactory(PLAY_DAO);
		try {
			request.setAttribute(KEY_PLAYS, playDAO.getPlays());
			forward(PAGE_EDIT_PLAYS, request, response);
		} catch (DaoException | ValidationException e) {
			System.err.println(e.getMessage());
			request.setAttribute(KEY_PLAYS_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}

}
