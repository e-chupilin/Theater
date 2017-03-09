package by.gsu.epamlab.controllers.filters;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;
import static by.gsu.epamlab.controllers.ConstantsControllers.KEY_USER;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.utilities.ServletUtilities;

public final class UserLoginFilter implements Filter {

    public UserLoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("----> User Login Filter <----");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute(KEY_USER);

		if (user == null) {
			System.err.println(ERROR_USER_NULL);
			ServletUtilities.redirectMain(request, response, session);
			return;
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
