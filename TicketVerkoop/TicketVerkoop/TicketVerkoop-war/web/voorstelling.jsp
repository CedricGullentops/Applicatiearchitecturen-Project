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
        <script>
            function printOrder() {
                var text="";
                var aant=0;
                var aa= document.getElementsByName("plaatsid");
                for (var i =0; i < aa.length; i++){
                    if(aa[i].checked){
                        aant++;
                        text += "Plaats nr. : " + aa[i].value + "<br>"; 
                         
                    }                          
                }                    
                document.getElementById("lijst").innerHTML = text;
                var prijs = "Totaalprijs: " + aant * 15 + " Euro" ;    
                document.getElementById("tot").innerHTML = prijs;
            }       
        </script>
        
    </head>
    <body>      
        <h1 >Voorstelling</h1>
        <a href="#plaatsen">Kies mijn plaatsen</a>
        <form action="<c:url value='Servlet.do'/>" method="post">
        <div  id="plaatsen" class="plaatsdiv" unselectable="on" onselectstart="return false" onmousedown="return false">            
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
                                <input id ="check" type="checkbox" name=plaatsid onclick="printOrder()"  value=<% out.println(n); %>>
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <%n++; } %>
                     </tr>
                <% } %>
          </table>
        </div>
           <div  class="overview" >
            <h1>Overzicht</h1>            
            <p id="lijst"></p>
            <h3  id="tot"></h3>
            <input class="submit" type="image" src="order.png" alt="submit">
            <input type="hidden" name="naar" value="overzicht">
          </div>
          </form>
          <a href="">Naar boven</a>
    </body>
    
    <%@ include file="footer.jsp" %>            
</html>