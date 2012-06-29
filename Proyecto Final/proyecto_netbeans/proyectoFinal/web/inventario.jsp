<jsp:include page="includes/header.jsp" />
<%@page import="java.sql.*" %>

        <h1 style="text-align:center;">Estado de inventario</h1>
        <table id="inventario">
            <tr>
                <th>Id Producto</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Categoria</th>
            </tr>
            <%              
                try {
                    //Create a Connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

                    Statement s = con.createStatement();
                    String sql = "SELECT idItem, name, description, price, quantity, category "
                            + "FROM item,category "
                            + "WHERE item.idCategory=category.idCategory";  
                                     
                    ResultSet rs = s.executeQuery(sql);

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String nombre = rs.getString(2);
                        String descripcion = rs.getString(3);
                        int precio = rs.getInt(4);
                        int cantidad = rs.getInt(5);
                        String categoria = rs.getString(6);
                    
                   out.println("<tr id='"+ id +"'>"
            + "<td id='id-"+ id +"' class='celda'>" + id + "</td>"
            + "<td id='nombre-"+ id +"' class='celda'>"+nombre+"</td>"
            + "<td id='descripcion-"+ id +"' class='celda'>"+descripcion+"</td>"
            + "<td id='precio-"+ id +"' class='celda'>"+precio+"</td>"
            + "<td id='cantidad-"+ id +"' class='celda'>"+cantidad+"</td>"
            + "<td id='categoria-"+ id +"' class='celda'>"+categoria+"</td>"
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
            
           
                  <tr style =" background-color:#353535;"><td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td><td><form action="gerenteDeInventario.jsp"><input type="submit" value="Regresar" /></form></td>
                    </tr>
        </table>  
            
       
        
        
<jsp:include page="includes/footer.html" />
