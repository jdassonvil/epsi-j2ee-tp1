package epsi.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epsi.dao.ArtistDao;

public class MusicServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init: loading music servlet");
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("GET /");
		
		ArtistDao artistDao = new ArtistDao();
		req.setAttribute("artists", artistDao.find());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/home.jsp");
		dispatcher.forward(req, resp);
	}
	
}
