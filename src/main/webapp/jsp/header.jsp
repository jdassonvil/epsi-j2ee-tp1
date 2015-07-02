<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="epsi.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="/musicstore/static/js/jquery.js" type="text/javascript"></script>
	<script src="/musicstore/static/js/bootstrap.js" type="text/javascript"></script>
	<link href="/musicstore/static/css/bootstrap.css" rel="stylesheet"/>
	<link href="/musicstore/static/css/style.css" rel="stylesheet"/>
	
	<title>11 heures</title>
</head>
<body>
	<div class="container">
	
		<div class="header" style="height: 100px">
			<div class="pull-left">
				<h1>11h</h1>
				<h5>le site de la musique d'arrière garde...</h5>
				<h6>Vous êtes dans le passé depuis
				<%
					long now =  new Date().getTime();
					long elapsed = (now - request.getSession().getCreationTime()) / 1000 ;
					long seconds = elapsed % 60;
					long minutes = elapsed / 60;
					
					if(minutes == 0){
						%> <%= seconds%> secondes<% 
					}
					else if(minutes == 1){
						%> <%= minutes%> minute<% 
					}
					else{
						%> <%= minutes%> minutes<% 
					}
				%>
				</h6>
			</div>
			<div class="pull-right" style="margin-top:20px">
			
			<%
				if(request.getSession().getAttribute("user") == null){												
			%>
			
				<form class="form-inline" action="/musicstore/app/login" method="post">
					
					<div class="form-group">
					  <label class="sr-only" for="exampleInputEmail3">Email address</label>
					  <input name="email" type="email" class="form-control" id="exampleInputEmail3" placeholder="Enter email">
					</div>
					
					<div class="form-group">
					  <label class="sr-only" for="exampleInputPassword3">Password</label>
					  <input name="password" type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
					</div>
					
					 <div class="checkbox">
					   <label>
					     <input type="checkbox"> Remember me
					   </label>
					 </div>
		  			
		  			 <button type="submit" class="btn btn-default">Sign in</button>
				
				</form>
			<%
					if(request.getAttribute("authenticationError") != null){
						%> <p style="color:red;"> Nom d'utilisateur ou mot de passe incorrect </p> <%
					}
				}
				else{
					User user  = (User) request.getSession().getAttribute("user");
			%>
				<p> Connecté en tant que <%=user.getFirstName() + " " + user.getLastName()%>
				<a href="/app/logout">(se déconnecter)</a></p>
			<%
				}
			%> 
			</div>
		</div>
		
		<hr />