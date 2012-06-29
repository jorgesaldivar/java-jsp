<%-- 
    Document   : reporteTendencia
    Created on : Jun 26, 2012, 8:23:06 PM
    Author     : Alex
--%>

<jsp:include page="includes/header.jsp" />
<%@page import="java.sql.*" %>

        <h1 style="text-align: center;">Reporte de tendencia de venta</h1>
        <table id="inventario">
            <tr>
                <th>Id Item</th>
                <th>Name</th>
                <th>Cantidad</th>
                <th>Id Venta</th>
                <th>Fecha</th>
            </tr>
            <%              
            String item = request.getParameter("item");
            String desde = request.getParameter("desde");
            String hasta = request.getParameter("hasta");
            System.out.println(item+desde+hasta);
            int ventas = 0;
            
                try {
                    //Create a Connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

                    Statement s = con.createStatement();
                    String sql = "SELECT item.idItem, item.name,itemSold.quantity,itemSold.idSale,sale.date "
                            + "FROM item,itemSold,sale "
                            + "WHERE item.idItem=itemSold.idItem "
                            + "AND itemSold.idSale=sale.idSale "
                            + "AND item.name='"+item+"' "
                            + "AND (sale.date BETWEEN '"+desde+"' AND '"+hasta+"')";  
                                     
                    ResultSet rs = s.executeQuery(sql);

                    String name="";
                    
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        name = rs.getString(2);
                        int cantidad = rs.getInt(3);
                        int idSale = rs.getInt(4);
                        String fecha = rs.getString(5);
                        
                        ventas=ventas+cantidad;
                    
                   out.println("<tr id='"+ id +"'>"
            + "<td id='id-"+ id +"' class='celda'>" + id + "</td>"
            + "<td id='name-"+ id +"' class='celda'>"+name+"</td>"
            + "<td id='name-"+ id +"' class='celda'>"+cantidad+"</td>"
            + "<td id='cantidad-"+ id +"' class='celda'>"+idSale+"</td>"
            + "<td id='cantidad-"+ id +"' class='celda'>"+fecha+"</td>"
            + "</tr>"          
                           );
                      
                    }
                    
               out.println("</table>");
               out.println("<br /><br />");
                   
               out.println("<table>");
               out.println("<tr><td>");
               out.println("<p>En el periodo de "+desde+" hasta "+hasta+" se vendieron "+ventas+" "+name+"</p>");
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
