package by.gsu.epamlab.ifaces;

import java.sql.Date;
import java.util.List;

import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.DaoException;

public interface IPlayDAO {

	List<Play> getPlays() throws DaoException;

	Play getPlay(Date date) throws DaoException;

	void addPlay(Play playToSet) throws DaoException;

	void deletePlay(Date date) throws DaoException;
}