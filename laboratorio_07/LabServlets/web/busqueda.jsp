<%-- 
    Document   : busqueda
    Created on : Jun 15, 2012, 5:22:23 PM
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
        <h1>Buscador de candidatos</h1>
        
        <p> Idiomas que se requiere
        
        <form method="post" action="resultados">
            <select name="languages">
                
                <option value="Espanol">Espanol</option>
                 <option value="Ingles">Ingles</option>
                  <option value="Aleman">Aleman</option>
                   <option value="Frances">Frances</option>
            </select>
        <input type="submit" value="Buscar"/>
        </form>
        </p>
    </body>
</html>
