<html>
<head>
<title>Accessing data in a database</title>
<style type="text/css">
table
{
font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
width:30%;
border-collapse:collapse;
} 
td,th 
{
font-size:1em;
border:1px solid #98bf21;
padding:3px 7px 2px 7px;
}
th 
{
font-size:1.1em;
text-align:left;
padding-top:5px;
padding-bottom:4px;
background-color:#A7C942;
color:#ffffff;
}
tr.alt td 
{
color:#000000;
background-color:#EAF2D3;
}
</style>
</head>
<body>
<%@ page import = "java.lang.*,java.io.*,java.util.*,java.sql.*" %>
<%

try {
  //Load the JDBC driver
  Class.forName("com.mysql.jdbc.Driver");
  //Create a Connection object
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/thin", "root", "");

  Statement s = con.createStatement();
  String sql = "SELECT name, abbreviation FROM state";
  ResultSet rs = s.executeQuery(sql);
%>
<table>
<tr>
<th>State</th>
<th>Abbreviation</th>
</tr>
<%
  boolean alt=false;
  while (rs.next()) {
    if (alt)
       out.println("<tr class='alt'>");
    else
       out.println("<tr>");

    out.println("<td>"+rs.getString(1) + "</td><td>"  + rs.getString(2)+"</td>");
    out.println("</tr>");
   alt=!alt;

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
%>
</table>
</body>
</html>