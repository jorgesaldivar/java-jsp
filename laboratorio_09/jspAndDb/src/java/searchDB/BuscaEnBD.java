package searchDB;

import java.sql.*;

public class BuscaEnBD
{

    public BuscaEnBD()
    {}
    
     public static boolean search(String login, String password)  throws SQLException
    {
        boolean regresa_autorizado = false;
        
            try {
    
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/administrador", "root", "");


            Statement s = con.createStatement();
            String sql = "SELECT login, password FROM usuarios";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                if (login.equals(rs.getString("login")) && password.equals(rs.getString("password"))) { regresa_autorizado = true; }
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

            return regresa_autorizado;
      }
     
}