<%-- 
    Este archivo se explica y se utiliza en el video 248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:forEach  var="tempProductos" items="${lista_productos}">
            
            ${tempProductos};<br><!-- Se imprimen los datos que mandaron del servlet -->
            
        </c:forEach>
        
    </body>
</html>
