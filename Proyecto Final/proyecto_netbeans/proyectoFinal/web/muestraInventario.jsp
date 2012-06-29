<%--
    Document   : muestraInventario
    Created on : 25-jun-2012, 13:30:36
    Author     : joab
--%>

<%@page import="data.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>

        <script type="text/javascript">
            function enviar(){
                
                var a=document.getElementsByName("agrega");
                xhr=new XMLHttpRequest();
                for (var i=0;i<a.length+1;i++)
                    {
                        
                        
                        if(a[i].checked==true){
                        xhr.open("get","EnviarInventario?value="+a[i].value,true);
                        xhr.send(null);
                        alert(a[i].value);
                                        
                        
                        
                        }
                            
                    }
            
        }
        </script>
<jsp:include page="includes/header.jsp" />
        <form action="vendedor.jsp" id="form">
        <h1 style="text-align: center;">Inventario</h1>
        <table>
            <%ArrayList<Item> listaItem=(ArrayList<Item>)request.getAttribute("listaItems");
            for (int i=0;i<listaItem.size();i++){ %>
            <tr>
                <td>
                    <input id="pato" type="checkbox" name="agrega" value="<%=listaItem.get(i).getIdItem()%>" />
                </td>
                <td>
                    <%=listaItem.get(i).getIdItem()%>
                </td>
                <td>
                    <%=listaItem.get(i).getName()%>
                </td>
                <td>
                    <%=listaItem.get(i).getQuantity()%>
                </td>
            </tr>
    <%}%>        
       <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>
                
                <input type="submit" value="Enviar" onclick="enviar()"/>
    </form>
                
            </td>
        </tr>
        
       
         </table>
        
<jsp:include page="includes/footer.html" />