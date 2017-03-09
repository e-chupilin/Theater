package by.gsu.epamlab.ifaces;

import java.sql.Date;
import java.util.Set;

import by.gsu.epamlab.model.beans.Category;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.exceptions.DaoException;

public interface IPlaceDAO {

	Set<Place> getBusyPlaces(Date date) throws DaoException;
	
	Set<Place> getAllPlaces(Date date) throws DaoException;	
	
	Set<Place> getBusyPlaces(String login) throws DaoException;	

	void setPlace(Place place) throws DaoException;

}
