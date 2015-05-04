package epsi.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epsi.business.AuthenticationService;
import epsi.dao.UserDao;
import epsi.exception.AuthenticationException;
import epsi.exception.UserNotFoundException;
import epsi.model.User;

public class LogoutServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init: login artist servlet");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("GET /logout");
		
		req.getSession().invalidate();
				
		// TODO user HTTP referer for proper dispatch
		RequestDispatcher dispatcher = req.getRequestDispatcher("/app");
		dispatcher.forward(req, resp);

	}
	
}
