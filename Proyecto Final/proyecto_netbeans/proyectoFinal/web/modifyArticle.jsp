<%@page import="Mail.SendMail"%>
<%@page import="SQL.SQLFunctions"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="java.util.*"%>


<jsp:include page="includes/header.jsp" />
    <%

 
    
    %>
    
 
            <table id="tabla-usuarios">
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
                <th style='display:none;'></th>
            </tr>

           
                
                <%= SQLFunctions.getItems() %>

                
    


            </table>
                
                <form id="form" name="form" method="POST" action="administrador.jsp"><input type="submit" value="Regresar" /></form>

<jsp:include page="includes/footer.html" />