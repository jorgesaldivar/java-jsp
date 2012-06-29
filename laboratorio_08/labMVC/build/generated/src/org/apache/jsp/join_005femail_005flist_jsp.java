package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import business.User;

public final class join_005femail_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/header.html", out, false);
      out.write("\n");
      out.write("  <h1>Join our email list</h1>\n");
      out.write("  <p>To join our email list, enter your name and\n");
      out.write("     email address below. <br>\n");
      out.write("     Then, click on the Submit button.</p>\n");
      out.write("\n");
      out.write("  ");

  
    ServletContext sc = getServletContext();
    String message  = (String) sc.getAttribute("message");
    String firstName     = request.getParameter("firstName");
    String emailAddress    = request.getParameter("emailAddress");
    String lastName     = request.getParameter("lastName");
    String career       = request.getParameter("carrera");
    
    
       
     
    if(message != null){
         out.println("<span style='color:red'>" + message + "</span><br /><br />");
    }
           
    if(firstName == null){ 
        firstName = "";
        }
    
    if(lastName == null){     
        lastName = "";
        }
    
    if(emailAddress == null){
        emailAddress = "";
        }
 
  
    
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("  <form action=\"addEmail\" method=\"post\">\n");
      out.write("  <table cellspacing=\"5\" border=\"0\">\n");
      out.write("    <tr>\n");
      out.write("      <td align=\"right\">First name:</td>\n");
      out.write("      <td><input type=\"text\" name=\"firstName\" value=\"");
      out.print(firstName);
      out.write("\"></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td align=\"right\">Last name:</td>\n");
      out.write("      <td><input type=\"text\" name=\"lastName\" value=\"");
      out.print(lastName);
      out.write("\"></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td align=\"right\">Email address:</td>\n");
      out.write("      <td><input type=\"text\" name=\"emailAddress\" value=\"");
      out.print(emailAddress);
      out.write("\"></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("      <td style=\"text-align: right;\">Carrera</td><td>\n");
      out.write("          <select id=\"carrera\" name=\"carrera\" value=\"ISD\">\n");
      out.write("           \n");
      out.write("              <option>INT</option>\n");
      out.write("            <option>ISC</option>\n");
      out.write("            <option>ISD</option>\n");
      out.write("            <option>ITC</option>\n");
      out.write("            <option>ITE</option>\n");
      out.write("            <option>ITIC</option>\n");
      out.write("            <option>ITM</option>\n");
      out.write("            <option>ITS</option>\n");
      out.write("            <option>LATI</option>\n");
      out.write("</select>\n");
      out.write("\n");
      out.write("         \n");
      out.write("    <script>\n");
      out.write("    var carrera=\"");
      out.print(request.getParameter("carrera"));
      out.write("\";\n");
      out.write("    options=document.getElementsByTagName(\"option\");\n");
      out.write("    for (i=0;i<options.length;i++){\n");
      out.write("        if (options[i].innerHTML==carrera){\n");
      out.write("        document.getElementById(\"carrera\").selectedIndex=i;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    \n");
      out.write("      </td>\n");
      out.write("    </tr>\n");
      out.write("      <tr>\n");
      out.write("          <td></td> <td>\n");
      out.write("      <input type=\"submit\" value=\"Submit\"></td>\n");
      out.write("    </tr>\n");
      out.write("  </table>\n");
      out.write("  </form>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/footer.html", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
