package by.gsu.epamlab.utilities;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.model.exceptions.ValidationException;

public class ServletUtilities {
	private static String realApplicationPath = null;

	public static String getApplicationPath() throws ServletException {
		if (realApplicationPath != null) {
			return realApplicationPath;
		} else {
			throw new ServletException(ERROR_REAL_APP_PATH_NOT_SET);
		}
	}

	public static void setApplicationPath(String path) throws ServletException {
		if (realApplicationPath == null) {
			realApplicationPath = path;
		} else {
			throw new ServletException(ERROR_REAL_APP_PATH_SET_ALREADY);
		}
	}

	public static void redirectMain(ServletRequest request, ServletResponse response, HttpSession session)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		session.invalidate();
		httpResponse.sendRedirect(PAGE_INDEX);
	}
	
	public static void checkInputOnNull(Object... objChecks) {
		for (Object objCheck : objChecks) {
			if (objCheck == null) {
				throw new ValidationException(ERROR_SERVISE_NOT_AVAILABLE);
			}
		}
	}
	
	public static boolean checkPhoneNumber(String regPhoneNumber) {
		Pattern p = Pattern.compile(REGEXP_PHONE_NUMBER);
		Matcher m = p.matcher(regPhoneNumber);
		return m.matches();
	}
}