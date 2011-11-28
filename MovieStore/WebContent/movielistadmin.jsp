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
	<h3>Add Movie:</h3>
	<FORM action="movielistadmin" method="post">
		<P>
			<LABEL for="title">Title: </LABEL> <INPUT type="text" name="title"><BR>
			<LABEL for="synopsis">Synopsis: </LABEL> <INPUT type="text"
				name="synopsis"><BR> <LABEL for="year">Year: </LABEL>
			<INPUT type="text" name="year"><BR> <INPUT type="submit"
				value="Add Movie"> <INPUT type="reset">
		</P>
	</FORM>

	<h3>Movie List:</h3>
	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Movie> movies = (List<Movie>) request.getAttribute("movies");
			if (movies != null) {
				for (Movie movie : movies) {
		%>
		<li><%=movie.getTitle() + " (" + Integer.valueOf(movie.getYear()) + ")"%> 
		<FORM action="deletemovie" method="post">
		<input type="hidden" name="movieid" value=<%=movie.getId().toString()%>>
		<INPUT type="submit" value="Delete"></FORM></li>
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