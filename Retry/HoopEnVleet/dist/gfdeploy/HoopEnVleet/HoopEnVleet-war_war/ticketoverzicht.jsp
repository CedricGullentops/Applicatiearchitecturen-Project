<%-- 
    Document   : Index
    Created on : 26-sep-2018, 14:45:32
    Author     : student
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ include file="header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticketoverzicht</title>
        <link rel="stylesheet" type="text/css" href="css.css">        
     </head>
    <body onload="writeStart()">      
        <h1 >ticketoverzicht</h1>
        <div class="overdiv">       
            <table class="overtab">
                <tr>
                    <th>Prijs</th>
                </tr>                
             <c:forEach var="c" items="${codes}" >
                 <tr>
                    <td>${c}</td>    
                </tr>
            </c:forEach>
            </table>
          </div>
    </body>
    
    <%@ include file="footer.jsp" %>            
</htm