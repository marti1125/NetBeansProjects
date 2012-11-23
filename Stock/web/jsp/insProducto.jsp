<%-- 
    Document   : insProducto
    Created on : 21/08/2010, 09:24:59 PM
    Author     : willy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Nuevo Producto ::</title>
    </head>
    <body>
        <h1>Nuevo Producto</h1>
        <form action="../ServletProducto" method="post">
            <input type="hidden" name="accion" value="INS"/>
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion"/></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad"/></td>
                </tr>
                <tr>
                    <td>Costo</td>
                    <td><input type="text" name="costo"/></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio"/></td>
                </tr>
                <tr>
                    <td>Fecha de Ingreso</td>
                    <td><input type="text" name="fecing"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Registrar"/>
                    </td> 
                </tr>
            </table>
        </form>
        <a href="../index.jsp">Volver</a>
    </body>
</html>
