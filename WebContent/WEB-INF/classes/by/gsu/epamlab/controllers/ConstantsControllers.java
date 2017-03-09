package by.gsu.epamlab.controllers;

import by.gsu.epamlab.model.implementation.HardcodedPlaceImpl;
import by.gsu.epamlab.model.implementation.HardcodedUserImpl;
import by.gsu.epamlab.model.implementation.XmlPlayImpl;

public class ConstantsControllers {

	// Change for use necessary data source for User
	public static final String USER_DAO = HardcodedUserImpl.class.getName();
	// public static final String USER_DAO = MySqlUserImpl.class.getName();

	// Change for use necessary data source for Play
	public static final String PLAY_DAO = XmlPlayImpl.class.getName();
	// public static final String PLAY_DAO = HardcodedPlayImpl.class.getName();

	// Change for use necessary data source for Place
	public static final String PLACE_DAO = HardcodedPlaceImpl.class.getName();
	// public static final String PLACE_DAO = .class.getName();

	public static final String KEY_LOGIN = "keyLogin";
	public static final String KEY_PLAYS = "keyPlays";
	public static final String KEY_PLACE = "keyPlace";
	public static final String KEY_USER_PLACES = "keyUserPlaces";
	public static final String KEY_PASSWORD = "keyPassword";
	public static final String KEY_ERROR_MESSAGE = "keyErrorMessage";
	public static final String KEY_PLAYS_ERROR_MESSAGE = "keyPlaysErrorMessage";
	public static final String KEY_USER_ROLE = "userRole";
	public static final String KEY_USER = "keyUser";
	public static final String KEY_USER_PLAY = "keyUserPlay";
	public static final String KEY_PLAY_ORDER = "keyPlayOrder";
	public static final String KEY_PLAY_DATE = "keyPlayDate";
	public static final String KEY_DELETE_PLAY_DATE = "keyDeletePlayDate";
	public static final String KEY_PLACE_ORDER = "keyPlaceOrder";
	public static final String KEY_PLACE_NUMBER = "keyPlaceNumber";
	public static final String KEY_PLACE_CATEGORY = "keyPlaceCategory";
	public static final String KEY_ORDER = "keyOrder";
	public static final String KEY_SET_ORDER_USER_LOGIN = "keySetOrderUserLogin";
	public static final String KEY_SET_ORDER_PLAY_DATE = "keySetOrderPlayDate";
	public static final String KEY_SET_ORDER_PLACE_NUMBER = "keySetOrderPlaceNumber";
	public static final String KEY_SET_ORDER_PLACE_CATEGORY = "keySetOrderPlaceCategory";
	public static final String KEY_DELETE_ORDER_DATE = "keyDeleteOrderDate";
	public static final String KEY_DELETE_ORDER_PLACE_NUMBER = "keyDeleteOrderPlaceNumber";
	public static final String KEY_DELETE_ORDER_PLACE_CATEGORY = "keyDeleteOrderPlaceCategory";
	

	public static final String KEY_REGISTER_LOGIN = "keyRegisterLogin";
	public static final String KEY_REGISTER_FULL_NAME = "keyRegisterFullName";
	public static final String KEY_REGISTER_PHONE_NUMBER = "keyRegisterPhoneNumber";
	public static final String KEY_REGISTER_PASSWORD = "keyRegisterPassword";
	public static final String KEY_REGISTER_PASSWORD_REPEAT = "keyRegisterPasswordRepeat";
	public static final String KEY_REGISTER_ERROR_MESSAGE = "keyRegisterErrorMessage";

	public static final String JSP_PATH = "/WEB-INF/jsp/";
	public static final String PAGE_LOGIN = JSP_PATH + "login.jsp";
	public static final String PAGE_HEADER = JSP_PATH + "header.jsp";
	public static final String PAGE_FOOTER = JSP_PATH + "footer.jsp";
	public static final String PAGE_REGISTER = JSP_PATH + "register.jsp";
	public static final String PAGE_MAIN = JSP_PATH + "main.jsp";
	public static final String PAGE_VIEW_PLAYS = JSP_PATH + "viewPlays.jsp";
	public static final String PAGE_EDIT_PLAYS = JSP_PATH + "editPlays.jsp";
	public static final String PAGE_INDEX = "index.jsp";
	public static final String PAGE_ERROR = JSP_PATH + "error.jsp";
	public static final String PAGE_MY_PROFILE = JSP_PATH + "myProfile.jsp";
	public static final String PAGE_BOOK_TICKET = JSP_PATH + "bookTicket.jsp";
	public static final String PAGE_ADD_ORDER = JSP_PATH + "addOrder.jsp";
	public static final String CONTROLLER_PLAY = "/play";
	public static final String CONTROLLER_EDIT_PLAY = "editPlay";
	public static final String EMPTY = "";
	public static final String PATH_DELIMITER = "\\";
	public static final String USER = "user";

	public static final String REGEXP_PHONE_NUMBER = "^(\\+?\\d+)$";

	public static final String ERROR_LOGIN_OR_PASSWORD_ABSENT = "Login or password is absent.";
	public static final String ERROR_LOGIN_EMPTY = "Login is empty.";
	public static final String ERROR_FULL_NAME_EMPTY = "Please enter name (Mr.Ivanov example).";
	public static final String ERROR_PHONE_EMPTY = "For order confirmation of the ticket we need your phone number. Please enter him.";
	public static final String ERROR_PHONE_FORMAT = "Phone number may contain only '+' and 'number', please check input.";
	public static final String ERROR_PASSWORD_EMPTY = "Password is empty.";
	public static final String ERROR_PASSWORD_NOT_EQUAL = "Passwords are NOT equal.";
	public static final String ERROR_LOGIN_IS_BUSY = "Login is busy, think of the other.";
	public static final String ERROR_REGISTER_DATA_ABSENT = "Registration data is absent.";
	public static final String ERROR_REAL_APP_PATH_NOT_SET = "Real application path not set. Use setRealApplicationPath(path) void.";
	public static final String ERROR_REAL_APP_PATH_SET_ALREADY = "Real application path already set. Use getRealApplicationPath() void.";
	public static final String ERROR_SERVISE_NOT_AVAILABLE = "Servise not available. Please try later.";
	public static final String ERROR_LOW_RIGHT_FOR_ACCESS = "The right for access is low. Session invalidate. Redirect to index.jsp";
	public static final String ERROR_USER_NULL = "User is null. Session invalidate. Redirect to index.jsp";
}
