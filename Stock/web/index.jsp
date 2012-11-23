<%-- 
    Document   : index
    Created on : 21/08/2010, 08:23:55 PM
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
        <title>:: STOCK ::</title>
                <style>
            h3, h4, p {
                text-align:center;
            }

            img {
                border: 0px;
            }

            table {
                margin: auto;
                width:500px;
            }
        </style>
    </head>
    <body style="color:#000066">
        <h3>Lista de Productos</h3>
     <%
        List qry = Sql.consulta("select * from producto");

        if (qry != null) {
            out.print("<table border=1>");
            out.print("<tr><th>Descripcion</th>");
            out.print("<th>Cantidad</th><th>Costo</th>");
            out.print("<th>Precio</th><th>Fecha de Ingreso</th>");
            out.print("<th>Retirar</th><th>Actualizar</th></tr>");

            for (int fil = 1; fil < qry.size(); ++fil) {
                Object[] fila = (Object[]) qry.get(fil);
                out.print("<tr>");
                for (int col = 1; col < fila.length; ++col) {
                    out.print("<th>" + fila[col] + "</th>");
                }
                out.print("<th><a href=jsp/delProducto.jsp?codigo=" + fila[0] + ">");
                out.print("<img src=images/del.gif></a></th>");
                out.print("<th><a href=jsp/updProducto.jsp?codigo=" + fila[0] + ">");
                out.print("<img src=images/upd.gif></a></th>");
                out.print("</tr>");
            }
            out.print("</table>");
            out.print("<p align=center><a href='jsp/insProducto.jsp'>");
            out.print("<img src=images/ins.gif align=middle>");
            out.print(" Nuevo Producto</a></p>");
        } else {%>
        <h4>No hay Productos</h4>
        <% }%>
    </body>
</html>
