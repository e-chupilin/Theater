package by.gsu.epamlab.model.implementation;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import by.gsu.epamlab.model.beans.Order;
import by.gsu.epamlab.model.beans.Place;
import static by.gsu.epamlab.model.ConstantsModel.*;
import by.gsu.epamlab.model.exceptions.ValidationException;

public class ApplicationMemoryOrder {
	private static List<Order> orders;

	public static void addOrder(Order order) {
		if (orders == null) {
			orders = new ArrayList<Order>();
		}
		orders.add(order);
	}

	public static void deleteOrder(Place place) {
		Iterator<Order> iterator = orders.iterator();
		while (iterator.hasNext()) {
			Order order = iterator.next();
			if (order.getPlace().equals(place)) {
				iterator.remove();
				return;
			}
		}
		throw new ValidationException(ERROR_REMOVE_ORDER);
	}

	public static Order getOrder() {
		return null;
	}

	public static List<Order> getOrders() {
		return orders;
	}
}
