<%-- 
    Document   : recibo
    Created on : 24-jun-2012, 19:39:33
    Author     : joab
--%>

<%@page import="data.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
    <%Cliente nuevo=(Cliente)request.getAttribute("cliente");
        %>
   
        <h1 style="text-align: center;" >Sold to</h1>
        
        <div id="infoUser">
            <table>
                <tr>
                    <td>Nombre</td><td><span><%=nuevo.getUserName()%></span></td>
                </tr>
                 <tr>
                    <td>Compañ&iacute;a</td><td><span><%=nuevo.getCompany()%></span></td>
                </tr>
                 <tr>
                    <td>Direcci&oacute;n</td><td><span><%=nuevo.getAddress()%></span></td>
                </tr>
                 <tr>
                    <td>Ciudad</td><td><span><%=nuevo.getCity()%></span></td>
                </tr>
                 <tr>
                    <td>Telefono</td><td><span><%=nuevo.getPhone()%></span></td>
                </tr>
                <tr>
                    <td>Cliente ID</td><td><span><%=nuevo.getId()%></span></td>
                </tr>
                
    
            </table>
 
        </div>
        
        <table><tr>
            <th>
                Qty
            </th>
            <th>
                Item/Description
            </th>
            <th>
                Price/Unit
            </th>
            <th>
                Total
            </th>
            </tr>
            <%ArrayList<Carrito>lista=(ArrayList<Carrito>)request.getSession().getAttribute("listaCarrito");
int total=0;            
            for (int i=0;i<lista.size();i++){ 
            total+=(lista.get(i).getCantidad()*lista.get(i).getItem().getPrice());
%>
            <tr>
                <td>
                    <%=lista.get(i).getCantidad() %>
                </td>
                <td>
                    <%=lista.get(i).getItem().getName()%>
                    <%=lista.get(i).getItem().getDescription() %>
                    
                </td>
                <td>
                    <%=lista.get(i).getItem().getPrice() %>
                </td>
                <td>
                    <%=lista.get(i).getCantidad()*lista.get(i).getItem().getPrice() %>
                </td>
            </tr>
            
            
            
            <%}%>
        </table>
             <form id="form" style="margin-left:710px;">
            <input type="checkbox" name="pago" >cash</input><br />
            <input type="checkbox" name="pago" >CC</input><br />
            
            Total Due <%=total%>
             </form>
            <form id="form" action="Enviar">
                <input type="hidden" name="pato" value="si"/>
                <input type="hidden" name="total" value="<%=total%>"/> 
                <input type="hidden" name="idUser" value="<%=nuevo.getId()%>" />
                <%request.getSession().setAttribute("listaCarrito",lista);%>
            
            <input type="submit" value="aceptar"/>
            </form>
                <form id="form" action="Enviar"> 
                    <input type="hidden" name="pato" value="no"/> 
                    <input type="hidden" name="total" value="0"/> 
                    <input type="hidden" name="idUser" value="<%=nuevo.getId()%>" />
                    <input type="submit"  value="cancelar"/></form>
<jsp:include page="includes/footer.html" />

