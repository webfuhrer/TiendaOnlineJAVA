<%-- 
    Document   : vercompra
    Created on : 18-dic-2018, 12:50:31
    Author     : Mañanas
--%>
<%@page import="paquetetienda.PintarHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paquetetienda.Producto"%>
<%
    ArrayList<Producto> lista_comprados=( ArrayList<Producto>)request.getAttribute("objetos_productos");
    String html_factura=PintarHTML.pintarTabla(lista_comprados);
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Factura</h1>
        <%=html_factura%>
    </body>
</html>
