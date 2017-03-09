package by.gsu.epamlab.model;

public class ConstantsModel {
	public static final String DELIMITER = ";";
	public static final String DOT = ".";
	public static final String COURIER_FULL_NAME = "Balaganov Shura";
	public static final String ADMIN_FULL_NAME = "Bender Ostap";
	public static final String NO_FULL_NAME = "Full name is empty.";
	public static final String COURIER_PHONE_NUMBER = "+37529123232";
	public static final String ADMIN_PHONE_NUMBER = "Admin phone number is empty";
	public static final String NO_PHONE_NUMBER = "Phone number is empty.";
	public static final String NO_LOGIN = "Ligin is empty.";
	public static final String FREE_PLACE = "";
	public static final String NO_PASSWORD = "";

	public static final int QUANTITY_OF_VIP_PLACE = 10;
	public static final int QUANTITY_OF_PORTERRE_PLACE = 25;
	public static final int QUANTITY_OF_BALCONY_PLACE = 15;

	public static final String ADMIN_LOGIN = "admin";
	public static final String COURIER_LOGIN = "courier";
	public static final String ADMIN_PASSWORD = "1234";
	public static final String COURIER_PASSWORD = "1234";

	public static final String ERROR_HARDCODED_DAO = "Data memory access error.";
	public static final String ERROR_USER_VERIFICATION = "Wrong user name or password.";
	public static final String ERROR_USER_LOGIN_BUSY = "Login is busy. Try another.";
	public static final String ERROR_SQL_DAO = "Can not connect to data base. Please try later.";
	public static final String ERROR_SQL_FAIL_CLOSE_RESULT_SET = "Error SQL. Fail close result set.";
	public static final String ERROR_SQL_FAIL_CLOSE_CONNECT = "Error SQL. Fail close connect.";
	public static final String ERROR_SQL_FAIL_CLOSE_STATEMENT = "Error SQL. Fail close statement.";
	public static final String ERROR_XML_PARSE = "Error load Plays data. Please try later.";
	public static final String ERROR_XML_DATE = "Error parse Date. Error in input xml file.";
	public static final String ERROR_NUMBER_OF_SET_PLACE_IS_HIGH = "Number of set plase is high";
	public static final String ERROR_SET_PLACE_CATEGORY = "Error set place category.";
	public static final String ERROR_PLACE_DUPLICATE = "Place add error. Possible is busy.";
	public static final String ERROR_PLACE_NOT_DEFINED = "Place isn't defined.";
	public static final String ERROR_PLAY_NOT_FOUND = "Play to date not found.";
	public static final String ERROR_REMOVE_ORDER = "Error remove order. Place in memory not found.";
	public static final String ERROR_REMOVE_PLAY = "Error remove play. Play not found.";

	public static final int SQL_PS_INSERT_INDEX = 1;
	public static final int SQL_LOGINID_INDEX = 1;
	public static final int SQL_LOGIN_INDEX = 2;
	public static final int SQL_PASSWORD_INDEX = 3;
	public static final int SQL_FULLNAME_INDEX = 4;
	public static final int SQL_PHONENUMBER_INDEX = 5;
	public static final int SQL_PS_LOGIN_INDEX = 1;
	public static final int SQL_PS_PASSWORD_INDEX = 2;
	public static final int SQL_PS_FULLNAME_INDEX = 3;
	public static final int SQL_PS_PHONENUMBER_INDEX = 4;
	public static final String SQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String SQL_DATABASE = "web1";
	public static final String SQL_TABLE_USER = "user";
	public static final String SQL_URL = "jdbc:mysql://localhost:3306/" + SQL_DATABASE;
	public static final String SQL_USER = "jse";
	public static final String SQL_PASSWORD = "jsejse";
	public static final String SQL_PS_SELECT_USER = "SELECT * FROM " + SQL_DATABASE + DOT + SQL_TABLE_USER
			+ " WHERE login = ?";
	public static final String SQL_PS_INSERT_USER = "INSERT INTO " + SQL_DATABASE + DOT + SQL_TABLE_USER
			+ "(`login`, `password`, `fullName`, `phoneNumber`) VALUES (?, ?, ?, ?)";

	public static final int VIP_RATE_PERCENT = 20;
	public static final int PARTERRE_RATE_PERCENT = 0;
	public static final int BALCONY_RATE_PERCENT = -10;
	public static final int HUNDRED_PERCENT = 100;
	public static final int VIP_PLASES_QUANTITY = 8;
	public static final int PARTERRE_ROW_PLACES_QUANTITY = 10;
	public static final int PARTERRE_COLUMN_QUANTITY = 3;
	public static final int PARTERRE_PLACES_QUANTITY = PARTERRE_COLUMN_QUANTITY * PARTERRE_ROW_PLACES_QUANTITY;
	public static final int BALCONY_PLACES_QUANTITY = 15;

	public static final String XML_PATH = "WEB-INF/";
	public static final String XML_FILE_NAME_PLAYS = "plays.xml";
	public static final String XML_DATE_DELIMITER = "-";
	public static final String XML_ENCODING = "utf-8";
	public static final String XML_TAG_PLAYS = "plays";
	public static final String XML_TAG_PLAY = "play";
	public static final String XML_TAG_DATE = "date";
	public static final String XML_TAG_NAME = "name";
	public static final String XML_TAG_DESCRIPTION = "description";
	public static final String XML_TAG_ABOUT = "about";
	public static final String XML_TAG_PICTURE = "picture";
	public static final int XML_YEAR_POSITION = 0;
	public static final int XML_MONTH_POSITION = 1;
	public static final int XML_DAY_POSITION = 2;
	public static final int COMPARE_ZERO = 0;

}
