<%@page import="epsi.model.Track"%>
<%@page import="epsi.model.Album"%>
<%@page import="epsi.model.Artist"%>
<%@page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>


<%
Artist artist = (Artist) request.getAttribute("artist");
Collection<Album> albums= artist.getAlbums();

%><h4><%= artist.getName() %></h4>
<ul>
<%

for(Album album : albums){
	%>
	<li><%= album.getTitle() %> 
		<ul>
		<%
			for(Track track : album.getTracks()){
				
				%>
				<li><%= track.getTitle() %> </li>	
				<%
			}
		%>
		</ul>
	</li>
	<div>
		<a class="btn btn-default" href="/app/buyalbum?id=<%= album.getId() %>" role="button">J'achète !</a>
	</div>
	<%
}
%>
</ul>

<%@include file="footer.jsp" %>