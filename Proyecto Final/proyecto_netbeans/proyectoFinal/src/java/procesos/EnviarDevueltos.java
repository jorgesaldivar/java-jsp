/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import com.mysql.jdbc.Statement;
import data.Carrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joab
 */
public class EnviarDevueltos extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
   
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
            Statement stmt=(Statement) con.createStatement();
            
            Date a=new Date();
            java.sql.Date c=new java.sql.Date(a.getTime());
            ArrayList <Carrito> lista= (ArrayList <Carrito>) request.getSession().getAttribute("recibo");
            //falta agregar el id de vendedor
            int cliente=Integer.parseInt(request.getParameter("idUser"));
            int total=Integer.parseInt(request.getParameter("total"));
          
                      
            for (int i=0;i<lista.size();i++){
                
            String query="insert into returneditem values (null,"+lista.get(i).getCantidad()+","+lista.get(i).getItem().getIdItem()+",'"+c+"')";    
            if(lista.get(i).getCantidad()!=0)
            stmt.executeUpdate(query);
            
                
                }
                
            
            stmt.close();
            request.getSession().setAttribute("recibo",null);
            request.getSession().setAttribute("listaCarrito",null);
            response.sendRedirect("vendedor.jsp");
        } finally {            
            out.close();
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EnviarDevueltos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EnviarDevueltos.class.getName()).log(Level.SEVERE, null, ex);
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
