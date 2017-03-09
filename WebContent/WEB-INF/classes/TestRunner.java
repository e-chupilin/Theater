import by.gsu.epamlab.factory.PlayFactory;
import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.utilities.ServletUtilities;

import static by.gsu.epamlab.controllers.ConstantsControllers.*;
import java.sql.Date;
import javax.servlet.ServletException;

public class TestRunner {
	public static void main(String[] args) throws ServletException {
		try {
			ServletUtilities.setApplicationPath(
					"C:/Users/ded/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Theater/");
			IPlayDAO playDAO = PlayFactory.getClassFromFactory(PLAY_DAO);
			playDAO.addPlay(new Play(new Date(1L), "sun", "sun", "sun", "sun"));
			System.out.println("+ play");
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
