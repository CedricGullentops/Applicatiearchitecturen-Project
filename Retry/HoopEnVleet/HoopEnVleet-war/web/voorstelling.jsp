<%-- 
    Document   : Index
    Created on : 26-sep-2018, 14:45:32
    Author     : student
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
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
            function printOrder() 
            {
                var prijzen = document.getElementsByName("prijs");
                var totprijs =0;
                var text="";
                var aant=0;
                var plaatsen= document.getElementsByName("plaatsid");
                for (var i =0; i < plaatsen.length; i++){
                    if(plaatsen[i].checked){
                        aant++;
                        text += "Plaats nr.: " + plaatsen[i].value + " prijs: " + Number(prijzen[plaatsen[i].value%1000].value) + "<br>";         
                        totprijs += Number(prijzen[plaatsen[i].value%1000].value);
                    }                          
                }                    
                document.getElementById("lijst").innerHTML = text;
                var prijs = "Totaalprijs: " + totprijs + " Euro" ;    
                document.getElementById("tot").innerHTML = prijs;
                if( aant === 0)
                {
                    document.getElementById("sub").disabled = true;
                    document.getElementById("clr").disabled = true;
                }
                else
                 {
                    document.getElementById("sub").disabled = false;
                    document.getElementById("clr").disabled = false;
                }
            }       
        </script>
         <script>
            function unSel() 
            {
                plaatsen = document.getElementsByName("plaatsid");
                for (var i =0; i < plaatsen.length; i++){
                        plaatsen[i].checked   =  false;                   
                 }         
                 printOrder();
            }       
        </script>
        
    </head>
    <body onload="printOrder()">      
        <h1 >${voorstelling}</h1>
        <a href="#plaatsen">Kies mijn plaatsen</a>
        <form action="<c:url value='Servlet.do'/>" method="post">
        <div  id="plaatsen" class="plaatsdiv" unselectable="on" onselectstart="return false" onmousedown="return false">            
            <table>
                <c:forEach var="p" items="${prijzen}" > <input type="hidden" name="prijs" value="${p}"></c:forEach>               
                <tr style="left:0"> 
                    <th></th>
                    <%
                        List P = (List) request.getAttribute("seats");
                        int showid = (Integer) request.getAttribute("voorstellingid");
                    %>
                    <%int n=150,k=P.size()-1;%>
                    <% for(int j = 15; j >=1 ; j-=1) { %>
                        <th><% out.println(j); %></th>
                    <% } %>
                </tr>
                <% for(int i = 10; i >0 ; i-=1) { %>
                    <tr> 
                        <th><% out.println(i); %></th>
                        <% for(int j = 1; j <=15 ; j+=1) { 
                                    if(n==1){break;}
                                    if(n == ((BigDecimal)P.get(k)).intValueExact() - showid*1000 && k >= 0 ){
                        %>
                        <td class="tel">
                            <label class="container">
                                <input id ="check" type="checkbox" name=plaatsid onclick="printOrder()"  value=<% out.println(1000*showid+n); k--;%>>
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <%}
                                else{
                        %>
                        <td class="tel">
                            <label class="container">
                                <span class="occupied"></span>
                            </label>
                        </td>
                        <%}n--; }
                    if(n==1){%>
                        <td class="tel">
                            <label class="container">
                                <span class="occupied"></span>
                            </label>
                        </td><%}%> 
                    </tr>
                <% } %>
          </table>
          
        </div>
           <div  class="overview" >
            <h1>Overzicht</h1>            
            <p id="lijst"></p>
            <h3  id="tot"></h3>
            <img src="clear.png" id="clr" class="clear" type="button" onclick="unSel()">
            <input class="submit" id="sub" type="image" src="order.png" alt="submit">
            <input type="hidden" name="naar" value="overzicht">
          </div>
          </form>
    </body>
    
    <%@ include file="footer.jsp" %>            
</html>