/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Lab330-29
 */
public class OlahData extends HttpServlet {

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

        String pass = request.getParameter("pwd");
        String conf = request.getParameter("pwdconfirm");
        String passwd = "12345678";

        RequestDispatcher control = null;

        try (PrintWriter out = response.getWriter()) {
            if (pass.length() < 8 || pass.length() > 8) {
                control = getServletContext().getRequestDispatcher("/length");
                control.forward(request, response);
            } else if (pass.equals(conf)) {
                if (pass.equals(passwd)) {
                    control = getServletContext().getRequestDispatcher("/sukses");
                    control.forward(request, response);
                } else {
                    control = getServletContext().getRequestDispatcher("/gagal");
                    control.forward(request, response);
                }
            } else {
                control = getServletContext().getRequestDispatcher("/length");
                control.forward(request, response);
            }
            
//            if (pass.equals(passwd) && (conf.equals(pass))) {
//                control = getServletContext().getRequestDispatcher("/sukses");
//                control.forward(request, response);
//            } else {
//                control = getServletContext().getRequestDispatcher("/gagal");
//                control.forward(request, response);
//            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OlahData</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OlahData at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
