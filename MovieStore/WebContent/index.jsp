<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Movie Store</title>
</head>
<body>
	<div id="home">
		<%@ include file="header"%>

		<section id="content">
			<p>Welcome to our amazing Movie Store!</p>
			<p>
				Click <a href="movielist"> here</a> to display the movies list.
			</p>
			<p>
				Click <a href="movielistadmin"> here</a> to add movies.
			</p>
		</section>
		<%@ include file='footer'%>
	</div>
</body>
</html>