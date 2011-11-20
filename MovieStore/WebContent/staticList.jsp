<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>   
<%@ page import = "java.util.ArrayList" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Movies List</title>
    </head>
 
    <body>
        <form method="POST" action="movie">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> <%
            List<String> movies = (ArrayList<String>)request.getAttribute("movies");
            if (movies != null) {
                for (String movie : movies) { %>
                    <li> <%= movie %> </li> <%
                }
            } %>
        </ol><hr>
 
        <!-- <iframe src="http://www.objectdb.com/pw.html?jee-eclipse"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe> -->
     </body>
 </html>