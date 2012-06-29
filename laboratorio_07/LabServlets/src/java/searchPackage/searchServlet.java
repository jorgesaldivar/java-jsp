package searchPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import business.User;
import data.UserIO;
import java.util.ArrayList;

/**
 * @author Joel Murach
 */
public class searchServlet extends HttpServlet
{    
    /**
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        // get parameters from the request
       String language = request.getParameter("languages");
      ///////////////////////////////////
               
   
    

        //////////////////////////
    
        // get a relative file name
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/Candidatos.txt");
        
        //System.out.println("jalo");
        // use regular Java objects to write the data to a file
        //User user = new User(name,languages);
        //  System.out.println("jalo2");
        String users = "";
       users = UserIO.search(language, path);
      // System.out.println(users);
        //  System.out.println("jal3o");
        /////////////////////s/////////////
        
        sc.setAttribute("users", users);
        sc.getRequestDispatcher("/resultados.jsp").forward(request, response);
       
       // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registro.jsp");
       // dispatcher.forward(request, response);
        
        
        
        ///////////////////////////////
        /*
        
        // send response to browser
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        out.println(
          "<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"
        + "<html>\n"
        + "<head>\n"
        + "  <title>Murach's Java Servlets and JSP</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "<h1>Thanks for joining our email list</h1>\n"
        + "<p>Here is the information that you entered:</p>\n"
        + "  <table cellspacing=\"5\" cellpadding=\"5\" border=\"1\">\n"
        + "  <tr><td align=\"right\">First name:</td>\n"
        + "      <td>" + name + "</td>\n"
        + "  </tr>\n"
        + "  <tr><td align=\"right\">Last name:</td>\n"
        + "      <td>" + "" + "</td>\n"
        + "  </tr>\n"
        + "  <tr><td align=\"right\">Email address:</td>\n"
        + "      <td>" + "" + "</td>\n"
        + "  </tr>\n"
        + "  </table>\n"
        + "<p>To enter another email address, click on the Back <br>\n"
        + "button in your browser or the Return button shown <br>\n"
        + "below.</p>\n"
        + "<form action=\"join_email_list.html\" "
        + "      method=\"post\">\n"
        + "  <input type=\"submit\" value=\"Return\">\n"
        + "</form>\n"
        + "</body>\n"
        + "</html>\n");
        
        out.close();
        */
    }    
    
    protected void doGet(
        HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        doPost(request, response);
    }
    
}