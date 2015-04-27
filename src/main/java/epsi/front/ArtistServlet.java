package epsi.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epsi.dao.ArtistDao;
import epsi.exception.ArtistNotFoundException;
import epsi.model.Artist;

public class ArtistServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init: loading artist servlet");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("GET /artists");
		ArtistDao artistDao = new ArtistDao();
				
		try{
			Long requestedId = Long.valueOf(req.getParameter("id"));		
			Artist artist = artistDao.findById(requestedId);
			req.setAttribute("artist", artist);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/artist.jsp");
			dispatcher.forward(req, resp);
		}
		catch(NumberFormatException nfe){
			System.err.println(nfe);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/static/404.html");
			dispatcher.forward(req, resp);
		}catch(ArtistNotFoundException anfe){
			System.err.println(anfe);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/static/404.html");
			dispatcher.forward(req, resp);
		}
	}
	
}
