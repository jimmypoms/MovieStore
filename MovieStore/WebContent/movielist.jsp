<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.Movie"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Movie List from DB</title>
</head>

<body>
	<h3>Movie List:</h3>
	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Movie> movies = (List<Movie>) request.getAttribute("movies");
			if (movies != null) {
				for (Movie movie : movies) {
		%>
		<li><%=movie.getTitle() + " (" + Integer.valueOf(movie.getYear()) + ")"%></li>
		<%
			}
			}
		%>
	</ol>
	<hr>

	<iframe src="http://www.objectdb.com/pw.html?jee-eclipse"
		frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
</body>
</html>