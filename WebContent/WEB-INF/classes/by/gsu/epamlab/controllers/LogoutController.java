package by.gsu.epamlab.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.epamlab.ifaces.AbstractBaseController;
import by.gsu.epamlab.utilities.ServletUtilities;

public class LogoutController extends AbstractBaseController {
	private static final long serialVersionUID = 1L;

	public LogoutController() {
		super();
	}

	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LogOUT Controller ...");
		ServletUtilities.redirectMain(request, response, request.getSession());
	}
}