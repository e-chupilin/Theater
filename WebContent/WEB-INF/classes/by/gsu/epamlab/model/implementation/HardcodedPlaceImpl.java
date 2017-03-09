package by.gsu.epamlab.model.implementation;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import by.gsu.epamlab.ifaces.IPlaceDAO;
import by.gsu.epamlab.model.beans.Category;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.exceptions.ValidationException;

import static by.gsu.epamlab.model.ConstantsModel.*;

public class HardcodedPlaceImpl implements IPlaceDAO {
	private Set<Place> places;

	public HardcodedPlaceImpl() {
		super();
		places = new TreeSet<>();
	}

	@Override
	public Set<Place> getBusyPlaces(String login) throws DaoException {
		Set<Place> placesByLogin = new TreeSet<>();

		Iterator<Place> iterator = places.iterator();
		while (iterator.hasNext()) {
			Place place = iterator.next();
			if (place.getLogin().equals(login)) {
				placesByLogin.add(place);
			}
		}
		return placesByLogin;
	}

	@Override
	public Set<Place> getBusyPlaces(Date date) throws DaoException {
		Set<Place> placesByDate = new TreeSet<>();

		Iterator<Place> iterator = places.iterator();
		while (iterator.hasNext()) {
			Place place = iterator.next();
			if (place.getDate().equals(date)) {
				placesByDate.add(place);
			}
		}
		return placesByDate;
	}

	@Override
	public void setPlace(Place place) throws DaoException {
		if (!places.add(place)) {
			throw new DaoException(ERROR_PLACE_DUPLICATE);
		}
	}

	@Override
	public Set<Place> getAllPlaces(Date date) throws DaoException {
		try {

			Set<Place> 	placesToViewByDate = new TreeSet<>();

			Iterator<Place> iterator = places.iterator();
			while (iterator.hasNext()) {
				Place place = iterator.next();
				if (place.getDate().equals(date)) {
					placesToViewByDate.add(place);
				}
			}

			for (int i = 1; i <= VIP_PLASES_QUANTITY; i++) {
				placesToViewByDate.add(new Place(date, i, Category.VIP));
			}

			for (int i = 1; i <= PARTERRE_PLACES_QUANTITY; i++) {
				placesToViewByDate.add(new Place(date, i, Category.PARTERRE));
			}

			for (int i = 1; i <= BALCONY_PLACES_QUANTITY; i++) {
				placesToViewByDate.add(new Place(date, i, Category.BALCONY));
			}

			return placesToViewByDate;

		} catch (ValidationException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
}