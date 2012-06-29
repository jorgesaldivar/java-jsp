/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alex
 */
public class Inserta extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        
        //ArrayList datos = new ArrayList();
      
        int id = -1;
        
        try {
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", "");
                        
            Statement s = con.createStatement();
            String sql = "INSERT INTO registrados (nombre,apellido,direccion,codigo,ciudad,hijos,email) VALUES ('Jorge','Saldivar','calle','362','Monterrey','0','a01033317@itesm.mx')";
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = s.getGeneratedKeys();
            
            if (rs.next()){
            id=rs.getInt(1);
            }


            //datos.add("Jorge");
            //datos.add("Saldivar");
        
            out.println(id);
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
            Logger.getLogger(Inserta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Inserta.class.getName()).log(Level.SEVERE, null, ex);
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
