<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="ValidateUser.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>User registration</title>
</head>
<body>

	<div id="newuser">
	
		<%@ include file="header"%>
		<section id="content">
			<h3>Add Movie:</h3>
			<FORM name="newUserForm" action="newuser" method="post">
				<P>
					<LABEL for="username">User Name: </LABEL> <INPUT type="text" name="username"><BR>
					<LABEL for="password">Password: </LABEL> <INPUT type="password" name="password"><BR>
					<LABEL for="name">Name:	</LABEL> <INPUT type="text" name="name"><BR>
					<LABEL for="surname">Surname:	</LABEL> <INPUT type="text" name="surname"><BR>
					<LABEL for="age">Age:	</LABEL> <INPUT type="text" name="age"><BR>
					<INPUT type="submit" value="Add User" onclick="return validate()">
					<INPUT type="reset">
				</P>
			</FORM>
		</section>
		<%@ include file='footer'%>
	
	</div>

</body>
</html>