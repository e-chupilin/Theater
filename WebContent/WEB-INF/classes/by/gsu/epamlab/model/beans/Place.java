package by.gsu.epamlab.model.beans;

import static by.gsu.epamlab.model.ConstantsModel.*;

import java.sql.Date;

import by.gsu.epamlab.model.exceptions.ValidationException;

public class Place implements Comparable<Place> {
	private Date date;
	private int number;
	private Category category;
	private String login;
	private boolean isFree = true;

	public Place(Date date, int number, Category category) throws ValidationException {
		super();
		checkPlace(number, category);
		this.date = date;
		this.number = number;
		this.category = category;
		this.login = FREE_PLACE;
	}

	public Place(Date date, int number, Category category, String login) throws ValidationException {
		super();
		checkPlace(number, category);
		this.date = date;
		this.number = number;
		this.category = category;
		this.login = login;
		this.isFree = false;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getNumber() {
		return number;
	}

	public Category getCategory() {
		return category;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
		this.isFree = true;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void makeFree(int namber, Category category) {
		this.login = null;
		this.isFree = true;
	}

	@Override
	public String toString() {
		return number + DELIMITER + category + DELIMITER + login + DELIMITER + isFree + DELIMITER + date.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (!date.equals(other.date))
			return false;
		if (category != other.category)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public int compareTo(Place o) {
		if (! this.date.equals(o.date))
			return (int) (this.date.getTime() - o.date.getTime());
		if (this.category.ordinal() != o.category.ordinal()) {
			return this.category.ordinal() - o.category.ordinal();
		} else {
			return this.number - o.number;
		}
	}
	
	private void checkPlace(int number, Category category) throws ValidationException {
		switch (category) {
		case VIP: if (number > 0 && number <= VIP_PLASES_QUANTITY) break;
		case PARTERRE: if (number > 0 && number <= PARTERRE_PLACES_QUANTITY) break;
		case BALCONY: if (number > 0 && number <= BALCONY_PLACES_QUANTITY) break;
		default: throw new ValidationException(ERROR_PLACE_NOT_DEFINED);
		}		
	}
}