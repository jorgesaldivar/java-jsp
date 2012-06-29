<%@page import="Mail.SendMail"%>
<%@page import="SQL.SQLFunctions"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="java.util.*"%>


<jsp:include page="includes/header.jsp" />
    <%
        String acategory = request.getParameter("a_category");

        String bname        = request.getParameter("b_name");
        String bdescription        = request.getParameter("b_description");
        String bprice        = request.getParameter("b_price");
        String bquantity        = request.getParameter("b_quantity");
        String bcategory        = request.getParameter("b_category");
      
     
     
     
     
     
     
     if(acategory != null && acategory != ""){
         SQLFunctions.addCategory(acategory);
         %>
         <h1 style="text-align: center"> FELICIDADES, la categoria se agrego exitosamente </h1>
         <%
     }
        
               else if ((bname != null && bname != "") 
                            && (bdescription != null && bdescription != "")
                            && (bprice != null && bprice != "")
                            && (bquantity != null && bquantity != "")
                            && (bcategory != null && bcategory != "")
               ){
                  SQLFunctions.addArticle(bname, bdescription, bprice, bquantity, bcategory); 
                   %>
         <h1 style="text-align: center"> FELICIDADES, el producto fue agregado exitosamente </h1>
         <%
               }
  
 
    
    %>
    
 
            <form id="form" name="form" method="POST" action="">

             <fieldset>
                <legend>Agregar Categoria: </legend>
                     <ul>
                        <li><label id="nameLabel">Categoria: 	</label><input type="text" name="a_category" value="" autofocus/></li>	
                                                                        <input type="submit" value="Agregar" /> 						
                     </ul>

             </fieldset>
            
             <fieldset>
                <legend>Agregar producto: </legend>
                     <ul>
                        <li><label id="nameLabel">Producto: 	</label><input type="text" name="b_name" value="" autofocus/></li>	
                        <li><label id="nameLabel">Descripcion: 	</label><input type="text" name="b_description" value="" /></li>	
                        <li><label id="nameLabel">Precio: 	</label><input type="text" name="b_price" value="" /></li>	
                        <li><label id="nameLabel">Cantidad: 	</label><input type="text" name="b_quantity" value=""/></li>	
                        <li><label id="nameLabel">Categoria: 	</label><select name="b_category">
                               
                                <%= SQLFunctions.selectCategory()%>

                            </select>
                        </li>	
                                                                        <input type="submit" value="Agregar" /> 						
                     </ul>

             </fieldset>
            </form>
                                
                                <form id="form" name="form" method="POST" action="administrador.jsp"><input type="submit" value="Regresar" /></form>

<jsp:include page="includes/footer.html" />