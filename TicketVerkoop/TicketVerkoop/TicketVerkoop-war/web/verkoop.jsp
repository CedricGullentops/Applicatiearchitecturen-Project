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
        <title>Voorstellingen</title>
        <link rel="stylesheet" type="text/css" href="css.css">
    </head>
    <body>       
        <h1>Kies een voorstelling:</h1>       
             <table class="showtab">
                <tr>                
                  <!-- <c:forEach var="show" items="${shows}" >
                      <td class="showtabel" onclick="location.href='Servlet.do?voorstelling='${show}">
                        <h2> ${show} </h2> 
                      </td>
                </c:forEach> !-->
                <td class="showtabel" onclick="location.href='Servlet.do?naar=voorstelling&voorstelling=show1'"><h2>Show 1</h2></td>
             </tr>         
          </table>
        
    </body>
    <%@ include file="footer.jsp" %>            
</html>