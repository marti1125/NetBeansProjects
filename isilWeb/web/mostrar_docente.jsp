<%-- 
    Document   : mostrar_docente
    Created on : 16/03/2010, 09:48:19 AM
    Author     : UNI
--%>
<% String cod= request.getParameter("cod");
   String ape= request.getParameter("ape");
	String nom= request.getParameter("nom");
	String fnc= request.getParameter("fnc");
	String dni= request.getParameter("dni");
	String ing= request.getParameter("ing");
	String esp= request.getParameter("esp");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style type="text/css">
<!--
.Estilo1 {color: #990066}
.Estilo2 {color: #3366CC}
-->
        </style>
</head>
    <body>
        <h2 class="Estilo1">Datos del docente consultado </h2>
        <table width="952" border="1">
          <tr>
            <th width="54" scope="col"><span class="Estilo2">Codigo</span></th>
            <th width="142" scope="col"><span class="Estilo2">Apellidos</span></th>
            <th width="145" scope="col"><span class="Estilo2"> Nombres </span></th>
            <th width="65" scope="col"><span class="Estilo2">Fec. Nac. </span></th>
            <th width="70" scope="col"><span class="Estilo2">DNI</span></th>
            <th width="70" scope="col"><span class="Estilo2">Año ingreso </span></th>
            <th width="152" scope="col"><span class="Estilo2">Especialidad</span></th>
            <th width="202" scope="col"><span class="Estilo2"></span></th>
          </tr>
          <tr>
				 <td><%= cod  %></td>
            <td><%= ape  %></td>
            <td><%= nom  %></td>
            <td><%= fnc  %></td>
            <td><%= dni  %></td>
            <td><%= ing  %></td>
            <td><%= esp  %></td>
            <td><table width="200" border="0">
              <tr>
                <td><a href="mod_profe.jsp?c=<%= cod  %>">modificar</a></td>
                <td><div align="right"><a href="elim_profe.jsp?c=<%= cod  %>">eliminar</a></div></td>
              </tr>
            </table></td>
          </tr>
        </table>
        <p class="Estilo1">&nbsp;</p>
    </body>
</html>
