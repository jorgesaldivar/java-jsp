<%-- 
    Document   : logout
    Created on : Jun 25, 2012, 4:32:30 PM
    Author     : Saldivar
--%>

<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 
       //User user = (User)session.getAttribute("user");
       session.setAttribute("type","invitado");
       
       response.sendRedirect("index.jsp");
       
       %>
    </body>
</html>
