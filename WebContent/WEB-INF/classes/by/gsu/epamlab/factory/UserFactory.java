package by.gsu.epamlab.factory;

import java.util.HashMap;
import java.util.Map;

import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.implementation.MySqlUserImpl;
import by.gsu.epamlab.model.implementation.HardcodedUserImpl;

public class UserFactory {
	protected static Map<String, IUserDAO> map = new HashMap<>();
	static {
		map.put(HardcodedUserImpl.class.getName(), new HardcodedUserImpl());
		map.put(MySqlUserImpl.class.getName(), new MySqlUserImpl());
	}

	public static IUserDAO getClassFromFactory(String className) {
		return map.get(className);
	}
}
