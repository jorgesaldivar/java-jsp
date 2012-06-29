/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import com.mysql.jdbc.Statement;
import data.Carrito;
import data.Cliente;
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
public class Devuelve extends HttpServlet {

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
            
            int idcustomer=Integer.parseInt(request.getParameter("idcustomer"));
            int idsale=Integer.parseInt(request.getParameter("idsale"));
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
        Statement stmt=(Statement) con.createStatement();
        ArrayList <Carrito> listaDevolucion=new ArrayList();
        String query="select * from customer where idcustomer="+idcustomer;
        ResultSet rs=stmt.executeQuery(query);
        rs.next();
        int id=rs.getInt(1);
        String nombre=rs.getString(2);
        String company=rs.getString(3);
        String address=rs.getString(4);
        String city=rs.getString(5);
        String phone=rs.getString(6);
        Cliente nuevo=new Cliente(id,nombre,company,address,city,phone);
       
          Statement stmt2=(Statement) con.createStatement();
          String query2="select iditem, quantity from itemsold where idsale="+idsale;
          ResultSet rs2=stmt2.executeQuery(query2);
           while(rs2.next()){
                int id2=rs2.getInt("iditem");
                
                int cantidad=rs2.getInt("quantity");
                String query3="select idItem, name, description, price, quantity, idcategory from item where idItem="+id2;
            Statement stmt3=(Statement) con.createStatement();    
            ResultSet rs3 =stmt3.executeQuery(query3);
            rs3.next();
            int idItem=rs3.getInt("idItem");
            String name=rs3.getString("name");
            String description=rs3.getString("description");
            int price=rs3.getInt("price");
            int quantity=rs3.getInt("quantity");
            int category=rs3.getInt("idcategory");
            Item nuevo2=new Item(name, description, idItem, quantity, price, category);
            Carrito nuez=new Carrito(nuevo2,cantidad);
            listaDevolucion.add(nuez);
            }
         
        for(int i=0;i<listaDevolucion.size();i++){
            if(request.getParameter("a"+i)!=""){
                int cantidad=Integer.parseInt(request.getParameter("a"+i));
                listaDevolucion.get(i).setCantidad(cantidad*-1);
            System.out.println(listaDevolucion.get(i).getCantidad());
            }
            if(request.getParameter("a"+i)==""){
                 int cantidad=0;
                 listaDevolucion.get(i).setCantidad(cantidad);
                 System.out.println(listaDevolucion.get(i).getCantidad());
            }
        }
        request.setAttribute("cliente", nuevo);  
        request.setAttribute("listaDevolucion",listaDevolucion);
            ServletContext sc=this.getServletContext();
            RequestDispatcher dispatcher=sc.getRequestDispatcher("/recibodevuelve.jsp");
            
            dispatcher.forward(request, response);
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Devuelve</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Devuelve at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(Devuelve.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Devuelve.class.getName()).log(Level.SEVERE, null, ex);
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
