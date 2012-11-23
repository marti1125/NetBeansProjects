<%-- 
    Document   : elim_profe
    Created on : 18/03/2010, 09:50:34 AM
    Author     : Alumno
--%>
<% String codigo= request.getParameter("c");   %>
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<% boolean exito= controlar.eliminar_docente(codigo); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Eliminacion de docente</title>
        <style type="text/css">
<!--
.Estilo1 {color: #993300}
body {
	background-image: url(fondos/CelticBib.gif);
}
-->
        </style>
</head>
    <body>
		 <% if(exito){  %>
        <h2 align="center" class="Estilo1">El docente ha sido eliminado del sistema</h2>
        <h2 align="center" class="Estilo1">&nbsp;</h2>
        <h2 align="center" class="Estilo1"><img src="imagen/252felixfoxusingcomputenj6.gif" width="253" height="252"> </h2>
        <h2 align="center" class="Estilo1">&nbsp;</h2>
        <h2 align="center" class="Estilo1">operacion completa </h2>
        <p align="left" class="Estilo1"><a href="consultas.jsp">regresar</a></p>
        <p align="left" class="Estilo1">&nbsp;</p>
		  <% }else{  %>
        <h2 align="center" class="Estilo1">Error en eliminacion de docente</h2>
        <h2 align="center" class="Estilo1"><img src="imagen/dog_durmiedno.gif" width="248" height="248"> </h2>
        <h2 align="center" class="Estilo1">regresar e intentar de nuevo </h2>
        <p align="left" class="Estilo1"><a href="lista_docentes.jsp">reintentar</a></p>
        <% } %>
	 </body>
</html>
