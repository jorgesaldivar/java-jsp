<%-- 
    Document   : index
    Created on : Jun 8, 2012, 10:34:44 AM
    Author     : Saldivar
--%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--Made by Jorge Saldivar A01033317-->
        <title>Jorge Sald&iacute;var - Lab06 (Servidor)</title>
        
        <!--Image beside title-->
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        
        <!--CSS for website-->
        <style type="text/css">
        body {color:#663300; background-color:#FFFFCC}
        table{border-collapse:collapse;}
        td {border:1px solid black; padding:10px}
        </style>
        
    </head>
    
    <body>
        
        <h2> Resumen de los datos de la forma </h2>
        
        <!--Table with all name and value data from the form submitted-->
        <table> 
            <tr>    
                <th>Variable</th>
                <th>Valor</th>
            </tr>

            <%
            
            //Gets all names from the form submitted
            Enumeration elementos = request.getParameterNames();  
            
            //Fetch all names
            while (elementos.hasMoreElements()) {  
                
                //Used to get the name from current pointer
                String nombre;
                
                nombre = (String)elementos.nextElement();
                
                //Gets the value of the name. Its an array for multiple values with the same name
                String[] valor = request.getParameterValues(nombre);                                
                   
                //Gets all the values and prints data
                for (int i = 0; i < valor.length; i++) {
                    out.println(" <tr><td>" + nombre + "</td>");
                    out.println("<td>" + valor[i] + "</td></tr>");        
                }
    
            }
          
            %>
                 
        </table>
        
    </body>
</html>