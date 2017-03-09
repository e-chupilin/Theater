package by.gsu.epamlab.model.implementation;

import static by.gsu.epamlab.model.ConstantsModel.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import by.gsu.epamlab.model.beans.Role;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.ifaces.IUserDAO;

public class HardcodedUserImpl implements IUserDAO {
	private Map<User, String> usersMap;

	public HardcodedUserImpl() {
		super();
		usersMap = new HashMap<>();

		// Hardcoded memory not empty
		setUser("e.chupilin", "1234", "Chupilin Yauheni", "+375291305666");
		setUser("ded", "1234", "Ded Baraded", "+37529137777");
		setUser("teatral", "1234", "Vasili Zaycev", "+375291111111");

	}

	public User getUser(String login, Role currentSessionRole) {
		return getUser(login, NO_PASSWORD, currentSessionRole);
	}

	public User getUser(String login, String password) {
		Role role = User.makeUserRole(login, password);
		if (!Role.VIEWER.equals(role)) {
			return new User(role);
		}
		return getUser(login, password, role);
	}

	private User getUser(String login, String password, Role currentSessionRole) {
		Role role = User.makeUserRole(login, password);

		if (!role.equals(Role.VIEWER)) {
			return new User(role);
		}

		User userKey = new User();
		userKey.setLogin(login);

		Iterator<Map.Entry<User, String>> iter = usersMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<User, String> i = iter.next();
			boolean isCurrentRoleAdminCourier = (Role.ADMIN.equals(currentSessionRole)
					|| Role.COURIER.equals(currentSessionRole));
			if (i.getKey().equals(userKey) && (i.getValue().equals(password) || isCurrentRoleAdminCourier)) {
				return i.getKey();
			}
		}
		throw new ValidationException(ERROR_USER_VERIFICATION);
	}

	public synchronized void setUser(String login, String password, String fullName, String phoneNumber) {
		if (isUserPresent(login))
			throw new ValidationException(ERROR_USER_LOGIN_BUSY);

		User user = new User(login, fullName, phoneNumber, Role.VIEWER);
		usersMap.put(user, password);
	}

	public boolean isUserPresent(String login) {
		if (User.isProtectedLogin(login)) {
			return true;
		}

		User user = new User();
		user.setLogin(login);
		return usersMap.containsKey(user);
	}
}