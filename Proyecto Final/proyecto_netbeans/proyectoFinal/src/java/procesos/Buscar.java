package procesos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import data.Item;
import com.mysql.jdbc.Statement;
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
public class Buscar extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectofinal", "root", "");
            Statement stmt=(Statement) con.createStatement();
            ArrayList <Item> lista=new ArrayList();
            String query="";
            System.out.println(request.getParameter("category"));
            if(request.getParameter("search")!=null){
            query="Select idItem, name, description, price, quantity, idCategory from item where name LIKE '" +request.getParameter("search")+"%'";}
            //System.out.println(query);
            if(request.getParameter("search")==null){
            query="Select idItem, name, description, price, quantity, item.idCategory from item, category where category.idCategory=item.idCategory and category.category='" +request.getParameter("category")+"'";}
            //System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("idItem");
                String name=rs.getString("name");
                String description=rs.getString("description");
                int price=rs.getInt("price");
                int quantity=rs.getInt("quantity");
                int category=rs.getInt("idCategory");
                Item nuevo=new Item(name, description, id, quantity,price, category);
                lista.add(nuevo);
               }
            request.setAttribute("lista", lista);
            ServletContext sc=this.getServletContext();
            RequestDispatcher dispatcher=sc.getRequestDispatcher("/vendedor.jsp");
            dispatcher.forward(request, response);
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Buscar</title>");            
            out.println("</head>");
            out.println("<body>");
            for (int i=0;i<lista.size();i++){
                out.println(lista.get(i).getName());
            }
            out.println("<h1>Servlet Buscar at " + request.getParameter("search") + "</h1>");
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
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
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
