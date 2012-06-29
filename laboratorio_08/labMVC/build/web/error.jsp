<jsp:include page="includes/header.html" />
<h1>Esa pagina no existe compa, mejor visita 
            <% // get a relative file name
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/join_email_list.jsp");
                
                %>
            
            
<a href="http://www.aijole.com">ESTA</a> :)</h1>
<jsp:include page="includes/footer.html" />

