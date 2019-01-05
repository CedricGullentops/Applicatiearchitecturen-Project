<%-- 
    Document   : Index
    Created on : 26-sep-2018, 14:45:32
    Author     : student
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
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
                <%
                    ServletContext sc = request.getServletContext();
                    List <Date> data = (List)sc.getAttribute("Showdates");
                    boolean[] full = (boolean[])sc.getAttribute("Fullshows");
                    int n = 0;
                    if(data.isEmpty())
                    {
                        out.print("leeg");
                    }
                %>
                 <c:forEach var="show" items="${Shownames}" >
                     <% 
                         Date d = data.get(n); 
                         int dag = d.getDate();
                         int maand = d.getMonth()+1;
                         int jaar = d.getYear()-100;
                         
                     %>
                     <tr>  
                         <td   <%if(!full[n]){out.print("class=\"showtabel\" onclick=");}else{out.print("class=\"showtabelfull\"");}%> "location.href='Servlet.do?naar=voorstelling&voorstelling=${show}'" >
                          <h3> <%if(full[n]){ out.print("(VOLZET)");}%> ${show}  <% out.print("("+dag+"/"+maand+"/"+jaar+")"); %></h3> 
                      </td>
                      </tr>   
                      <%n++;%>
                </c:forEach>                   
          </table>
        <br><br><br><br>
        
    </body>
    <%@ include file="footer.jsp" %>            
</html>