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
        document.getElementById("nameLabel").style.color="";
        document.getElementById("passwordLabel").style.color="";
    
        if(document.getElementById("username").value == ""){
            document.getElementById("msj").innerHTML = "**Campos obligatorios";
            document.getElementById("nameLabel").style.color="red";
            allGood = false;
        }
        if(document.getElementById("password").value == ""){
            document.getElementById("msj").innerHTML = "**Campos obligatorios";
            document.getElementById("passwordLabel").style.color="red";
            allGood = false;
        }
        
        return allGood;
    }
</script>


<%
    String mensaje = "";
    mensaje = (String) session.getAttribute("mensaje");
%>
<form id="form" name="form" method="POST" action="ServletLogin">

    <fieldset>
        <legend>Iniciar Sesi&oacute;n: </legend>
        <ul>

            <li><label id="nameLabel">Username: </label><input type="text" name="username" id="username" autofocus/></li>
            <li><label id="passwordLabel">Password: </label><input type="password" name="password" id="password"/></li>	
            <li><input type="submit" value="Mandar" /></li>					

        </ul>

        <h2> 
            <%if (mensaje != null) {%>
            <%= mensaje%> 
            <% }%>
        </h2>
        <h3><span id="msj" style="color:red"></span></h3>

    </fieldset>
</form>

<jsp:include page="includes/footer.html" />