package by.gsu.epamlab.ifaces;

import static by.gsu.epamlab.controllers.ConstantsControllers.KEY_ERROR_MESSAGE;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractBaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		performTask(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		performTask(request, response);
	}

	abstract protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	protected void forward(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void redirect(String url, HttpServletResponse response) throws IOException {
		response.sendRedirect(url);
	}

	protected void forwardError(String message, String page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(KEY_ERROR_MESSAGE, message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}
}