<%-- 
    Document   : home
    Created on : 04-Nov-2018, 19:03:18
    Author     : Jarrit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <title>Home</title>
    </head>
    <body >
        <h3><i >Welkom op onze nieuwe webpagina</i></h3>
        <table class="hometab">
            <tr>
                <td class="hometabel" onclick="location.href='Servlet.do?naar=login'">
                    <u>Aanmelden</u><br>
                    <img class="im" src="login.png">
                </td>
                <td class="hometabel" onclick="location.href='Servlet.do?naar=verkoop'">
                     <u>Verkoop</u><br>
                     <img class="im" src="tickets.png">
                </td>
                <td class="hometabel" onclick="location.href='Servlet.do?naar=registreer'">
                     <u>Registreren</u><br>
                     <img class="im" src="regis.png">
                </td>
            </tr>
        </table>
        
        
    </body>          
    <%@ include file="footer.jsp" %>            
   
</html>
