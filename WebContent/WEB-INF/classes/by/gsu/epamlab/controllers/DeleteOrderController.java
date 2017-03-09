package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.model.beans.Category;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.model.implementation.ApplicationMemoryOrder;
import by.gsu.epamlab.utilities.ServletUtilities;

public class DeleteOrderController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Delete Order Controller ...");
		try {

			String deleteOrderDate = request.getParameter(KEY_DELETE_ORDER_DATE);
			String deleteOrderPlaceNumber = request.getParameter(KEY_DELETE_ORDER_PLACE_NUMBER);
			String deleteOrderPlaceCategory = request.getParameter(KEY_DELETE_ORDER_PLACE_CATEGORY);

			ServletUtilities.checkInputOnNull(deleteOrderDate, deleteOrderPlaceNumber, deleteOrderPlaceCategory);

			Place place = new Place(Date.valueOf(deleteOrderDate), Integer.parseInt(deleteOrderPlaceNumber),
					Category.valueOf(deleteOrderPlaceCategory));
			
			System.out.println("Place to delete : " + place);
			
			ApplicationMemoryOrder.deleteOrder(place);

			forward(PAGE_ADD_ORDER, request, response);
		} catch (ValidationException | NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute(KEY_ERROR_MESSAGE, e.getMessage());
			forwardError(e.getMessage(), PAGE_MAIN, request, response);
		}
	}
}
