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
			<h3>Movie Details:</h3>
			<hr>
			<%
				Movie movie = (Movie) request.getAttribute("movie");
				if (movie != null) {
					out.print("<h2>" + movie.getTitle() + 
							" (" + Integer.valueOf(movie.getYear()) + ")"
							+ "</h2>");
					out.print("Actors: " + movie.getActors() + "<br><hr>");
					out.print(movie.getSynopsis());
					
				}
				else {
					out.print("<b>Invalid Movie</b>");
				}
			%>
			<hr>
		</section>
		<%@ include file='footer'%>
	</div>
</body>
</html>