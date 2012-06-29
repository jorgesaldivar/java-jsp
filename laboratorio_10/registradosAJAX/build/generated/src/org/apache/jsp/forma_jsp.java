package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import SQL.SQLFunctions;

public final class forma_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=iso-8859-1\" />\n");
      out.write("\n");
      out.write("\t\t<title>Modificación \"en línea\" desde una página web</title>\n");
      out.write("\n");
      out.write("\t\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"tabla.css\"/>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"modificacion.js\"></script>\n");
      out.write("\n");
      out.write("   </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Lista de usuarios</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <table id=\"tabla-usuarios\">\n");
      out.write("            <tr>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Apellido</th>\n");
      out.write("                    <th>Dirección</th>\n");
      out.write("                    <th>Código Postal</th>\n");
      out.write("                    <th>Ciudad</th>\n");
      out.write("                    <th>Hijos</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("           \n");
      out.write("                \n");
      out.write("                ");
      out.print( SQLFunctions.getUsersDB() );
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("                \n");
      out.write("            <input type=\"button\" onclick=\"agregar()\" value=\"Agrega fila\" />\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("  </html>");
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
