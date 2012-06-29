<%-- 
    Document   : devoluciones
    Created on : 25-jun-2012, 17:35:46
    Author     : joab
--%>

<%@page import="data.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
        <form action="Devuelve">
        <h1 style="text-align: center;">Devoluciones</h1>
        <%ArrayList<Carrito> lista=(ArrayList<Carrito>)request.getAttribute("listaDevolucion");
        request.setAttribute("listaDevolucion", lista);
        for (int i=0;i<lista.size();i++){%>

    <table>
        
        <tr>
            <td>Item</td>
            <td>Precio</td>
            <td>Comprados</td>
            <td>Regresar</td>
        </tr>
        
         <tr>
            <td><%=lista.get(i).getItem().getName() %></td>
            <td><%=lista.get(i).getItem().getPrice()%></td>
            <td><%=lista.get(i).getCantidad() %></td>
            <td><input type="text" name="a<%=i%>"size="3" value=""/></td>
        </tr>
        
      <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>
                
                <%}%>          

    <%request.setAttribute("mensaje","devolucion");%>
    <%int idcustomer=Integer.parseInt(request.getAttribute("idcustomer").toString());%>
                <input type="hidden" name="idcustomer" value="<%=idcustomer%>"/>
    <input type="hidden" name="idsale" value="<%=request.getAttribute("idsale") %>"/>
    <input type="submit" value="submit"/>
    
            </td>
        </tr>
        
    </table>
   


    
</form>
<jsp:include page="includes/footer.html" />
