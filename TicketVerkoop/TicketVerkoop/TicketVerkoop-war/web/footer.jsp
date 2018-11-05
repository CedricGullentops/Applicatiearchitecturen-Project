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
        <div style="border-style:solid;background-color:lightgrey ;text-height:8px;margin-top:20%; text-indent: 20px ">
        <br> 
        <p>ticketterkoop@hoopenvlijt.be</p>
        <p>adres: Samplestraat 24 2424 Sample</p>
        <p>tel.: 03.581624XX</p>
        <form action="Servlet.do" method="post">
            <input type="submit" value="Meld Af"  class="logout">
        <input type="hidden" name="van" value="logout">
        <br><br>
        </form>   
       </div>
    </body>
</html>
