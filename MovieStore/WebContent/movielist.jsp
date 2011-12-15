<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.Movie,uc3m.webTech.movieStore.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Movie Store - Movielist</title>
</head>
<body>
	<div id="movie">
		<%@ include file="header"%>

		<section id="content">
		<% /* 
		User u = (User) request.getAttribute("user");
		if (u != null) out.print(u.getName()); */
		%>
			<h3>Movie List:</h3>
			<hr>
			<ol>
				<%
					@SuppressWarnings("unchecked")
					List<Movie> movies = (List<Movie>) request.getAttribute("movies");
					if (movies != null) {
						for (Movie movie : movies) {
				%>
				<li><a href=<%="movielist?id=" + movie.getId().toString()%>>
					<%=movie.getTitle() + " (" + Integer.valueOf(movie.getYear()) + ")"%>
				</a></li>
				<%
					}
					}
				%>
			</ol>
			<hr>
		</section>
		<%@ include file='footer'%>
	</div>
</body>
</html>