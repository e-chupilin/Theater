package by.gsu.epamlab.model.beans;

import static by.gsu.epamlab.model.ConstantsModel.*;

public class User {
	private String login;
	private String fullName;
	private String phoneNumber;
	private Role role;

	public User() {
		super();
		this.login = NO_LOGIN;
		this.fullName = NO_FULL_NAME;
		this.phoneNumber = NO_PHONE_NUMBER;
		this.role = Role.VIEWER;
	}

	public User(Role role) {
		super();

		switch (role) {
		case ADMIN:
			this.login = ADMIN_LOGIN;
			this.fullName = ADMIN_FULL_NAME;
			this.phoneNumber = ADMIN_PHONE_NUMBER;
			break;
		case COURIER:
			this.login = COURIER_LOGIN;
			this.fullName = COURIER_FULL_NAME;
			this.phoneNumber = COURIER_PHONE_NUMBER;
			break;
		default:
			this.login = NO_LOGIN;
			this.fullName = NO_FULL_NAME;
			this.phoneNumber = NO_PHONE_NUMBER;
			break;
		}
		this.role = role;

	}

	public User(String login, String fullName, String phoneNumber, Role role) {
		super();
		this.login = login;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public static boolean isProtectedLogin(String login) {
		if (ADMIN_LOGIN.equals(login) || COURIER_LOGIN.equals(login)) {
			return true;
		}
		return false;
	}

	public static Role makeUserRole(String login, String password) {
		Role role;

		if (ADMIN_LOGIN.equals(login) && ADMIN_PASSWORD.equals(password)) {
			role = Role.ADMIN;
		} else {
			if (COURIER_LOGIN.equals(login) && COURIER_PASSWORD.equals(password)) {
				role = Role.COURIER;
			} else {
				role = Role.VIEWER;
			}
		}
		return role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return login + DELIMITER + fullName + DELIMITER + phoneNumber + DELIMITER + role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
