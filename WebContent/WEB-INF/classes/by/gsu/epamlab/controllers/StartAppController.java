package by.gsu.epamlab.controllers;

import static by.gsu.epamlab.controllers.ConstantsControllers.PATH_DELIMITER;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import by.gsu.epamlab.utilities.ServletUtilities;

public class StartAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    @Override
    public void init() throws ServletException {
    	super.init();
    	ServletUtilities.setApplicationPath(this.getServletContext().getRealPath(PATH_DELIMITER));
    }
}