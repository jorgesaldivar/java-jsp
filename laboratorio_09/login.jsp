<%
String login = request.getParameter("login");
String password = request.getParameter("password");
if ( login.equals("admin") && password.equals("guess") ) {
        // datos correctos
        session.setAttribute("autorizado", "si");
} else {
        // datos incorrectos
        session.setAttribute("autorizado", "no");
}
%>
<html>
<body>
<h1>Conexi&oacute;n exitosa</h1>
Te identificaste como <%= login+"/"+password %>
<br><br>
<a href="secreto.jsp">Puedes ver la liga secreta</a>
<br/>

<jsp:include page="WEB-INF/include_secreto.html"/>
<h1>Bienvenido</h1>
<p>Para triunfar en la vida, no es importante llegar el primero. Para triunfar simplemente hay que llegar, levant&aacute;ndose cada vez que se cae en el camino.</p>
</body>
</html>
<%-- El codigo que protege el secreto --%>
<%
String autorizado = (String)session.getAttribute("autorizado");
if ( autorizado.equals("no") ) {
%>
<jsp:forward page="login.html"/>
<%
}
%>