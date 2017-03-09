package by.gsu.epamlab.model.beans;

import static by.gsu.epamlab.model.ConstantsModel.*;

public class Order {
	private User user;
	private Play play;
	private Place place;

	public Order() {
		super();
	}

	public Order(User user, Play play, Place place) {
		super();
		this.user = user;
		this.play = play;
		this.place = place;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((play == null) ? 0 : play.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (play == null) {
			if (other.play != null)
				return false;
		} else if (!play.equals(other.play))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return play.getDate() + DELIMITER + user.getLogin() + DELIMITER + place.getNumber() + DELIMITER
				+ place.getCategory();
	}
}
