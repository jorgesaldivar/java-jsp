<%-- 
    Document   : resultados
    Created on : Jun 15, 2012, 5:34:03 PM
    Author     : Saldivar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Jorge Sald&iacute;var - Lab07</title>
    </head>
    <body>
         <h1>Candidatos que hablan <%= request.getParameter("languages") %></h1>
    
          <%  
                ServletContext sc = getServletContext();
                String users = (String) sc.getAttribute("users");
                //System.out.println(users);
                out.println(users);
                %>
   
    </body>
</html>
