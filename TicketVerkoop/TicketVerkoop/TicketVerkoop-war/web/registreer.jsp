<%-- 
    Document   : registreer
    Created on : 21-nov-2018, 14:37:45
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registratie Pagina</title>
    </head>
    <body>
        <div id="register" class="animate form">
			<form  action="mysuperscript.php"> 
			<h1> Registreer </h1> 
			<p> 
				<label for="naam" class="name">Naam en voornaam:</label>
				<input id="naam" name="naam" required="required" type="text" placeholder="Jef Janssens" />
			</p>
			<p> 
				<label for="email" class="email">E-mail adress:</label>
				<input id="email" name="email" required="required" type="email" placeholder="JefJannsens@gmail.com"/> 
			</p>
			<p> 
				<label for="password" class="passwd">Passwoord:</label>
				<input id="password" name="password" required="required" type="password" placeholder="bvb: X8df!90EO"/>
			</p>
			<p> 
                    	<label for="password_confirm" class="passwd">Geef uw passwoord opnieuw op:</label>
				<input id="password_confirm" name="password_confirm" required="required" type="password" placeholder="bvb: X8df!90EO"/>
			</p>
			<p class="register button"> 
				<input type="submit" value="Registreer"/> 
			</p>
		</form>
	</div>
    </body>
</html>
<%@ include file="footer.jsp" %>
