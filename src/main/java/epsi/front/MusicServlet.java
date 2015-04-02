package epsi.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epsi.dao.ArtistDao;
import epsi.model.Artist;

public class MusicServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Received a GET Hello Servlet");
		
		resp.setHeader("Content-Type", "text/html");
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		
		resp.getWriter().write("<h1>Artistes de la base </h1>");
		resp.getWriter().write("<ul>");
		ArtistDao artistDao = new ArtistDao();
		
		for(Artist artist: artistDao.find()){
			resp.getWriter().write("<li>" + artist.getName()  + "</li>");
		}
		resp.getWriter().write("</ul>");

		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");

	}
	
}
