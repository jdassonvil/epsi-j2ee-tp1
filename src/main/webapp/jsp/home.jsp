<%@page import="epsi.dao.ArtistDao" %>
<%@page import="epsi.model.Artist"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>

<ul class="media-list">
<%
	List<Artist> artists = (List<Artist>) request.getAttribute("artists");	
	
	for(Artist artist: artists){
		%>
		<li class="media">
 				<div class="media-left">
   				<a href="./app/artists?id=<%= artist.getId() %>">
     					<img class="media-object thumbnail-home" src="<%= artist.getImageUrl() %>" alt="...">
   				</a>
 				</div>
 				<div class="media-body">
   			<h4 class="media-heading"><%= artist.getName()  %></h4>
   			<%= artist.getBiography() %>
 				</div>
		</li>
	<%}%>
</ul>

<%@include file="footer.jsp" %>