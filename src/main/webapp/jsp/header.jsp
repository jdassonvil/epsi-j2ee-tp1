<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="./static/js/jquery.js" type="text/javascript"></script>
	<script src="./static/js/bootstrap.js" type="text/javascript"></script>
	<link href="./static/css/bootstrap.css" rel="stylesheet"/>
	<link href="./static/css/style.css" rel="stylesheet"/>
	
	<title>11 heures</title>
</head>
<body>
	<div class="container">
	
		<div class="header" style="height: 80px">
			<div class="pull-left">
				<h1>11h</h1>
				<h5>le site de la musique d'arrière garde...</h5>
			</div>
			<div class="pull-right" style="margin-top:20px">
				<form class="form-inline" action="/app/login" method="post">
					
					<div class="form-group">
					  <label class="sr-only" for="exampleInputEmail3">Email address</label>
					  <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Enter email">
					</div>
					
					<div class="form-group">
					  <label class="sr-only" for="exampleInputPassword3">Password</label>
					  <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
					</div>
					
					 <div class="checkbox">
					   <label>
					     <input type="checkbox"> Remember me
					   </label>
					 </div>
		  			
		  			 <button type="submit" class="btn btn-default">Sign in</button>
				
				</form>
			</div>
		</div>
		
		<hr />