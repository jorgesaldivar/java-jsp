<%-- 
    Document   : forma.jsp
    Created on : Jun 22, 2012, 9:53:58 AM
    Author     : Saldivar
--%>

<%@page import="SQL.SQLFunctions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />

		<title>Jorge Sald&iacute;var - Modificación "en línea" desde una página web</title>

		<link rel="StyleSheet" type="text/css" href="tabla.css"/>
		<script type="text/javascript" src="modificacion.js"></script>

   </head>

    <body>
        <h1>Lista de usuarios</h1>


            <table id="tabla-usuarios">
            <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Dirección</th>
                    <th>Código Postal</th>
                    <th>Ciudad</th>
                    <th>Hijos</th>
                    <th>Email</th>

            </tr>

           
                
                <%= SQLFunctions.getUsersDB() %>

                
    


            </table>
                
            <input type="button" onclick="agregar()" value="Agrega fila" />

  </body>
  </html>