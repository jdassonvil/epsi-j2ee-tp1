package epsi.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epsi.business.TokenService;
import epsi.dao.ArtistDao;
import epsi.dao.TokenDao;
import epsi.model.User;

public class MusicServlet extends HttpServlet{
	
	private String LOGIN_COOKIE = "loginCookie";
	
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
		
		// Trying to reload context from cookie when the session is new	
		if(req.getSession().isNew()){
			String tokenValue = null;
			
			for(Cookie cookie : req.getCookies()){
				if(LOGIN_COOKIE.equals(cookie.getName())){
					tokenValue = cookie.getValue();
				}
			}
						
			if(tokenValue != null){
				try{
					TokenService tokenService = new TokenService(new TokenDao());
					User user = tokenService.validateToken(tokenValue);
					req.getSession().setAttribute("user", user);
				}catch(Exception e){
					System.out.println("Token " + tokenValue + " is invalid or expired (" + e.getMessage() + ")");
				}
			}
		}
		
		ArtistDao artistDao = new ArtistDao();
		req.setAttribute("artists", artistDao.find());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/home.jsp");
		dispatcher.forward(req, resp);
	}
	
}
