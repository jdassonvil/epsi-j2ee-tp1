<%@page import="epsi.dao.ArtistDao" %>
<%@page import="epsi.model.Artist"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>11 heures</title>
</head>
<body>
	<h1>11h: le site de la musique d'avant garde</h1>
	<p> Liste des artistes </p>
	<ul>
	<%
		List<Artist> artists = (List<Artist>)request.getAttribute("artists");	
		
		for(Artist artist: artists){
			%><li> <%= artist.getName()  %></li><%
		}
	%>
	</ul>
</body>
</html>