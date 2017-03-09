package by.gsu.epamlab.factory;

import java.util.HashMap;
import java.util.Map;

import by.gsu.epamlab.ifaces.IPlaceDAO;
import by.gsu.epamlab.model.implementation.HardcodedPlaceImpl;

public class PlaceFactory {
	protected static Map<String, IPlaceDAO> map = new HashMap<>();
	static {
		map.put(HardcodedPlaceImpl.class.getName(), new HardcodedPlaceImpl());
	}

	public static IPlaceDAO getClassFromFactory(String className) {
		return map.get(className);
	}
}