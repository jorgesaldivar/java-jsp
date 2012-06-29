<%-- 
    Document   : index
    Created on : Jun 13, 2012, 10:34:12 AM
    Author     : Saldivar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
    <title>Jorge Sald&iacute;var - Lab07</title>
</head>

<body>

  <form action="addUser" method="post">
 
      <p align="left">Nombre:
      <input type="text" name="name"></p>
      
      <h2> Idiomas que hable </h2>
        
        Ingl&eacute;s <input type="checkbox" name="languages" value="Ingles" /><br />
        Franc&eacute;s <input type="checkbox" name="languages" value="Frances" /><br />
        Aleman <input type="checkbox" name="languages" value="Aleman" /><br />
        Espa&ntilde;ol <input type="checkbox" name="languages" value="Espanol" /><br />
        
        <input type="submit" value="Registrar" />

  </form>
    
       
    <a href="busqueda.jsp" > Buscar usuarios con idioma </a>
</body>

</html>