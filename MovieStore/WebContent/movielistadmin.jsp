<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.Movie"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="ValidateMovie.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Movie Store - Admin</title>
</head>
<body>
	<div id="admin">
		<%@ include file="header"%>
		<section id="content">
			<h3>Add Movie:</h3>
			<FORM name="addMovieForm" action="movielistadmin" method="post">
				<P>
					<LABEL for="title">Title: </LABEL> <INPUT type="text" name="title"><BR>
					<LABEL for="actors">Actors:</LABEL> <input type="text" name="actors"><BR>
					<LABEL for="synopsis">Synopsis: </LABEL> 
						<textarea rows="3" cols="20" name="synopsis"></textarea><BR> 
					<LABEL for="year">Year:</LABEL> <INPUT type="text" name="year"><BR> 
					<INPUT type="submit" value="Add Movie" onclick="return validate()"> 
					<INPUT type="reset">
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
				<li><%=movie.getTitle() + " ("
							+ Integer.valueOf(movie.getYear()) + ")"%>
					<FORM action="deletemovie" method="post">
						<input type="hidden" name="movieid"
							value=<%=movie.getId().toString()%>> <INPUT type="submit"
							value="Delete">
					</FORM></li>
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