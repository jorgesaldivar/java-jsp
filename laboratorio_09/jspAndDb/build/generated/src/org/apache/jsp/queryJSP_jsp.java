package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public final class queryJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Accessing data in a database</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table\r\n");
      out.write("{\r\n");
      out.write("font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;\r\n");
      out.write("width:30%;\r\n");
      out.write("border-collapse:collapse;\r\n");
      out.write("} \r\n");
      out.write("td,th \r\n");
      out.write("{\r\n");
      out.write("font-size:1em;\r\n");
      out.write("border:1px solid #98bf21;\r\n");
      out.write("padding:3px 7px 2px 7px;\r\n");
      out.write("}\r\n");
      out.write("th \r\n");
      out.write("{\r\n");
      out.write("font-size:1.1em;\r\n");
      out.write("text-align:left;\r\n");
      out.write("padding-top:5px;\r\n");
      out.write("padding-bottom:4px;\r\n");
      out.write("background-color:#A7C942;\r\n");
      out.write("color:#ffffff;\r\n");
      out.write("}\r\n");
      out.write("tr.alt td \r\n");
      out.write("{\r\n");
      out.write("color:#000000;\r\n");
      out.write("background-color:#EAF2D3;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");


try {
  //Load the JDBC driver
  Class.forName("com.mysql.jdbc.Driver");
  //Create a Connection object
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/thin", "root", "");

  Statement s = con.createStatement();
  String sql = "SELECT name, abbreviation FROM state";
  ResultSet rs = s.executeQuery(sql);

      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>State</th>\r\n");
      out.write("<th>Abbreviation</th>\r\n");
      out.write("</tr>\r\n");

  boolean alt=false;
  while (rs.next()) {
    if (alt)
       out.println("<tr class='alt'>");
    else
       out.println("<tr>");

    out.println("<td>"+rs.getString(1) + "</td><td>"  + rs.getString(2)+"</td>");
    out.println("</tr>");
   alt=!alt;

  }
  rs.close();
  s.close();
  con.close();
}
catch (SQLException e2) {
  // Exception when executing java.sql related commands, print error message to the console
  System.out.println(e2.toString());
}
catch (Exception e3) {
  // other unexpected exception, print error message to the console
  System.out.println(e3.toString());
}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
