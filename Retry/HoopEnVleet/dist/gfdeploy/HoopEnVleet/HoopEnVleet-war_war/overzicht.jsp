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
                calcPrijs();
            }
        </script>
        <script>
            function testEmpty()
            {
                var lijst = document.getElementsByName("besteld"); 
               if(lijst.length === 0)
               {
                   alert("Uw mandje is leeg,\nU wordt teruggebracht naar de selectiepagina");
                    window.location = 'Servlet.do?naar=voorstelling&voorstelling=${voorstelling}';
               }
              
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
                calcPrijs();
            }
        </script>
             <script>
            function calcPrijs ()
            {
                var prijzen = document.getElementsByName("prijs");        
                var lijst = document.getElementsByName("besteld");
                var prijs = 0;
                for(i=0;i<lijst.length;i++)
                {
                    prijs += Number(prijzen[lijst[i].value%1000].value);
                }       
                document.getElementById("totprijs").innerHTML = "Subtotaal: " + prijs;
            }
        </script>
        
    </head>
    <body onload="writeStart()">      
        <h1 >Winkelmandje</h1>
        <div class="overdiv">       
            <% 
                ServletContext sc = request.getServletContext();
                List prijzen = (List)sc.getAttribute("prijzen");
                String[] ids = (String[])request.getAttribute("plaatsen");
                out.print(Integer.parseInt(ids[0]));
                int n = 0;
            
            %>
            <form action="<c:url value='Servlet.do'/>" method="post">    
            <c:forEach var="p" items="${prijzen}" > <input type="hidden" name="prijs" value="${p}"></c:forEach>       
            <table class="overtab">
                <tr>
                    <th>Voorstelling</th>
                    <th>Plaatsnummer</th>
                    <th>Prijs</th>
                </tr>                
             <c:forEach var="plaats" items="${plaatsen}" >
                 <tr id="P${plaats}">
                    <td>${voorstelling}</td>    
                    <td>${plaats}  </td>
                    <input type="hidden"  name="plaatsen" value="${plaats}">
                    <td><%out.print(prijzen.get(Integer.parseInt(ids[n])%1000)); n++;%> </td>
                    <td><label class="trash"  onclick="remPlaats('${plaats}')"  onmousedown="return false"></label>
                </tr>
            </c:forEach>
            </table>
            <h3 id="totprijs"></h3>
            <div id="hidden"></div>        
            <input class="bestel"  type="submit" value="Bestel">
            <input type="hidden" name="naar" value="tickets">
          </form>
          </div>
    </body>
    
    <%@ include file="footer.jsp" %>            
</html>