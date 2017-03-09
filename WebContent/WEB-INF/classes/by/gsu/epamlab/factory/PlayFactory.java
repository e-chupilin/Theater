package by.gsu.epamlab.factory;

import java.util.HashMap;
import java.util.Map;

import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.implementation.XmlPlayImpl;

public class PlayFactory {
	protected static Map<String, IPlayDAO> map = new HashMap<>();
	static {
		map.put(XmlPlayImpl.class.getName(), new XmlPlayImpl());
	}

	public static IPlayDAO getClassFromFactory(String className) {
		return map.get(className);
	}
}
