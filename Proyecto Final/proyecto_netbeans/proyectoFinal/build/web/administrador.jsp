<%@page import="bean.User"%>
<%@page import="Mail.SendMail"%>
<%@page import="SQL.SQLFunctions"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="java.util.*"%>


<jsp:include page="includes/header.jsp" />
    <%

       User user = (User)session.getAttribute("user");
    String username = user.getUsername();
    String password = user.getPassword();
    
    String type = (String)session.getAttribute("type");  

      
        
        if(type.equals("administrador")){
    %>
    
    <div>
 
   <form id="form" name="form" method="POST" action="addUser.jsp"><input type="submit" value="Agregar Usuario" /></form>		
   <form id="form" name="form" method="POST" action="addArticleCategory.jsp"><input type="submit" value="Agregar articulo/categoria" /></form>	
   <form id="form" name="form" method="POST" action="modifyArticle.jsp"><input type="submit" value="Modificar articulo" /></form>	

    </div>

                          
           
    
    <% 
       }
           else {
            
            response.sendRedirect("index.jsp");
           }
    %>

<jsp:include page="includes/footer.html" />