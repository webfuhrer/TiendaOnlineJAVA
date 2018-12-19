<%-- 
    Document   : verproductos
    Created on : 18-dic-2018, 12:22:27
    Author     : Mañanas
--%>

<%@page import="paquetetienda.Compra"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paquetetienda.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Producto> productos_tienda=(ArrayList<Producto>)request.getAttribute("productos_tienda");
    ArrayList<Compra> productos_comprados=(ArrayList<Compra>)session.getAttribute("productos_comprados");
    int cantidad_productos=0;
    for (Compra compra : productos_comprados) {
            int n=compra.getCantidad();
            cantidad_productos+=n;//cantidad_productos=cantidad_productos+n;
        }
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola, llevas comprados: <%=cantidad_productos%> productos</h1>
        <a href="ServletTienda?accion=vercompra">Ver compra</a>
        <br>
        <%for (int i=0; i<productos_tienda.size(); i++)
        { %>
        <a href="ServletTienda?accion=comprar&id_producto=<%=productos_tienda.get(i).getId() %>">
        <%=productos_tienda.get(i).getNombre() %>
        </a><%=productos_tienda.get(i).getStock()%>
        <br>
              <% } %>  
    </body>
</html>
