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
        <title>Winkelmandje</title>
        <link rel="stylesheet" type="text/css" href="css.css">        

        <script>
            function writeStart()
            {
                var lijst = document.getElementsByName("plaatsen");            
                var text = "";
                for(i=0;i<lijst.length;i++)
                {
                    text +=  `<input type="hidden" name="besteld" value="`+ lijst[i].value+`">`; 
                }
                document.getElementById("hidden").innerHTML = text;                
            }
        </script>
        <script>
            function testEmpty()
            {
                var lijst = document.getElementsByName("besteld"); 
               if(lijst.length === 0)
               {
                   alert("Uw mandje is leeg :(");
               }
               document.getElementById("sub");
            }
        </script>
        <script>
            function remPlaats (id)
            {
                var lijst = document.getElementsByName("besteld");
                var text = "";
                for(i=0;i<lijst.length;i++)
                {
                   if(lijst[i].value !== id)
                   {
                        text +=  `<input type="hidden" name="besteld" value="`+ lijst[i].value+`">`; 
                    }
                }
                document.getElementById("hidden").innerHTML = text;        
                document.getElementById('P'+id).innerHTML ="";
                testEmpty();
            }
        </script>
        
    </head>
    <body onload="writeStart()">      
        <h1 >Winkelmandje</h1>
        <div class="overdiv">
        <form action="<c:url value='MyServlet.do'/>" method="post"> 
            <table class="overtab">
                <tr>
                    <th>Voorstelling</th>
                    <th>Plaatsnummer</th>
                    <th>Prijs</th>
                </tr>
                
             <c:forEach var="plaats" items="${plaatsen}" >
                 <tr id="P${plaats}">
                    <td>Voorstelling 1</td>    
                    <td>${plaats}  </td>
                    <input type="hidden"  name="plaatsen" value="${plaats}">
                    <td>15 Euro </td>
                    <td><label class="trash"  onclick="remPlaats('${plaats}')"  onmousedown="return false"></label>
                </tr>
            </c:forEach>
            </table>
            <div id="hidden"></div>
            <input class="bestel" id="sub" type="submit" value="Bestel">
            <input type="hidden" name="naar" value="overzicht">
          </form>
          </div>
    </body>
    
    <%@ include file="footer.jsp" %>            
</html>