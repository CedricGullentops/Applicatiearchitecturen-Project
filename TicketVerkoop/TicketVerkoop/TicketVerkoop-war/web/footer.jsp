<%-- 
    Document   : footer
    Created on : 10-okt-2018, 15:04:04
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>footer</title>
    </head>
    <body>
        <div class="footer "> 
                ticketterkoop@hoopenvlijt.be       
                adres: Samplestraat 24 2424 Sample
                tel.: 03.581624XX
  
            <form action="Servlet.do" method="post">
                <input type="submit" value="Meld Af"  class="logout">
                <input type="hidden" name="van" value="logout">
            </form>   
        
       </div>
    </body>
</html>
