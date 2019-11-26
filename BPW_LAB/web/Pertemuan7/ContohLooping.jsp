<%-- 
    Document   : ContohLooping
    Created on : Oct 21, 2019, 4:19:14 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String[] angkaStr = {"satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh"}; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contoh Looping</title>
    </head>
    <body>
        <%
            try {
                int angka = Integer.parseInt(request.getParameter("jumlahloop"));
                if ((angka < 1) || (angka > 10)) {
        %>
        <h4>Data yang dikirim harus diantara 1 s/d 10</h4> 
        <h4><a href="ContohLoop.html"></a></h4>
            <%
            } else {
            %>
        <table border="1">
            <tr>
                <td>Angka</td><td>Kalimat</td>
            </tr>
            <% for (int i = 1; i <= angka; i++) {
            %>
            <tr>
                <td><%=i%></td>
                <td><%=angkaStr[i - 1]%></td>
            </tr>
            <% }%>
        </table>
        <% } %>
        <%} catch (NumberFormatException nfe) {%>
        <h4>Ada kesalahan dalam format data yan dikirimkan</h4>
        <h4><a href="ContohLoop.html">Ulangi lagi ?</a></h4>
        <% }%>
    </body>
</html>
