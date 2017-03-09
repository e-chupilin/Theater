package by.gsu.epamlab.model.implementation;

import java.sql.Date;
import java.util.Set;

import by.gsu.epamlab.ifaces.IPlaceDAO;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.exceptions.DaoException;

public class XmlPlaceImpl implements IPlaceDAO {

	@Override
	public Set<Place> getBusyPlaces(Date date) throws DaoException {
		return null;
	}

	@Override
	public Set<Place> getAllPlaces(Date date) throws DaoException {
		return null;
	}

	@Override
	public void setPlace(Place place) throws DaoException {

	}

	@Override
	public Set<Place> getBusyPlaces(String login) throws DaoException {
		return null;
	}
	
}
