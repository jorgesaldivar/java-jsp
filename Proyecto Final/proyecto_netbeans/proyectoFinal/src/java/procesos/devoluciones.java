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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joab
 */
public class devoluciones extends HttpServlet {

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
            int recibo=Integer.parseInt(request.getParameter("devolver"));
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
            Statement stmt=(Statement) con.createStatement();
            Statement st=(Statement) con.createStatement();
            ArrayList <Item> items=new ArrayList();
            ArrayList <Carrito> listaDevolucion=new ArrayList();
            
            int idcustomer=0;
            String obtenerCustomer="select idcustomer from sale where idsale="+recibo;
            ResultSet rm=st.executeQuery(obtenerCustomer);
            rm.next();
            idcustomer=rm.getInt("idcustomer");
            String queryid="select iditem, quantity from itemsold where idsale="+recibo;
            ResultSet rs=stmt.executeQuery(queryid);
            while(rs.next()){
                int id=rs.getInt("iditem");
                
                int cantidad=rs.getInt("quantity");
                String query2="select idItem, name, description, price, quantity, idcategory from item where idItem="+id;
            Statement stmt2=(Statement) con.createStatement();    
            ResultSet rs2 =stmt2.executeQuery(query2);
            rs2.next();
            int idItem=rs2.getInt("idItem");
            String name=rs2.getString("name");
            String description=rs2.getString("description");
            int price=rs2.getInt("price");
            int quantity=rs2.getInt("quantity");
            int category=rs2.getInt("idcategory");
            Item nuevo=new Item(name, description, idItem, quantity, price, category);
            Carrito nuez=new Carrito(nuevo,cantidad);
            listaDevolucion.add(nuez);
            }
            request.setAttribute("idcustomer",idcustomer);
            request.setAttribute("idsale",recibo);
            request.setAttribute("listaDevolucion",listaDevolucion);
              RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/devoluciones.jsp");
        dispatcher.forward(request, response);
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet devoluciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet devoluciones at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(devoluciones.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(devoluciones.class.getName()).log(Level.SEVERE, null, ex);
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
