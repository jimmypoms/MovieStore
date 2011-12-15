<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,uc3m.webTech.movieStore.UserDao,uc3m.webTech.movieStore.Movie,uc3m.webTech.movieStore.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Welcome!</title>
</head>
<body>
	<div id="welcome">
		<%@ include file="header"%>

		<section id="content">
			<p>Welcome <%= session.getAttribute( "userName" ) %> </p>
			
			<p> Now you can start buying movies. </p>
		</section>
		<%@ include file='footer'%>
	</div>
</body>
</html>