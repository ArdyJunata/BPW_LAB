<%-- 
    Document   : AddPegawaiAction
    Created on : Nov 25, 2019, 3:26:17 PM
    Author     : Lab330-29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" PT_PCR.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            RequestDispatcher oke = null;
            String nip = request.getParameter("nip");
            String nama = request.getParameter("nama");
            String alamat = request.getParameter("alamat");
            String jabatan = request.getParameter("jabatan");

            Pegawai pegawai = new Pegawai();
            pegawai.setNip(nip);
            pegawai.setNama_pegawai(nama);
            pegawai.setAlamat(alamat);
            pegawai.setJabatan(jabatan);

            PegawaiHome pegawaiBean = new PegawaiHome();
            request.setAttribute("dataPegawai", pegawai);

            if (pegawaiBean.create(pegawai) == true) {
        %>
        <jsp:forward page="sukses.jsp"/>
        <%
        } else {
        %>
        <jsp:forward page="gagal.jsp"/>
        <% }%>
    </body>
</html>
