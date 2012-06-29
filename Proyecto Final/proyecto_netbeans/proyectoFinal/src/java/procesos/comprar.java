package procesos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Statement;
import data.Carrito;
import data.Item;
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
public class comprar extends HttpServlet {

    
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
            ArrayList<Carrito> carrito=new ArrayList();
            if(request.getSession().getAttribute("listaCarrito")!=null ){
                carrito= (ArrayList<Carrito>) request.getSession().getAttribute("listaCarrito");
            }
            int cantidad= Integer.parseInt(request.getParameter("cantidad"));
            int id= Integer.parseInt(request.getParameter("id"));
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
            Statement stmt=(Statement) con.createStatement();
             String query="Select idItem, name, description, price, quantity, idcategory from item where idItem=" +id;
                     Item nuevo=new Item();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                int ids=rs.getInt("idItem");
                String name=rs.getString("name");
                String description=rs.getString("description");
                int price=rs.getInt("price");
                int quantity=rs.getInt("quantity");
                int category=rs.getInt("idcategory");
                nuevo=new Item(name, description, ids, quantity,price, category);
                Carrito carro=new Carrito(nuevo,cantidad);
                carrito.add(carro);
                request.getSession().setAttribute("listaCarrito", carrito);
              }
             ServletContext sc=this.getServletContext();
            RequestDispatcher dispatcher=sc.getRequestDispatcher("/vendedor.jsp");
            dispatcher.forward(request, response);
            
        /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet comprar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet comprar at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(comprar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(comprar.class.getName()).log(Level.SEVERE, null, ex);
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
