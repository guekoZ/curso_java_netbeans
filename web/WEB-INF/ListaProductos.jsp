<%-- 
Este video se explica en el video 252
  Este es el archivo que contiene la vista y recibe los datos de las demas clases para ser mostrados
 --%>
<%@ page import= "java.util.*, com.gueko.productos.*" %>    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <% 
    List <Productos> losPrductos = (List<Productos>) request.getAttribute("ListaProductos");
    %>
    <body>
        
        <%= losPrductos %>
       
    </body>
</html>
