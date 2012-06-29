<%@page import="business.User"%>
<jsp:include page="includes/header.html" />
  <h1>Join our email list</h1>
  <p>To join our email list, enter your name and
     email address below. <br>
     Then, click on the Submit button.</p>

  <%
  
    ServletContext sc = getServletContext();
    String message  = (String) sc.getAttribute("message");
    String firstName     = request.getParameter("firstName");
    String emailAddress    = request.getParameter("emailAddress");
    String lastName     = request.getParameter("lastName");
    String career       = request.getParameter("carrera");
    
    
       
     
    if(message != null){
         out.println("<span style='color:red'>" + message + "</span><br /><br />");
    }
           
    if(firstName == null){ 
        firstName = "";
        }
    
    if(lastName == null){     
        lastName = "";
        }
    
    if(emailAddress == null){
        emailAddress = "";
        }
 
  
    %>
 

  <form action="addEmail" method="post">
  <table cellspacing="5" border="0">
    <tr>
      <td align="right">First name:</td>
      <td><input type="text" name="firstName" value="<%=firstName%>"></td>
    </tr>
    <tr>
      <td align="right">Last name:</td>
      <td><input type="text" name="lastName" value="<%=lastName%>"></td>
    </tr>
    <tr>
      <td align="right">Email address:</td>
      <td><input type="text" name="emailAddress" value="<%=emailAddress%>"></td>
    </tr>
    <tr>
      <td style="text-align: right;">Carrera</td><td>
          <select id="carrera" name="carrera" value="ISD">
           
              <option>INT</option>
            <option>ISC</option>
            <option>ISD</option>
            <option>ITC</option>
            <option>ITE</option>
            <option>ITIC</option>
            <option>ITM</option>
            <option>ITS</option>
            <option>LATI</option>
</select>

         
    <script>
    var carrera="<%=request.getParameter("carrera")%>";
    options=document.getElementsByTagName("option");
    for (i=0;i<options.length;i++){
        if (options[i].innerHTML==carrera){
        document.getElementById("carrera").selectedIndex=i;
        }
    }
    </script>

    
      </td>
    </tr>
      <tr>
          <td></td> <td>
      <input type="submit" value="Submit"></td>
    </tr>
  </table>
  </form>
<jsp:include page="includes/footer.html" />