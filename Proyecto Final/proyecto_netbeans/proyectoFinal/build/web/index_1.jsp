<%-- 
    Document   : index
    Created on : 27-jun-2012, 0:11:53
    Author     : joab
--%>

<%@page import="rmi.cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String a=cliente.metodo(0);%>
        <%=a%>
        <h1>Hello World!</h1>
    </body>
</html>
