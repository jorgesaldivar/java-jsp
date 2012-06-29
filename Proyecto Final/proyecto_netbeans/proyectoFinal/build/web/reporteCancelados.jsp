<%-- 
    Document   : reporteCancelados
    Created on : Jun 26, 2012, 7:21:05 PM
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
       
        <h1 style="text-align: center;">Reporte de recibos de venta cancelados el día: <%=sqlDate%></h1>
        <table id="reporte">
            <tr>
                <th>Id de venta</th>
                <th>Total</th>
                <th>Fecha Cancelación</th>
            </tr>
            <%                  
                            
                try {
                    int suma = 0;
                    int contador = 0;
                    //Create a Connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

                    Statement s = con.createStatement();
                    String sql = "SELECT itemnotsold.idsale,sale.total,sale.date "
                            + "FROM itemnotsold,sale "
                            + "WHERE itemnotsold.idsale=sale.idSale AND sale.date = '"+sqlDate +"'";

                    ResultSet rs = s.executeQuery(sql);

                    
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        int total = rs.getInt(2);
                        String fecha = rs.getString(3);
                        
                        contador = contador + 1;
                    
                   out.println("<tr id='"+ id +"'>"
            + "<td id='id-"+ id +"' class='celda'>" + id + "</td>"
            + "<td id='total-"+ id +"' class='celda'>" + total + "</td>"
            + "<td id='fecha-"+ id +"' class='celda'>"+fecha+"</td>"
            + "</tr>"          
                           );
                      
                    }
               out.println("</table>");
               out.println("<br /><br />");
                   
               out.println("<table>");
               out.println("<tr><td>");
               out.println("<p>El día de hoy, "+ sqlDate 
                       +",se cancelaron "+contador+" recibos de ventas debido a errores de captura</p>");
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
            <input style="float:none;margin-left:830px;" type="submit" value="Regresar" />
        </form>
        
<jsp:include page="includes/footer.html" />