<%-- 
    Document   : Index
    Created on : 26-sep-2018, 14:45:32
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<%@ include file="header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h3>Geef hieronder uw Klantnummer</h3>
        <p>Of <a href="klant.jsp">registreer hier</a>.</p>  
        <form action="<c:url value='MyServlet.do'/>" method="post">
        <input type="hidden" name="van" value="index">
        Klantnr: <input type="text" name="nr"><input type="submit" value="Verder">
        
        </form>
    </body>
</html>
<%@ include file="footer.jsp" %>