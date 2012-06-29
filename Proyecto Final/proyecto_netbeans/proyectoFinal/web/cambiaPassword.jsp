<%-- 
    Document   : cambiaContraseña
    Created on : Jun 20, 2012, 6:52:20 PM
    Author     : Alex
--%>

<%@page import="bean.User"%>
<jsp:include page="includes/header.jsp" />

<script language="Javascript" type="text/javascript">
    window.onload = initForm;

    function initForm() {
        document.forms[0].onsubmit = function() {return validate();}
    }
    function validate()
    {
        var allGood = true;
    
        document.getElementById("msj").innerHTML = "";
        document.getElementById("passwordLabel").style.color="";
        document.getElementById("passwordLabel2").style.color="";
        
        if(document.getElementById("password").value == ""){
            document.getElementById("msj").innerHTML = "**Campos obligatorios";
            document.getElementById("passwordLabel").style.color="red";
            allGood = false;
        }
        
        if(document.getElementById("password2").value == ""){
            document.getElementById("msj").innerHTML = "**Campos obligatorios";
            document.getElementById("passwordLabel2").style.color="red";
            allGood = false;
        }
    
        if(document.getElementById("password").value != document.getElementById("password2").value){
            document.getElementById("msj").innerHTML = "**El password debe ser el mismo en los dos campos";
            document.getElementById("passwordLabel").style.color="red";
            document.getElementById("passwordLabel2").style.color="red";
            allGood = false;
        }
        
        return allGood;
    }
</script>

<%
    User user = (User) session.getAttribute("user");
    String nombre = user.getUsername();
%>
		<form id="form" name="form" method="POST" action="ServletCambiaPwd">

				<fieldset>
                                    <legend>Bienvenido <%= nombre %>, favor de cambiar tu password para siguientes ingresos</legend>
					<ul>
                                            <li id="invisible"><label id="nameLabel">Username: </label><input type="text" name="username" value="<%=nombre%>" autofocus/></li>	
                                            <li><label id="passwordLabel">Password: </label><input type="password" name="password" id="password"/></li>	
                                            <li><label id="passwordLabel2">Repite password: </label><input type="password" name="password2" id="password2"/></li>	
                                            <li><input type="submit" value="Mandar" /></li>					
                                            
                                        </ul>
                                            <h3><span id="msj" style="color:red"></span></h3>
                                </fieldset>
                </form>
                                           
<jsp:include page="includes/footer.html" />