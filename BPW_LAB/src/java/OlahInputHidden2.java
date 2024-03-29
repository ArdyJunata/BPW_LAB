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
public class OlahInputHidden2 extends HttpServlet {

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

        String nama = request.getParameter("nama");
        String jurusan = request.getParameter("jurusan");
        String prodi = request.getParameter("pil");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OlahInputHidden2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Output : </h1>");
            out.println("<table>");
            out.println("<tr>"
                    + "<td>Nama</td>"
                    + "<td>:</td>"
                    + "<td>"+nama);
            out.println("</tr>");
            out.println("<tr>"
                    + "<td>Jurusan</td>"
                    + "<td>:</td>"
                    + "<td>"+jurusan);
            out.println("</tr>");
            out.println("<tr>"
                    + "<td>Program Studi</td>"
                    + "<td>:</td>"
                    + "<td>"+kodeProdi(prodi));
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String kodeProdi(String prodi) {
        if(prodi.equals("TI"))
            return "Teknik Informatika";
        if(prodi.equals("TK"))
            return "Teknik Komputer";
        if(prodi.equals("TE"))
            return "Teknik Elektronika";
        if(prodi.equals("SI"))
            return "Sistem Informasi";
        if(prodi.equals("AKT"))
            return "Akuntansi";
        return "";
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
