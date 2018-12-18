<%-- 
    Document   : verproductos
    Created on : 18-dic-2018, 12:22:27
    Author     : Mañanas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="paquetetienda.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Producto> productos_tienda=(ArrayList<Producto>)request.getAttribute("productos_tienda");
    ArrayList<Integer> productos_comprados=(ArrayList<Integer>)session.getAttribute("productos_comprados");
    
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola, llevas comprados: <%=productos_comprados.size()%> productos</h1>
        <a href="ServletTienda?accion=vercompra">Ver compra</a>
        <br>
        <%for (int i=0; i<productos_tienda.size(); i++)
        { %>
        <a href="ServletTienda?accion=comprar&id_producto=<%=productos_tienda.get(i).getId() %>">
        <%=productos_tienda.get(i).getNombre() %>
        </a>
        <br>
              <% } %>  
    </body>
</html>
