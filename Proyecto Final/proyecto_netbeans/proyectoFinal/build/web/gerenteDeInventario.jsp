<jsp:include page="includes/header.jsp" />
<%@page import="SQL.SQLFunctions"%>
<%@page import="bean.User"%>
<%
    User user = (User)session.getAttribute("user");
    String username = user.getUsername();
    String password = user.getPassword();
    
    String type = (String)session.getAttribute("type");    
%>

        <h1 align="center">Bienvenido usuario: <%=username + "/" + password %></h1>
        <h2 align="center">Usuario de tipo: <%= type %></h2>
        <br />
        
        <form id="form" name="form" method="GET" action="inventario.jsp">
        <fieldset>
            <legend>Consultar el estado del inventario</legend>
        <input type="submit" value="Consultar inventario" />
        </fieldset>
        </form>
        <br />
        
        <form id="form" name="form" method="GET" action="reporteCategoria.jsp">
        <fieldset>
        <legend>Generar reporte por categoría</legend>
            <select name="categoria">
                <%=SQLFunctions.selectCategory()%>
            </select>
            <input type="submit" value="Generar Reporte" />
        </fieldset>
        </form>
        <br />

        <form id="form" name="form" method="GET" action="reportePrecio.jsp">
        <fieldset>
        <legend>Generar reporte por precios</legend>
            <p>Desde: $<input type="text" name="desde" /> </p>
            <p>Hasta: $<input type="text" name="hasta" /></p>
        <input type="submit" value="Generar Reporte" />
        </fieldset>
        </form>
        
        <form id="form" name="form" method="GET" action="reporteReabastecer.jsp">
        <fieldset>
        <legend>Productos que necesitan ser reabastecidos</legend>
        <input type="submit" value="Generar Reporte" />
        </fieldset>
        </form>
        
        <jsp:include page="includes/footer.html" />