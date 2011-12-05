<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.Movie"%>
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
			<h3>Movie List:</h3>
			<hr>
			<ol>
				<%
					@SuppressWarnings("unchecked")
					List<Movie> movies = (List<Movie>) request.getAttribute("movies");
					if (movies != null) {
						for (Movie movie : movies) {
				%>
				<li><%=movie.getTitle() + " ("
							+ Integer.valueOf(movie.getYear()) + ")"%></li>
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