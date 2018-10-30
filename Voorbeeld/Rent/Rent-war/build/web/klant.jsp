<%-- 
    Document   : Index
    Created on : 26-sep-2018, 14:45:32
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registratie</title>
    </head>
    <body>
        <h3>Vul uw gegevens in</h3>  
        <div style="border-style:solid;border-width:1px;width:400px">
        <form action="<c:url value='MyServlet.do'/>" method="post">
        <p style="margin-left: 15px">
        <input type="hidden" name="van" value="klant">
        Naam: <input style="height:12px" type="text" name="naam"><br>
        Adres: <input style="height:12px" type="text" name="adres"><br>
        Postcode | Gemeente: <input type="text" style="width:50px;height:12px" name="postcode"> | <input style="height:12px" type="text" name="gemeente">
        <br>
        <br>
        <input type="submit" value="Registreer">
        </p>
        </form>
        </div>
        
        
       
    </body>
</html>
<%@ include file="footer.jsp" %>