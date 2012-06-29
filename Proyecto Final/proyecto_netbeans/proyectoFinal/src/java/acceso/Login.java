/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import bean.User;
import bean.UserDatos;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Alex
 */
public class Login {

    public static boolean permite(User user) {
        boolean bandera = false;

        String username = user.getUsername();
        String password = user.getPassword();

        try {
            //Load the JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                
            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

            Statement s = con.createStatement();
            String sql = "SELECT password FROM user WHERE username='" + username + "'";
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                if (password.equals(rs.getString(1))) {
                    bandera = true;
                } else {
                    bandera = false;
                }
            } else {
                bandera = false;
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

        return bandera;
    }

    public static UserDatos getUserData(User user) {
        
        UserDatos datos = new UserDatos();
        
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            //Load the JDBC driver

            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");

            Statement s = con.createStatement();
            String sql = "SELECT type,status,hits,attempts,idUser FROM user WHERE username='" + username + "'";
            ResultSet rs = s.executeQuery(sql);

            rs.next();
            datos = new UserDatos(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));

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

        return datos;
    }

    public static void aumentaHits(User user, int hits) {
        
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            //Load the JDBC driver

            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");
                        
            Statement s = con.createStatement();
            String sql = "UPDATE user SET hits=" + hits + " WHERE username='" + username + "'";
            s.executeUpdate(sql);

            s.close();
            con.close();
        } catch (SQLException e2) {
            // Exception when executing java.sql related commands, print error message to the console
            System.out.println(e2.toString());
        } catch (Exception e3) {
            // other unexpected exception, print error message to the console
            System.out.println(e3.toString());
        }
    }
    
        public static void cambiaAttempts(User user, int attempts) {
        
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            //Load the JDBC driver

            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");
                        
            Statement s = con.createStatement();
            String sql = "UPDATE user SET attempts=" + attempts + " WHERE username='" + username + "'";
            s.executeUpdate(sql);

            s.close();
            con.close();
        } catch (SQLException e2) {
            // Exception when executing java.sql related commands, print error message to the console
            System.out.println(e2.toString());
        } catch (Exception e3) {
            // other unexpected exception, print error message to the console
            System.out.println(e3.toString());
        }
    }
        
      public static void cambiaPassword(User user, String password) {
        
        String username = user.getUsername();

        try {
            //Load the JDBC driver

            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");
                        
            Statement s = con.createStatement();
            String sql = "UPDATE user SET password='" + password + "' WHERE username='" + username + "'";
            s.executeUpdate(sql);

            s.close();
            con.close();
        } catch (SQLException e2) {
            // Exception when executing java.sql related commands, print error message to the console
            System.out.println(e2.toString());
        } catch (Exception e3) {
            // other unexpected exception, print error message to the console
            System.out.println(e3.toString());
        }
    }
      
      public static void bloqueado(User user) {
        
        String username = user.getUsername();

        try {
            //Load the JDBC driver

            //Create a Connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal", "root", "");
                        
            Statement s = con.createStatement();
            String sql = "UPDATE user SET status='bloqueado' WHERE username='" + username + "'";
            s.executeUpdate(sql);

            s.close();
            con.close();
        } catch (SQLException e2) {
            // Exception when executing java.sql related commands, print error message to the console
            System.out.println(e2.toString());
        } catch (Exception e3) {
            // other unexpected exception, print error message to the console
            System.out.println(e3.toString());
        }
    }
}
