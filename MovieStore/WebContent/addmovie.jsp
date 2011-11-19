<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.Movie"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Movie List from DB</title>
    </head>
 
    <body>
        <form method="POST" action="addmovie">
            Title: <input type="text" name="title" />
            Year: <input type="text" name="year" />
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<Movie> movies = (List<Movie>)request.getAttribute("movies");
            if (movies != null) {
                for (Movie movie : movies) { %>
                    <li> <%= movie %> </li> <%
                }
            } %>
        </ol><hr>
        
     </body>
 </html>