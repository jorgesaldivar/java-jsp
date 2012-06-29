package procesos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Statement;
import data.Carrito;
import data.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joab
 */
public class ValidaUsuario extends HttpServlet {

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
      int x=Integer.parseInt(request.getParameter("userId"));
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
        Statement stmt=(Statement) con.createStatement();
        String query="select * from customer where idcustomer="+x;
        ResultSet rs=stmt.executeQuery(query);
        rs.next();
        int id=rs.getInt(1);
        String nombre=rs.getString(2);
        String company=rs.getString(3);
        String address=rs.getString(4);
        String city=rs.getString(5);
        String phone=rs.getString(6);
        Cliente nuevo=new Cliente(id,nombre,company,address,city,phone);
        ArrayList <Carrito> lista=(ArrayList<Carrito>)request.getSession().getAttribute("listaCarrito");
        request.getSession().setAttribute("listaCarrito", lista);
        request.setAttribute("cliente", nuevo);    
        ServletContext sc=this.getServletContext();
            RequestDispatcher dispatcher=sc.getRequestDispatcher("/recibo.jsp");
            dispatcher.forward(request, response);
              
        
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaUsuario at " + x + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
