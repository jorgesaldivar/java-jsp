<html>
<body>
<h1>P&aacute;gina secreta</h1>
<%=new java.util.Date()%>
</body>
</html>
<%-- El código que protege el secreto --%>
<%
String autorizado = (String)session.getAttribute("autorizado");
if ( autorizado.equals("no") ) {
%>
<jsp:forward page="login.html"/>
<%
}
%>
