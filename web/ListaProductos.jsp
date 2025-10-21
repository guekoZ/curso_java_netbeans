<%-- 
Este video se explica en el video 252
  Este es el archivo que contiene la vista y recibe los datos de las demas clases para ser mostrados

En el video 254 cambia un poco el codigo para darle formato a la tabla que presenta los datos y se utilizan jsp Tags
--%>

<%-- Este codigo se utilizo en el viedo 253 pero se comento utilizar tags 
<%@ page import= "java.util.*, com.gueko.productos.*" %>   ---%> 


<%-- -------------------Este la el codigo que se debe agregar para utilizar la jsp tags----------------------- --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style  type="text/css">
            
            .cabecera{
                font-size: 1.2em;
                font-weight: bold;
                color: #ffffff;
                background-color: #08088a;
                
            }
            
            .filas{
                
                 text-align: center;
                 background: #5882fa; 
            }
            
            tabla{
                float: left;
            }
            
            #contenedorBoton{
                margin-left: 1000px;
            }
            
        </style>
    </head>
    
    
    <%--
Este codigo se utiliza en el video 253 y se cambio jsp tags
    <%
        List<Productos> losProductos = (List<Productos>) request.getAttribute("ListaProductos");
    %>
    
    --%>
    <body>

        <table>

            <tr>
                <td class="cabecera">Codigo Articulo</td>
                <td class="cabecera">Seccion</td>
                <td class="cabecera">Nombre de Articulo</td>
                <td class="cabecera">Precio</td>
                <td class="cabecera">Fecha</td>
                <td class="cabecera">Importado</td>
                <td class="cabecera">Pais de Origen</td>
                <td class="cabecera">Acción</td>

            </tr>  
            <c:forEach var="tempProd" items="${ListaProductos}" >
                
                
                <%-- Link para enviar la clave de cada producto al Servlet ControlProductos--%>
                
                <c:url var="linkTemp" value="ControlProductos">
                    
                    <c:param name="instruccion" value="cargar"> </c:param>
                    <c:param name="CArticulo" value="${tempProd.cArt}"> </c:param>
                    
                </c:url>
                
                 <%-- Link para la clave del producto al Servlet ControlProductos--%>
                 
                
                <c:url var="linkTempEliminar" value="ControlProductos">
                    
                    <c:param name="instruccion" value="eliminar"> </c:param>
                    <c:param name="CArticulo" value="${tempProd.cArt}"> </c:param>
                    
                </c:url>
            
            <tr>
                <td class="filas">${tempProd.cArt}</td>
                <td class="filas">${tempProd.seccion}</td>
                <td class="filas">${tempProd.nArt}</td>
                <td class="filas">${tempProd.precio}</td>
                <td class="filas">${tempProd.fecha}</td>
                <td class="filas">${tempProd.importado}</td>
                <td class="filas">${tempProd.pOrig}</td>
                <td class="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;&nbsp;&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>
            </tr>
           </c:forEach>
        </table>
        <div id="contenedorBoton">
            
            <input type="button" value="Insertar Registro" onclick="window.location.href='insertar_producto.jsp'">
                         
        </div>
        
        

    </body>
</html>
