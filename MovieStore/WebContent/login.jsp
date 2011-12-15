<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,uc3m.webTech.movieStore.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Login</title>
</head>
<body>

	<div id="login">
		<%@include file="header" %>
		<section id="content">
			<h3>Login Page</h3>
			<FORM name="userLoginForm" action="login" method="post">
				<P>
					<LABEL for="username">User Name: </LABEL> <INPUT type="text" name="username"><BR>
					<LABEL for="password">Password: </LABEL> <INPUT type="password" name="password"><BR>
					<label></label>
					<INPUT type="submit" value="User Login" onclick="return validate()"> 
					<INPUT type="reset">
				</P>
			</FORM>
		</section>
		<%@include file='footer' %>				
	</div>

</body>
</html>