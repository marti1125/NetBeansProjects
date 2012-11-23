<%-- 
    Document   : salir_sistema
    Created on : 25/03/2010, 09:58:11 AM
    Author     : UNI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 <jsp:useBean id="accesos" scope="session" class="modelo.Perfil" />
 <%  accesos.cerrar_sesion();  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Termino del programa</title>
        <style type="text/css">
<!--
.Estilo1 {color: #CC3333}
body {
	background-image: url(fondos/gray.gif);
}
-->
        </style>
</head>
    <body>
        <h2 align="center" class="Estilo1">Ha salido correctamente del sistema</h2>
        <h2 align="center" class="Estilo1"><img src="imagen/logo_univ.gif" width="255" height="169"> </h2>
        <h2 align="center" class="Estilo1">&nbsp;</h2>
        <h2 align="center" class="Estilo1">Hasta la proxima </h2>
    </body>
</html>
