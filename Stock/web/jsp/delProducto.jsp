<%-- 
    Document   : delProducto
    Created on : 21/08/2010, 09:58:12 PM
    Author     : willy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.sql.Sql" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Retirar Producto ::</title>
    </head>
    <body>
        <%
        String codigo = request.getParameter("codigo");

        if (codigo == null) {
            String mensaje = "llegó nulo!";
            response.sendRedirect("mensaje.jsp?mensaje=" +
                    mensaje.replaceAll(" ", "+"));
        } else {
            Object[] prod = Sql.getFila("select descripcion, cantidad, costo, precio, fecing " +
                    "from producto where codigo=" + codigo);
        %>
        <h1>Retirar Producto</h1>
        <div style="text-align:center">
            <br/><br/><h3>¿Desea retirar producto?</h3>
            <form action="../ServletProducto" method="post">
                <input type="hidden" name="accion" value="DEL">
                <input type="hidden" name="codigo" value="<%=codigo%>" />
                <table align="center">
                    <tr>
                        <td align="left">Descripcion</td>
                        <td><input type="text" name="descripcion" value="<%=prod[0]%>"/></td>
                    </tr>
                    <tr>
                        <td align="left">Cantidad</td>
                        <td><input type="text" name="cantidad" value="<%=prod[1]%>"/></td>
                    </tr>
                    <tr>
                        <td align="left">Costo</td>
                        <td><input type="text" name="costo" value="<%=prod[2]%>"/></td>
                    </tr>
                    <tr>
                        <td align="left">Precio</td>
                        <td><input type="text" name="precio" value="<%=prod[3]%>"/></td>
                    </tr>
                    <tr>
                        <td align="left">Fecha de Ingreso</td>
                        <td><input type="text" name="fecing" value="<%=prod[4]%>"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Retirar Producto"/>
                        </td>
                    </tr>
                </table>
            </form>
            <br/>
            <A href="../index.jsp">Cancelar</A>
        </div>
        <%}%>
    </body>
</html>
