package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.model.beans.Category;
import by.gsu.epamlab.model.beans.Order;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.model.implementation.ApplicationMemoryOrder;
import by.gsu.epamlab.utilities.ServletUtilities;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

public class TicketController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	public TicketController() {
	}

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ticket Order Controller ...");
		try {

			String numberOrderString = request.getParameter(KEY_PLACE_NUMBER);
			String categoryOrderString = request.getParameter(KEY_PLACE_CATEGORY);

			User userOrder = (User) request.getSession().getAttribute(KEY_USER);
			Play playOrder = (Play) request.getSession().getAttribute(KEY_USER_PLAY);

			ServletUtilities.checkInputOnNull(numberOrderString, categoryOrderString, playOrder);

			int numberOrder = Integer.parseInt(numberOrderString);
			Category categoryOrder = Category.valueOf(categoryOrderString);

			Place placeOrder;
			placeOrder = new Place(playOrder.getDate(), numberOrder, categoryOrder, userOrder.getLogin());

			ApplicationMemoryOrder.addOrder(new Order(userOrder, playOrder, placeOrder));
			List<Order> orders = ApplicationMemoryOrder.getOrders();
			this.getServletContext().setAttribute(KEY_ORDER, orders);

			forward(CONTROLLER_PLAY, request, response);

		} catch (ValidationException | NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute(KEY_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}

	}
}