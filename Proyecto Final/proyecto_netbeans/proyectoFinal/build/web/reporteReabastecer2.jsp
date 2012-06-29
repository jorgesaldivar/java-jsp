<%-- 
    Document   : reporteReabastecer2
    Created on : Jun 26, 2012, 3:10:28 PM
    Author     : Alex
--%>

<jsp:include page="includes/header.jsp" />
<%@page import="java.sql.*" %>

        <h1 style="text-align:center;">Reporte de productos que necesitan ser reabastecidos</h1>
        <table id="inventario">
            <tr>
                <th>Id Inventario</th>
                <th>Id Item</th>
                <th>Nombre</th>
                <th>Cantidad en existencia</th>
            </tr>
            <%              
                try {
                    //Create a Connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

                    Statement s = con.createStatement();
                    String sql = "SELECT id,idItem,name,quantity "
                            + "FROM inventario";  
                                     
                    ResultSet rs = s.executeQuery(sql);

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        int idItem = rs.getInt(2);
                        String name = rs.getString(3);
                        int cantidad = rs.getInt(4);
                    
                   out.println("<tr id='"+ id +"'>"
            + "<td id='id-"+ id +"' class='celda'>" + id + "</td>"
            + "<td id='idItem-"+ id +"' class='celda'>"+idItem+"</td>"
            + "<td id='name-"+ id +"' class='celda'>"+name+"</td>"
            + "<td id='cantidad-"+ id +"' class='celda'>"+cantidad+"</td>"
            + "</tr>"          
                           );
                      
                    }

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
                <td></td>
                <td></td>
                <td></td><td><form action="gerenteDeVentas.jsp"><input type="submit" value="Regresar" /></form></td>
                    </tr>
        </table>  
<jsp:include page="includes/footer.html" />
