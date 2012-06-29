/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.User;
import bean.UserDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class ServletCambiaPwd extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        String url = "";

        UserDatos datos = acceso.Login.getUserData(user);

        String type = datos.getType();
        String status = datos.getStatus();
        int hits = datos.getHits();

            if (type.equals("administrador")) {
                url = "/administrador.jsp";
            }
            if (type.equals("vendedor")) {
                url = "/vendedor.jsp";
            }
            if (type.equals("gerenteDeVentas")) {
                url = "/gerenteDeVentas.jsp";
            }
            if (type.equals("gerenteDeInventario")) {
                url = "/gerenteDeInventario.jsp";
            }
            if (hits == 0) {
                hits = hits + 1;
                acceso.Login.aumentaHits(user, hits);
                acceso.Login.cambiaPassword(user, password);
            }
   
        request.setAttribute("user", user);
        request.setAttribute("type", type);

        ServletContext sc = this.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
