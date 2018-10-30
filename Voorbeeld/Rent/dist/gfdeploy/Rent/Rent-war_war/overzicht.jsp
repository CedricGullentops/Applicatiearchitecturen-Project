<%-- 
    Document   : overzicht
    Created on : 3-okt-2018, 14:55:02
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <p>
            Prijs:
            <%                
                int p = (Integer)request.getAttribute("prijs"); 
                out.print(p + " euro");
                int t = (Integer)request.getAttribute("tprijs");
                int a = (Integer)request.getAttribute("taant"); 
                out.print(a +" laatste reservaties:"+ t + " euro");
            %>
        </p>
        <form action="<c:url value='MyServlet.do'/>" method="post">
          <input type="submit" value="Meer reservaties">                  
          <input type="hidden" name="van" value="overzicht">
        </form>
    </body>
</html>
<%@ include file="footer.jsp" %>