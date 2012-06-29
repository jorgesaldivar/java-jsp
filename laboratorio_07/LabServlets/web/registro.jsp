<%-- 
    Document   : registro
    Created on : Jun 15, 2012, 4:32:05 PM
    Author     : Saldivar
--%>

<%@page import="business.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jorge Sald&iacute;var - Lab07</title>
    </head>
    <body>
        <h1>Registro exitoso!</h1>
        
        <p>Nombre: <%= request.getParameter("name") %></p>
        
        <h2>Idiomas</h2>
        
        <% 
         User languages = (User) application.getAttribute("user");
         
        out.println("<ul>");
        for(int i=0;i<languages.getLanguages().size();i++){
           
              out.println("<li>" + languages.getLanguages().get(i) +"</li>");
           
        }
        out.println("</ul>");
        %>
        
    </body>
</html>
