<%@page import="Mail.SendMail"%>
<%@page import="SQL.SQLFunctions"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="java.util.*"%>


<jsp:include page="includes/header.jsp" />
    <%

    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String type = request.getParameter("type");
    boolean errors = false;
    
    if (name == null || name == ""){      name = ""; errors = true; }
    if (password == null || password == ""){  password = ""; errors = true; }
    if (email == null || email == ""){     email = ""; errors = true; }
    if (type == null || type == ""){      type = ""; errors = true; }
    
    //out.println(name + " " + password + " " + email + " " + type);
    
    if(!errors){
        boolean addSucceed = false;
        addSucceed = SQLFunctions.addUserToDB(name,password,email,type);
        
            if(addSucceed){
                //out.println("Chingon que ya se agrego");
                SendMail.sendMail(name,email,password);
             }
    }
    //System.out.println(user.getLogin());

    
    /*
    if (autorizadoBD) {
            // datos correctos
            session.setAttribute("autorizado", "si");
    } else {
            // datos incorrectos
            session.setAttribute("autorizado", "no");
    }*/
 
    
    %>
    
 
            <form id="form" name="form" method="POST" action="">

                            <fieldset>
                                <legend>Agregar Usuario: </legend>
                                    <ul>

                                        <li><label id="nameLabel">Nombre: 			</label><input type="text" name="name" value="<%=name%>" autofocus/></li>	
                                        <li><label id="passwordLabe">Clave de acceso:           </label><input type="password" name="password" value=""/></li>
                                        <li><label id="passwordLabe">Correo:                    </label><input type="text" name="email" value="<%=email%>"/></li>
                                        <li><label id="passwordLabe">Tipo de usuario:           </label>
                                                                                                        <span class="optionsAddUser"><input type="radio" class="radioClass" name="type" value="vendedor" /> Vendedor </span>
                                                                                                        <span class="optionsAddUser"><input type="radio" class="radioClass" name="type" value="gerenteDeVentas" /> Gerente de ventas </span>
                                                                                                        <span class="optionsAddUser"><input type="radio" class="radioClass" name="type" value="gerenteDeInventario" /> Gerente de inventario </span>
                                                                                                        <span class="optionsAddUser"><input type="radio" class="radioClass" name="type" value="administrador" /> Administrador </span>
                                        </li>
                                        
                                        <script>
                                            var tipo="<%=type%>";
                                            options=document.getElementsByClassName("radioClass");
                                            for (i=0;i<options.length;i++){
                                                if (options[i].value==tipo){
                                                options[i].checked=true;
                                                }
                                            }
                                        </script>

                                        
                                                                                                         <input type="submit" value="Mandar" /> 						

                                    </ul>

                            </fieldset>
            </form>
                                            
                                            <form id="form" name="form" method="POST" action="administrador.jsp"><input type="submit" value="Regresar" /></form>

<jsp:include page="includes/footer.html" />