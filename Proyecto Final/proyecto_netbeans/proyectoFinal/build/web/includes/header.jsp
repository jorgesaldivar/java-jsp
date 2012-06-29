<%@page import="bean.User"%>
<!DOCTYPE html>
<head>
	<!--Made by Alex, Joab, Jorge-->
	
	<!--Title-->
	<title>Shop</title>
	
	<!--Image beside title-->
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	
	<!--Se define el CSS-->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
        
        <!--Se define el Javascript-->
        <script type="text/javascript" src="js/modificacion.js"></script>

</head>

    <%

String link = "index.jsp";
String logout = "";

      //boolean entra = false;
      if(session.isNew() == false){

        String type = (String)session.getAttribute("type");  

       //link = "";
        
        if(type.equals("administrador")){
            logout = "<a href='logout.jsp' ><img src='images/logout.png' height='50px' style='float:right;'/></a>";
            link = "administrador.jsp";
        }
           else  if(type.equals("gerenteDeInventario")){
            logout = "<a href='logout.jsp' ><img src='images/logout.png' height='50px' style='float:right;'/></a>";
            link = "gerenteDeInventario.jsp";
        }
      
      else  if(type.equals("gerenteDeVentas")){
            logout = "<a href='logout.jsp' ><img src='images/logout.png' height='50px' style='float:right;'/></a>";
            link = "gerenteDeVentas.jsp";
        }
      
      else  if(type.equals("vendedor")){
            logout = "<a href='logout.jsp' ><img src='images/logout.png' height='50px' style='float:right;'/></a>";
            link = "vendedor.jsp";
        }
           else {
          
            link = "index.jsp";
            logout = "";
           }
             } else {
                session.setAttribute("type","invitado");
    
             }    
           
        %>

<html>

	<body>
            
             <div id="menu">
                 <div id="logo"><a href ="<%=link%>"><img src="images/shoplogo.png" height="50px"/></a> <%=logout%></div>
            </div>