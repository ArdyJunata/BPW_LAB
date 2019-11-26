<%-- 
    Document   : sukses
    Created on : Nov 25, 2019, 3:00:34 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="pegawai" class="PT_PCR.Pegawai"/>
        <%

            pegawai = (PT_PCR.Pegawai) request.getAttribute("dataPegawai");

        %>
        <h1>Penambahan data pegawai : </h1>
        <br/>
        <table>
            <tr>
                <td>NIP</td>
                <td>:</td>
                <td><%=pegawai.getNip()%></td>
            </tr>
            <tr>
                <td>Nama Pegawai</td>
                <td>:</td>
                <td><%=pegawai.getNama_pegawai()%></td>
            </tr>
            <tr>
                <td>Alamat Pegawai</td>
                <td>:</td>
                <td><%=pegawai.getAlamat()%></td>
            </tr>
            <tr>
                <td>Jabatan</td>
                <td>:</td>
                <td><%=pegawai.getJabatan()%></td>
            </tr>
        </table>
        <br/>
        <h3>Berhasil ditabahkan ke database</h3>
        <a href="DaftarPegawai.jsp">Lihat daftar Pegawai</a>
    </body>
</html>
