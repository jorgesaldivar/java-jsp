<%@page import="java.sql.*"%>

<jsp:include page="includes/header.jsp" />

        <%
                String category = request.getParameter("categoria");
                
                java.util.Date utilDate = new java.util.Date(); //fecha actual
                long lnMilisegundos = utilDate.getTime();
                java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);  
        %>
       
        <h1 style="text-align: center;">Reporte de ventas del día: <%=sqlDate%></h1>
        <table id="reporte">
            <tr>
                <th>Número de venta del día</th>
                <th>Id Venta</th>
                <th>Vendedor</th>
                <th>Total</th>
                <th>Fecha</th>
            </tr>
            <%                  
                            
                try {
                    int suma = 0;
                    int contador = 0;
                     Class.forName("com.mysql.jdbc.Driver");
                      //Create a Connection object
                    Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost/proyectofinal", "root", "");

                    Statement s = con.createStatement();
                    String sql = "SELECT sale.idSale,sale.date,sale.total,user.username "
                            + "FROM sale,user "
                            + "WHERE sale.idUser=user.idUser AND sale.date='"+sqlDate+"'";
                    ResultSet rs = s.executeQuery(sql);

                    
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String fecha = rs.getString(2);
                        int total = rs.getInt(3);
                        String vendedor = rs.getString(4);
                        contador=contador+1;
                        suma=suma+total;
                    
                   out.println("<tr id='"+ id +"'>"
            + "<td class='celda'>" + contador + "</td>"
            + "<td id='id-"+ id +"' class='celda'>" + id + "</td>"
            + "<td id='nombre-"+ id +"' class='celda'>"+vendedor+"</td>"
            + "<td id='descripcion-"+ id +"' class='celda'>"+total+"</td>"
            + "<td id='precio-"+ id +"' class='celda'>"+fecha+"</td>"
            + "</tr>"          
                           );
                      
                    }
               out.println("</table>");
               out.println("<br /><br />");
                   
               out.println("<table>");
               out.println("<tr><td>");
               out.println("<p>El día de hoy, " + sqlDate + ", se han hecho "+ contador +" ventas, "
                       + "las cuales generaron un monto de ventas de $"+suma+ "</p>");
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
        <tr style =" background-color:#353535;">
               <td><form action="gerenteDeVentas.jsp"><input type="submit" value="Regresar" /></form></td>
                    </tr>
        </table>  
<jsp:include page="includes/footer.html" />
