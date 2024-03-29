/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT_PCR;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import PT_PCR.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Lab330-29
 */
public class OlahAddPegawai1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            RequestDispatcher oke = null;
            String nip = request.getParameter("nip");
            String nama = request.getParameter("nama_pegawai");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
