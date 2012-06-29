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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
public class ServletLogin extends HttpServlet {

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
//Obtiene los parametros ingresados por el usuario, username y password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//Crea un objeto User con el username y password ingresado
        User user = new User(username, password);
//Declaracion de variables, url indicara a donde sera dirigida y el mensaje que se desplegara
        String url = "";
        String mensaje = "";
//bandera recibe autorizacion de acceso al usuario
        boolean bandera = acceso.Login.permite(user);
//crea un objeto UserDatos con los datos de la tabla user
        UserDatos datos = acceso.Login.getUserData(user);
//Obtienen los valores del objeto datos
        String type = datos.getType();
        String status = datos.getStatus();
        int hits = datos.getHits();
        int attempts = datos.getAttempts();
        int idUser = datos.getId();

//Si el username y password son correctos y el estatus del user es disponible, se define el url al que sera dirigido dependiendo del tipo de usuario
        if (bandera == true && status.equals("disponible")) {
            if (type.equals("administrador")) {
                url = "/administrador.jsp";
            } else if (type.equals("vendedor")) {
                url = "/vendedor.jsp";
            } else if (type.equals("gerenteDeVentas")) {
                url = "/gerenteDeVentas.jsp";
            } else if (type.equals("gerenteDeInventario")) {
                url = "/gerenteDeInventario.jsp";
            }
            if (hits == 0) {            //Si es la primera vez que ingresa el usuario, se redirige a cambiar el password
                url = "/cambiaPassword.jsp";
            }
            if (hits != 0) {            //Si hits es diferente de 0, se registra en la BD una entrada mas al sistema del usuario
                hits = hits + 1;
                acceso.Login.aumentaHits(user, hits);
            }
        }
//Si el username y password no son validos o el estatus es bloqueado, se le niega el acceso y se define un mensaje dependiendo de el numero de veces que el usuario a 
//ingresado un password incorrecto
        if (bandera == false || status.equals("bloqueado")) {
            attempts = attempts + 1;
            acceso.Login.cambiaAttempts(user, attempts);
            url = "/index.jsp";
            mensaje="Username o password incorrecto";

            if (attempts == 2) {
                mensaje = "Has ingresado un password incorrecto 2 veces, si vuelves a equivocarte tu cuenta será bloqueada";
            }
            if (attempts == 3) {
                mensaje = "Tu cuenta ha sido bloqueda por que has ingresado un password incorrecto 3 veces";
                acceso.Login.bloqueado(user);
            }
            if (attempts > 3) {
                mensaje = "Tu cuenta esta bloqueada, comunícate con el administrador";
            }
        }
  //Se crea una sesion, y se le guardan los siguientes atributos      
        HttpSession session = request.getSession();
        
        session.setAttribute("user", user);
        session.setAttribute("type", type);
        session.setAttribute("id", idUser);
        session.setAttribute("mensaje", mensaje);
//Se manda el request y response al url especificado
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
