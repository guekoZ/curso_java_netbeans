<%-- 
  Este codigo esta explicado en el video 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualizar Producto</h1>    

        <form name="form1" method="get" action="ControlProductos">
            
            <input type="hidden" name="instruccion" value="actualizarBBDD">
            <input type="hidden" name="CArt" value="${ProductoActualizar.cArt}">
            

            <table border="0" >
                 <tbody>
                    <tr>
                        <td>Sección</td>
                        <td><input type="text" name="seccion" value="${ProductoActualizar.seccion}" id="seccion" /></td>
                    </tr>
                    <tr>
                       <td>Nombre Articulo</td>
                       <td><input type="text" name="NArt" value="${ProductoActualizar.nArt}" id="NArt" /></td>
                    </tr>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="text" name="fecha" value="${ProductoActualizar.fecha}" id="fecha" /></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="precio" value="${ProductoActualizar.precio}" id="precio" /></td>
                    </tr>
                    <tr>
                        <td>Importado</td>
                        <td><input type="text" name="importado" value="${ProductoActualizar.importado}" id="importado" /></td>
                    </tr>
                    <tr>
                        <td>Pais de Origen</td>
                        <td><input type="text" name="POrigen" value="${ProductoActualizar.pOrig}" id="POrigen" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Enviar" /></td>
                        <td><input type="reset" value="Restablecer" /></td>
                    </tr>
                    
                </tbody>
            </table>



        </form>


    </body>
</html>
