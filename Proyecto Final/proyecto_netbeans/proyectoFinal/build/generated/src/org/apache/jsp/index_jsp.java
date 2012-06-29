package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<script language=\"Javascript\" type=\"text/javascript\">\n");
      out.write("    window.onload = initForm;\n");
      out.write("\n");
      out.write("    function initForm() {\n");
      out.write("        document.forms[0].onsubmit = function() {return validate();}\n");
      out.write("    }\n");
      out.write("    function validate()\n");
      out.write("    {\n");
      out.write("        var allGood = true;\n");
      out.write("    \n");
      out.write("        document.getElementById(\"msj\").innerHTML = \"\";\n");
      out.write("        document.getElementById(\"nameLabel\").style.color=\"\";\n");
      out.write("        document.getElementById(\"passwordLabel\").style.color=\"\";\n");
      out.write("    \n");
      out.write("        if(document.getElementById(\"username\").value == \"\"){\n");
      out.write("            document.getElementById(\"msj\").innerHTML = \"**Campos obligatorios\";\n");
      out.write("            document.getElementById(\"nameLabel\").style.color=\"red\";\n");
      out.write("            allGood = false;\n");
      out.write("        }\n");
      out.write("        if(document.getElementById(\"password\").value == \"\"){\n");
      out.write("            document.getElementById(\"msj\").innerHTML = \"**Campos obligatorios\";\n");
      out.write("            document.getElementById(\"passwordLabel\").style.color=\"red\";\n");
      out.write("            allGood = false;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        return allGood;\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");

    String mensaje = "";
    mensaje = (String) session.getAttribute("mensaje");

      out.write("\n");
      out.write("<form id=\"form\" name=\"form\" method=\"POST\" action=\"ServletLogin\">\n");
      out.write("\n");
      out.write("    <fieldset>\n");
      out.write("        <legend>Iniciar Sesi&oacute;n: </legend>\n");
      out.write("        <ul>\n");
      out.write("\n");
      out.write("            <li><label id=\"nameLabel\">Username: </label><input type=\"text\" name=\"username\" id=\"username\" autofocus/></li>\n");
      out.write("            <li><label id=\"passwordLabel\">Password: </label><input type=\"password\" name=\"password\" id=\"password\"/></li>\t\n");
      out.write("            <li><input type=\"submit\" value=\"Mandar\" /></li>\t\t\t\t\t\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <h2> \n");
      out.write("            ");
if (mensaje != null) {
      out.write("\n");
      out.write("            ");
      out.print( mensaje);
      out.write(" \n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </h2>\n");
      out.write("        <h3><span id=\"msj\" style=\"color:red\"></span></h3>\n");
      out.write("\n");
      out.write("    </fieldset>\n");
      out.write("</form>\n");
      out.write("\n");
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
