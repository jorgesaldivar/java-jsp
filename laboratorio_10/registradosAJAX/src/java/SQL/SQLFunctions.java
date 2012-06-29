package SQL;

import java.sql.*;
import java.util.ArrayList;

public class SQLFunctions
{

    public SQLFunctions()
    {}
    
     public static String getUsersDB()  throws SQLException
    {
         String datos = "";
            try {
    
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/usuarios", "root", "");

            Statement s = con.createStatement();
            
            String sql = "SELECT * FROM registrados";
           // String sql = "INSERT INTO user " +
           //     "(username,password,email,type) "+
           //     "values ('"+name+"', '"+password+"', '"+email+"', '"+type+"')";
           
           ResultSet rs = s.executeQuery(sql);
           
            
           
           while(rs.next()){
                
              // datos[] = rs.getString("nombre");
              
              datos += "<tr><td id='nombre' class='celda' ondblclick='modificar(this)'>" +  rs.getString("nombre") + "</td>"
                    +  "<td id='apellido' class='celda' ondblclick='modificar(this)'>" + rs.getString("apellido") + "</td>"
                    +  "<td id='direccion' class='celda' ondblclick='modificar(this)'>" + rs.getString("direccion") + "</td>"
                    +  "<td id='codigo' class='celda' ondblclick='modificar(this)'>" + rs.getString("codigo") + "</td>"
                    +  "<td id='ciudad' class='celda' ondblclick='modificar(this)'>" + rs.getString("ciudad") + "</td>"
                    +  "<td id='hijos' class='celda' ondblclick='modificar(this)'>" + rs.getString("hijos") + "</td>"
                    +  "<td id='email' class='celda' ondblclick='modificar(this)'>" + rs.getString("email") + "</td>"
                    +  "<td id='id' class='celda' style='display:none;'><input type='hidden' value='" + rs.getString("id") + "'/></td>"
                    +  "<td id='boton' class='celda'><input type='button' value='Borrar fila' onclick='borrar(this)'/></td></tr>";

           }
            
            rs.close();
            s.close();
            con.close();
            }
            
            catch (SQLException e2) {
            // Exception when executing java.sql related commands, print error message to the console
            System.out.println(e2.toString());
            }
            
            catch (Exception e3) {
            // other unexpected exception, print error message to the console
            System.out.println(e3.toString());
            }

            return datos;
      }
     
}