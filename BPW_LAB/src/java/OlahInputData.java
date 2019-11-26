/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lab330-29
 */
public class OlahInputData extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();

        String nama = request.getParameter("name");
        int nim = Integer.parseInt(request.getParameter("nim"));
        String prodi = request.getParameter("prodi");
        String jk = request.getParameter("jk");
        String bahasa[] = request.getParameterValues("bahasa");

        String db1 = request.getParameter("db1");
        String db2 = request.getParameter("db2");
        String db3 = request.getParameter("db3");
        String db4 = request.getParameter("db4");

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OlahInputData</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Data Mahasiswa</h1>");
            out.println("Nama  : " + nama);
            out.println("<br>");
            out.println("Nim  : " + nim);
            out.println("<br>");
            out.println("Prodi : ");
            if (prodi.equals("TI")) {
                out.println("Teknik Informatika");
            } else if (prodi.equals("SI")) {
                out.println("Sistem Informasi");
            } else if (prodi.equals("TK")) {
                out.println("Teknik Komputer");
            }
            out.println("<br>");
            out.println("Jenis Kelamin  : ");
            if (jk.equals("Pria")) {
                out.println("Pria <br/>");
            }
            if (jk.equals("Wanita")) {
                out.println("Wanita <br/>");
            }
            out.println("<br>");

            out.println("Bahasa Pemrograman : ");
            out.println("<ul>");
            for (int i = 0; i < bahasa.length; i++) {
                out.println("<li>");
                out.println("<span>Bahasa ke-" + (i+1) + ": " + bahasa[i] + "</span>");
                out.println("</li>");
            }
            out.println("</ul>");

            out.println("Database : ");
            out.println("<ul>");
            if (db1 != null) {
                out.println("<li>");
                out.println("MySQL");
                out.println("</li>");
            }
            if (db2 != null) {
                out.println("<li>");
                out.println("Oracle");
                out.println("</li>");
            }
            if (db3 != null) {
                out.println("<li>");
                out.println("Mongo DB");
                out.println("</li>");
            }
            if (db4 != null) {
                out.println("<li>");
                out.println("No SQL");
                out.println("</li>");
            }
            out.println("</ul>");
            
            out.println("<form action=OlahInputData method=POST>");
            out.println("Apakah anda yakin untuk menginput data ini ?<br>"
                    + "<input type=radio name=sure value=Yes>Yes<br>"
                    + "<input type=radio name =sure value=No>No<br>"
                    + "<input type=submit name=kirim>");            
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
        PrintWriter out = response.getWriter();
        
        String tanya = request.getParameter("sure");
        
        try {
            if (tanya.equals("Yes"))
                out.println("Terimakasih Sudah Mendaftar.");
            if (tanya.equals("No"))
                out.println("Cek kembali isian data anda");
        } finally {
            out.close();
        }
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
