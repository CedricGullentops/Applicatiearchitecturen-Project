<%-- 
    Document   : Index
    Created on : 26-sep-2018, 14:45:32
    Author     : student
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ include file="header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservatie</title>
    </head>
    <body>
       
        <h3>Welkom Klant <% 
            int b =(Integer)session.getAttribute("nr"); 
            out.print(b);
        %></h3>
        <h3>Maak uw reservatie:</h3>
        <form action="<c:url value='MyServlet.do'/>" method="post">
        <table>
            <tr>
                <th>Van</th>
                <th>Wagen</th>
                <th>Naar</th>
                <th>Datum</th>
                <th>Duur</th>
                <th></th>
            </tr>
            
            
          <tr>
          <td><select name="vanloc">
              <!--    
              <%
                ArrayList<String> locaties = (ArrayList<String>)application.getAttribute("locaties");
                for(int i = 0;i < locaties.size();i++){
                    String x = locaties.get(i);
                    out.print("'<option value='" + x +"'>" +x+ "</option>");
                }
              %>
              -->
                <c:forEach var="locatie" items="${locaties}" >
                    <option value="${locatie}"> ${locatie} </option> 
                </c:forEach>
          </select></td>
          <td><select name="wagen">
              <!--    
              <%
                ArrayList<String> wagens = (ArrayList<String>)application.getAttribute("wagens");
                for(int i = 0;i < wagens.size();i++){
                    String x = wagens.get(i);
                    out.print("'<option value='" + x +"'>" +x+ "</option>");
                }
              %>
              -->
                <c:forEach var="wagen" items="${wagens}" >
                    <option value="${wagen}"> ${wagen} </option> 
                </c:forEach>
          </select></td>
           <td><select name="naarloc">
              <!--
              <%
                
                for(int i = 0;i < locaties.size();i++){
                    String x = locaties.get(i);
                    out.print("'<option value='" + x +"'>" +x+ "</option>");
                }
              %>
              -->
            <c:forEach var="locatie" items="${locaties}" >
                <option value="${locatie}"> ${locatie} </option> 
            </c:forEach>
          </select></td>
          <td><input type="text" name="datum"></td>
          <td><input type="text" name="duur"></td>
          
          <td><input type="submit" value="Reserveer"></td>
          </tr>         
          </table>
          <input type="hidden" name="van" value="reserveer">
        </form>
    </body>
</html>
<%@ include file="footer.jsp" %>