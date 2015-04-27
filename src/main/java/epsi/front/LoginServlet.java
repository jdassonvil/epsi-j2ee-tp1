package epsi.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epsi.dao.UserDao;
import epsi.model.User;

public class LoginServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init: login artist servlet");
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("POST /login");
		
		resp.setHeader("Content-Type", "text/html");
		resp.getWriter().write("Not implemented yet !");
	}
	
}
