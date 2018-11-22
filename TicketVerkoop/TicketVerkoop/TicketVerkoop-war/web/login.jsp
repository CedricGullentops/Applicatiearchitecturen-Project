<%-- 
    Document   : login
    Created on : 21-nov-2018, 15:34:55
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Pagina</title>
        <link rel="stylesheet" type="text/css" href="css.css">
    </head>
    <body>
        <div id="login" class="animate form">
		<form  action="mysuperscript.php"> 
			<h1>Log in</h1> 
			<p> 
				<label for="email" class="email">E-mail adress:</label>
				<input id="email" name="email" required="required" type="email"/> 
			</p>
			<p> 
				<label for="password" class="passwd">Passwoord:</label>
				<input id="password" name="password" required="required" type="password"/>
			</p>
			<p> 
			<p class="behoudlogin"> 
				<input type="checkbox" name="blogin" id="loginkeeping" value="loginkeeping" /> 
				<label for="blogin">Houd me ingelogd!</label>
			</p>
			<p class="login button"> 
				<input type="submit" value="Login" /> 
			</p>
			<p class="change_link">
				Nog niet geregistreerd?
				<a href="#register" class="to_register">Registreer hier!</a>
			</p>
		</form>
	</div>
        
      
    </body>
    <%@ include file="footer.jsp" %>            
</html>
