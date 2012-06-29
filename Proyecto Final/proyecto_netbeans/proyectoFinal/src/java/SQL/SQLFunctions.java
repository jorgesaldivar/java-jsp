package SQL;

import java.sql.*;

public class SQLFunctions
{

    public SQLFunctions()
    {}
    
     public static boolean addUserToDB(String name, String password, String email, String type)  throws SQLException
    {
        boolean addSucceed = false;
        
            try {
    
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/proyectofinal", "root", "");

            Statement s = con.createStatement();
            
            //String sql = "SELECT * FROM user";
            String sql = "INSERT INTO user " +
                "(username,password,email,type) "+
                "values ('"+name+"', '"+password+"', '"+email+"', '"+type+"')";
           
           int rs = s.executeUpdate(sql);
           
        
           if(rs == 1){
          ///       System.out.println("despues");
                 addSucceed = true; 
           }
            
           // rs.close();
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

            return addSucceed;
      }
     
     
     
     
     
     
      public static void addCategory(String category)  throws SQLException
    {
        
        try {
            
            
               
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/proyectofinal", "root", "");

            Statement s = con.createStatement();
            
            //String sql = "SELECT * FROM user";
            String sql = "INSERT INTO category " +
                "(category) "+
                "values ('" + category + "')";
           
           s.executeUpdate(sql);
           
      
            
           // rs.close();
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
    }
     
      
      
      
      
      
      
      public static void addArticle(String name, String description, String price, String quantity, String category)  throws SQLException
    {
        
        try {
            
            
               
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/proyectofinal", "root", "");

           int idcategory = -1;
            Statement s = con.createStatement();
            
            //String sql = "SELECT * FROM user";
            String sql = "SELECT idCategory FROM category WHERE category='" + category + "'";
           
           ResultSet rs = s.executeQuery(sql);
           
           while(rs.next()){
              
               idcategory = rs.getInt(1);
                
           }

            sql = "INSERT INTO item " +
                "(name,description,price,quantity,idCategory) "+
                "values ('" + name + "','" + description + "'," + price + "," + quantity + "," + idcategory + ")";
           System.out.println(sql);
           s.executeUpdate(sql);
           
      
            
           // rs.close();
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
    }
      
      
      
      public static String selectCategory()  throws SQLException
    {
        String category = "<option></option>";
        try {
            
            
               
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/proyectofinal", "root", "");

           
            Statement s = con.createStatement();
            
            //String sql = "SELECT * FROM user";
            String sql = "SELECT category FROM category ORDER BY category";
           
           ResultSet rs = s.executeQuery(sql);
           
           while(rs.next()){
               
              category += "<option value='" + rs.getString("category") + "'>" + rs.getString("category") + "</option>";
           }
            
           // rsget.close();
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
        return category;
    }
      
      
       public static String getItems()  throws SQLException
    {
         String items = "";
            try {
    
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Create a Connection object
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/proyectofinal", "root", "");

            Statement s = con.createStatement();
            
            String sql = "SELECT * FROM item";
           // String sql = "INSERT INTO user " +
           //     "(username,password,email,type) "+
           //     "values ('"+name+"', '"+password+"', '"+email+"', '"+type+"')";
           
           ResultSet rs = s.executeQuery(sql);
           
            
           
           while(rs.next()){
                //System.out.println("hola");
              // datos[] = rs.getString("nombre");
              
              items += "<tr><td id='name' class='modifycelda'>" +  rs.getString("name") + "</td>"
                    +  "<td id='price' class='modifycelda' ondblclick='modificar(this)'>" +  rs.getString("price") + "</td>"
                    +  "<td id='id' class='modifycelda' style='display:none;'><input type='hidden' value='" + rs.getString("idItem") + "'/></td></tr>";

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

            return items;
      }
}