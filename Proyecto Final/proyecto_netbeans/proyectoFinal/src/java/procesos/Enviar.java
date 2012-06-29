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
public class Enviar extends HttpServlet {

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
            String r=request.getParameter("pato").toString();
            boolean pasa=false;
            if (r.equals("si")){
                 pasa=true;
            }
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
            Statement stmt=(Statement) con.createStatement();
            String queryid="select max(idsale) from sale";
            ResultSet rs=stmt.executeQuery(queryid);
            rs.next();
            int idSales= rs.getInt(1);
            idSales++;
            Date a=new Date();
            java.sql.Date c=new java.sql.Date(a.getTime());
            ArrayList <Carrito> lista= (ArrayList <Carrito>) request.getSession().getAttribute("listaCarrito");
            //falta agregar el id de vendedor
            int vendedor = (Integer) request.getSession().getAttribute("id");
            
            int cliente=Integer.parseInt(request.getParameter("idUser"));
            int total=Integer.parseInt(request.getParameter("total"));
            System.out.println(total);  
            String querysale="insert into sale values("+idSales+",'"+c+"',"+vendedor+","+cliente+","+total+")";
            stmt.executeUpdate(querysale);  
            
            for (int i=0;i<lista.size();i++){
                if (pasa){
            String query="insert into itemsold values (null,"+lista.get(i).getCantidad()+","+lista.get(i).getItem().getIdItem()+","+idSales+")";    
            stmt.executeUpdate(query);
            String query2="select quantity from item where iditem="+lista.get(i).getItem().getIdItem();
            rs=stmt.executeQuery(query2);
            rs.next();
            int cantidad=rs.getInt("quantity");
            int cantidadnueva=cantidad- lista.get(i).getCantidad();
            String query3="update item set quantity="+cantidadnueva+" where iditem="+lista.get(i).getItem().getIdItem();
            stmt.executeUpdate(query3);
                
                }
                else{
                     String query="insert into itemnotsold values (null,"+lista.get(i).getCantidad()+","+lista.get(i).getItem().getIdItem()+","+idSales+")";    
            stmt.executeUpdate(query);
                }
            }
            stmt.close();
            request.getSession().setAttribute("listaCarrito",null);
            System.out.println(idSales);
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
            Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
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
