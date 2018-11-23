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
        <title>Plaatsen</title>
        <link rel="stylesheet" type="text/css" href="css.css">
    </head>
    <body>      
        <h1 >Voorstelling</h1>
        <div  class="plaatsdiv" unselectable="on"onselectstart="return false;" onmousedown="return false;">
            <form action="<c:url value='MyServlet.do'/>" method="post">
            <table>
                <tr style="left:0"> 
                    <th></th>
                    <%int n=1;%>
                    <% for(int j = 1; j <=15 ; j+=1) { %>
                        <th><% out.println(j); %></th>
                    <% } %>
                </tr>
                <% for(int i = 10; i >0 ; i-=1) { %>
                    <tr> 
                        <th><% out.println(i); %></th>
                        <% for(int j = 1; j <=15 ; j+=1) { %>
                        <td>
                            <label class="container">
                                <input type="checkbox" name=plaatsid  value=<% out.println(n); %>>
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <%n++; } %>
                     </tr>
                <% } %>
          </table>
          </form>
          </div>
    </body>
    <%@ include file="footer.jsp" %>            
</html>