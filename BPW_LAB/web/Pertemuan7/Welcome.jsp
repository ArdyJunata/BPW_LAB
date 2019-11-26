<%-- 
    Document   : Welcome
    Created on : Oct 21, 2019, 2:33:55 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String waktu = new java.util.Date(System.currentTimeMillis()).toString(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Now : <%= waktu %> </h3> 
        <h1>Hello World!</h1>
    </body>
</html>
