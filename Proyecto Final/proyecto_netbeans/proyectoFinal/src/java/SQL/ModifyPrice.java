/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saldivar
 */
public class ModifyPrice extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        // System.out.println("hola");
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
         
        //String id = request.getParameter("id");
      //  System.out.println(id);
        //ArrayList datos = new ArrayList();
      
        //int id = Integer.parseInt(request.getParameter("id"));
       // String price = request.getParameter("price");
       // String id = request.getParameter("id");
        
       String id = request.getParameter("id");
      String price = request.getParameter("price");
        
        try {
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
                    System.out.println("hola");    
            Statement s = con.createStatement();
            String sql = "UPDATE item SET price=" + price + " WHERE idItem=" + id;
            System.out.println(sql);
            s.executeUpdate(sql);
            
            
            //datos.add("Jorge");
            //datos.add("Saldivar");
        
          // out.println(datos);
            s.close();
            con.close();
        } catch (SQLException ex) {
           // Logger.getLogger(Elimina.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyPrice.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyPrice.class.getName()).log(Level.SEVERE, null, ex);
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
