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
public class OlahHidden1 extends HttpServlet {

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

        String nama = request.getParameter("nama");
        String hp = request.getParameter("hp");
        String order = request.getParameter("order");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OlahHidden1</title>");
            out.println("</head>");
            out.println("<body style=background:pink>");
            out.println("<h1>Toko Kue Maknyus</h1>");
            out.println("<hr>");
            out.println("<form action=OlahHidden1 method=post>");
            out.println("<input type=hidden name=nama value=\""+nama+"\">");
            out.println("<input type=hidden name=hp value=" + hp + ">");
            out.println("<input type=hidden name=order value=" + order + ">");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>"
                    + "Pilih Topping"
                    + "</td>");
            
            //penentuan jenis topping yang tersedia sesuai dengan orderan
            if (order.equals("CK") || order.equals("DN") || order.equals("KT")) {
                out.println("<td>"
                        + "<input type=radio name=topping value=cklt>Extra Coklat"
                        + "<br>"
                        + "<input type=radio name=topping value=kj>Extra Keju"
                        + "</td>");
            } else if (order.equals("PZ")) {
                out.println("<td>"
                        + "<input type=radio name=topping value=kj>Extra Keju"
                        + "<br>"
                        + "<input type=radio name=topping value=sn>Extra Sosis dan Nugget"
                        + "</td>");
            } else {
                out.println("Tidak ada topping");
            }
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"
                    + "<input type=submit name=pesan value=Pesan>"
                    + "</td>");
            out.println("<td>"
                    + "<input type=reset name=batal value=Batal>"
                    + "</td>");
//            out.println("<td>"
//                    + "<a href=Quiz_1/Pesan.html>Batal"
//                    + "</td>");
            out.println("</tr>");
            out.println("</table>");
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

        String nama = request.getParameter("nama");
        String hp = request.getParameter("hp");
        String topping = request.getParameter("topping");
        String order = request.getParameter("order");

        float hargaTopping = 0;
        int hargaCake = 0;
        
        //penentuan harga dan nama cake
        if (order.equals("CK")) {
            hargaCake = 55000;
            order = "Cake";
        } else if (order.equals("PZ")) {
            hargaCake = 75000;
            order = "Pizza";
        } else if (order.equals("DN")) {
            hargaCake = 35000;
            order = "Donat";
        } else if (order.equals("KT")) {
            hargaCake = 125000;
            order = "Kue Tart";
        }

        
        //penentuan harga dan nama topping
        if (topping.equals("cklt")) {
            hargaTopping = 25000;
            topping = "Extra Coklat";
        } else if (topping.equals("kj")) {
            hargaTopping = 30000;
            topping = "Extra Keju";
        } else if (topping.equals("sn")) {
            hargaTopping = 20000;
            topping = "Extra Sosis dan Nuget";
        }
        
        //menjumlahkan harga total
        int total = (int) hargaTopping + hargaCake;

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OlahHidden1</title>");
            out.println("</head>");
            out.println("<body style=background:pink>");
            out.println("<h1>Toko Kue Maknyus</h1>");
            out.println("<hr>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>"
                    + "Nama Pemesan"
                    + "</td>");
            out.println("<td>"
                    + ":"
                    + "</td>");
            out.println("<td>"
                    + nama
                    + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"
                    + "No HP"
                    + "</td>");
            out.println("<td>"
                    + ":"
                    + "</td>");
            out.println("<td>"
                    + hp
                    + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"
                    + "Kue Pesanan"
                    + "</td>");
            out.println("<td>"
                    + ":"
                    + "</td>");
            out.println("<td>"
                    + order
                    + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"
                    + "Harga"
                    + "</td>");
            out.println("<td>"
                    + ":"
                    + "</td>");
            out.println("<td>"
                    + "Rp. " +hargaCake
                    + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"
                    + "Topping pilihan"
                    + "</td>");
            out.println("<td>"
                    + ":"
                    + "</td>");
            out.println("<td>"
                    + topping
                    + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"
                    + "Harga"
                    + "</td>");
            out.println("<td>"
                    + ":"
                    + "</td>");
            out.println("<td>"
                    + "Rp. " +hargaTopping
                    + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<hr>");
            out.println("Total Pembayaran = Rp. " + total);
            out.println("</body>");
            out.println("</html>");
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
