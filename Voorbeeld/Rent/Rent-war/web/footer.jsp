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
        <p>email:sample@kuleuven.be</p>
        <p>adres: Samplestraat 24 2424 Sample</p>
        <p>tel.: 04.581624XX</p>
        <form action="MyServlet.do" method="post">
            <input type="submit" value="Meld Af" style="background-color:lightskyblue;height:30px;border-radius:8px; ">
        <input type="hidden" name="van" value="logout">
        <br><br>
        </form>   
       </div>
    </body>
</html>
