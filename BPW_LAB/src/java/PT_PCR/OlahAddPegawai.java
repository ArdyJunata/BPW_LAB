package PT_PCR;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import PT_PCR.*;
import javax.servlet.RequestDispatcher;


public class OlahAddPegawai extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
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
            
            if(pegawaiBean.create(pegawai) == true) {
                oke = getServletContext().getRequestDispatcher("/sukses.jsp");
                oke.forward(request, response);
            } else {
                oke = getServletContext().getRequestDispatcher("/gagal.jsp");
                oke.forward(request, response);
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}