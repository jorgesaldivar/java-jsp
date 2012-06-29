<%-- 
    Document   : reporteDevueltos
    Created on : Jun 27, 2012, 12:07:06 AM
    Author     : Alex
--%>

<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
        <%
                String category = request.getParameter("categoria");
                
                java.util.Date utilDate = new java.util.Date(); //fecha actual
                long lnMilisegundos = utilDate.getTime();
                java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);  
        %>
       
        <h1 style="text-align: center;">Devoluciones del día: <%=sqlDate%></h1>
        <table id="reporte">
            <tr>
                <th>No. devolución</th>
                <th>Id Item</th>
                <th>Nombre</th>
                <th>Cantidad artículos devueltos</th>
                <th>Fecha</th>
            </tr>
            <%                  
                            
                try {
                    int suma = 0;
                    int contador = 0;
                    //Create a Connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

                    Statement s = con.createStatement();
                    String sql = "SELECT returneditem.idItem,item.name,returneditem.quantity,returneditem.date "
                            + "FROM returneditem,item "
                            + "WHERE returneditem.idItem=item.idItem "
                            + "AND returneditem.date='"+sqlDate+"'";
                    
                    ResultSet rs = s.executeQuery(sql);
                    
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String nombre = rs.getString(2);
                        int cantidad = rs.getInt(3);
                        String fecha = rs.getString(4);
                        
                        contador=contador+1;
                        suma=suma+cantidad;
                    
                   out.println("<tr id='"+ id +"'>"
            + "<td class='celda'>" + contador + "</td>"
            + "<td id='id-"+ id +"' class='celda'>" + id + "</td>"
            + "<td id='nombre-"+ id +"' class='celda'>"+nombre+"</td>"
            + "<td id='cantidad-"+ id +"' class='celda'>"+cantidad+"</td>"
            + "<td id='fecha-"+ id +"' class='celda'>"+fecha+"</td>"
            + "</tr>"          
                           );
                      
                    }
                    
                    suma=suma*(-1);
                    
               out.println("</table>");
               out.println("<br /><br />");
                   
               out.println("<table>");
               out.println("<tr><td>");
               out.println("<p>El día de hoy, " + sqlDate + ", se han hecho "+ contador +" devoluciones, "
                       + "en las cuales se regresaron "+suma+ " artículos</p>");
               out.println("</td></tr>");

                    rs.close();
                    s.close();
                    con.close();
                } catch (SQLException e2) {
                    // Exception when executing java.sql related commands, print error message to the console
                    System.out.println(e2.toString());
                } catch (Exception e3) {
                    // other unexpected exception, print error message to the console
                    System.out.println(e3.toString());
                }
            %>    
        </table>               
        <br /><br />

        <form action="gerenteDeVentas.jsp">
            <input style="float:none; margin-left: 830px;" type="submit" value="Regresar" />
        </form>
<jsp:include page="includes/footer.html" />