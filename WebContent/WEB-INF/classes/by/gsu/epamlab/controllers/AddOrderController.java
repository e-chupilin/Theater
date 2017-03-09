package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.sql.Date;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.factory.PlaceFactory;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.ifaces.IPlaceDAO;
import by.gsu.epamlab.model.beans.Category;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.model.implementation.ApplicationMemoryOrder;
import by.gsu.epamlab.utilities.ServletUtilities;

public class AddOrderController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	public AddOrderController() {
		super();
	}

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Add Order Controller ...");
		try {
			String setOrderUserLogin = request.getParameter(KEY_SET_ORDER_USER_LOGIN);
			String setOrderDate = request.getParameter(KEY_SET_ORDER_PLAY_DATE);
			String setOrderPlaceNumber = request.getParameter(KEY_SET_ORDER_PLACE_NUMBER);
			String setOrderPlaceCategory = request.getParameter(KEY_SET_ORDER_PLACE_CATEGORY);

			ServletUtilities.checkInputOnNull(setOrderUserLogin, setOrderDate, setOrderPlaceNumber,
					setOrderPlaceCategory);

			IPlaceDAO placeDAO = PlaceFactory.getClassFromFactory(PLACE_DAO);
			Place place = new Place(Date.valueOf(setOrderDate), Integer.parseInt(setOrderPlaceNumber),
					Category.valueOf(setOrderPlaceCategory), setOrderUserLogin);
			
			placeDAO.setPlace(place);

			ApplicationMemoryOrder.deleteOrder(place);
			forward(PAGE_ADD_ORDER, request, response);
			
		} catch (DaoException | ValidationException e) {
			e.printStackTrace();
			request.setAttribute(KEY_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}
}
