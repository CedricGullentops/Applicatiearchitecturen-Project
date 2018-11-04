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
    <body>
        <h3>Welkom op onze nieuwe webpagina</h3>
        <table class="hometab">
            <tr>
                <td class="hometabel" onclick="location.href='login.jsp'">
                    <u>Aanmelden</u><br>
                    <img class="im" src="login.png">
                </td>
                <td class="hometabel" onclick="location.href='verkoop.jsp'">
                     <u>Verkoop</u><br>
                     <img class="im" src="tickets.png">
                </td>
                <td class="hometabel" onclick="location.href='registreer.jsp'">
                     <u>Registreren</u><br>
                     <img class="im" src="regis.png">
                </td>
            </tr>
        </table>
        
        </form>
    </body>
</html>
<%@ include file="footer.jsp" %>