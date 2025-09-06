package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String heardFrom = req.getParameter("heardFrom");
		String wantsUpdates = req.getParameter("wantsUpdates");
		String contactVia = req.getParameter("contactVia");

		if (heardFrom == null) {
			heardFrom = "NA";
		}
		if (wantsUpdates == null) {
			wantsUpdates = "No";
		} else {
			wantsUpdates = "Yes";
		}

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setHeardFrom(heardFrom);
		user.setWantsUpdates(wantsUpdates);
		user.setContactVia(contactVia);

		req.setAttribute("user", user);

		String url = "/survey.jsp";

		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
