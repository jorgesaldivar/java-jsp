
<%@page import="SQL.SQLFunctions"%>
<%@page import="data.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Item" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
        <script type="text/javascript">
            function cargarUser(){
                var a=prompt("Id de user");
                document.getElementById("userId").value=a;
            }
            function devolucion(){
                var a=prompt("numero de recibo");
                document.getElementById("devolver").value=a;
            }
        </script>
   
        
        
    
        
        
        <form id="form" action="InventarioAgotado">
            <fieldset>
                <legend>Reporte de inventario</legend>
                    <input type="submit" value="Generar"/>
            </fieldset>
        </form>
        
        <form id="form" action="devoluciones">
            <fieldset>
                <legend>Devoluciones</legend>
                     <input type="hidden" id="devolver" value="" name="devolver"/>
            <input type="submit" value="Devolver" onclick="devolucion()"/>
            </fieldset>
        </form>
        
        <form id="form" action="Buscar">
            <fieldset>
                <legend>Buscar por producto</legend>
                        <input type="text" name="search"/>
                        <input type="submit" value="Buscar"/>
            </fieldset>
        </form>
        
         <form id="form" action="Buscar">
            <fieldset>
                <legend>Buscar por categoria</legend>
                      <select name="category">
                  <%=SQLFunctions.selectCategory()%>  
              </select>
             <input type="submit" value="Buscar"/>
            </fieldset>
        </form>
        
        
  
          <%ArrayList <Item> lista=new ArrayList();
if(request.getAttribute("lista")!=null){
                   lista=(ArrayList)request.getAttribute("lista");}
    if(request.getAttribute("lista")==null){
     lista=new ArrayList();
} else if(lista.size()<=0){
    
    
} else{
%>
<br /><br />
    <div id="busquedaFormat">
                
        <table>
            
            <tr style="background-color:#353535;">
                 <td colspan="6" >Resultado de busqueda</td>
            </tr>
            
            <tr style="background-color:#353535;">
                 <td></td>
                <td>Item</td><td>Precio</td>
                <td>Inventario</td><td>Cantidad</td>
                <td></td>
            </tr>
            
<%

int variable = 0;
    
for (int i=0;i<lista.size();i++){ 
variable = lista.get(i).getIdItem(); 
if(variable >= 7){
   variable = 3;
} 
    %>      
        <tr> 
            <td>
                
                 <img src ="imagesItems/<%=variable%>.jpg" height="40px" width="40px"/>
                
            </td>
            <td>
                <%=lista.get(i).getName()%>
                </td>
                <td>
                    <%=lista.get(i).getPrice()%>
                </td>
                <td>
                    <%=lista.get(i).getQuantity() %>
                </td>
                <form action="comprar" ><td> <input type="text" name="cantidad"/> </td>
                    <td> <input type="hidden" name="id" value="<%=lista.get(i).getIdItem()%>" /> <input type="submit" value="Comprar"/> </td></form>
            </tr>

       


<%}%>     
        
        </table>
    </div> 



        <% }
         boolean entra = false;
          if (session.getAttribute("listaCarrito")!=null){
               ArrayList <Carrito> listaCarrito= (ArrayList<Carrito>)session.getAttribute("listaCarrito");
                    if(listaCarrito.size() >=1){ 
                            entra= true; 
                     }
    }if(entra){ %>
       
        <br />
        <div id="busquedaFormat"> 
            <table> 
                
                
                <tr>
                    <td>Item comprado</td>
                    <td> precio</td>
                    <td>cantidad</td>
                    <td></td>
                </tr>
                <%
           
             ArrayList <Carrito> listaCarrito= (ArrayList<Carrito>)session.getAttribute("listaCarrito");
            for (int i=0;i<listaCarrito.size();i++){
                
            
        %>
        
                <tr><td>
                    <%=listaCarrito.get(i).getItem().getName()%>
                    </td>
                    <td>
                        <%=listaCarrito.get(i).getItem().getPrice()%>
                    </td>
                    <td> 
                        <form action="ActualizarCantidad">
                            <input type="hidden" name="oculto" value="<%=i%>"/>
                        <input type="text" id="xcantidad"name="xcantidad"value="<%=listaCarrito.get(i).getCantidad()%>" size="3"/>
                       <input type="submit" value="Actualizar"> 
                        </form>
                      
                    </td>
                    <td>
                         <form action="BorrarDeCarrito"> 
                           <input type="hidden" name="oculto" value="<%=i%>"/>
                
                           <input type="submit"value="Borrar" /> </form>
                    </td>   
                   
                </tr>
           
            
        <%}%>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><form action="ValidaUsuario">
            <input name="userId" hidden="hidden" id="userId" />
            <input type="submit" value="Finalizar compra" onclick="cargarUser()"/>
        </form></td>
        </tr>
        
       
         </table>
        
         </div>
        <%} 
        entra = false;
 %>

          
<jsp:include page="includes/footer.html" />