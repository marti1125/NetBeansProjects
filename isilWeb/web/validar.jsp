<%-- 
    Document   : validar
    Created on : 11/03/2010, 09:30:29 AM
    Author     : Alumno
--%>
<%   String xusuario= request.getParameter("tusuario");
     String xclave= request.getParameter("tclave");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<%  String nombre= controlar.recoger_nombre(xusuario,xclave); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Resultado de la validacion</title>
        <style type="text/css">
<!--
.Estilo1 {color: #990000}
.Estilo2 {color: #663333; }
body {
	background-image: url(fondos/fondo_55.jpg);
}
-->
        </style>
</head>
    <body>
        <%  if(nombre.equals("x")){  %>
        <h2 align="center" class="Estilo1">Error en usuario o clave</h2>
        <h2 align="center" class="Estilo1">&nbsp;</h2>
        <h2 align="center" class="Estilo1"><img src="imagen/cabreo.gif" width="208" height="162"> </h2>
        <h2 align="center" class="Estilo1">regresar e intentar de nuevo </h2>
        <p align="left" class="Estilo1"><a href="index.jsp">reintentar</a></p>
        <p align="left" class="Estilo1">&nbsp;</p>
        <% }else{  %>
        <h2 align="center" class="Estilo2">Bienvenido <%= nombre  %></h2>
        <h2 align="center" class="Estilo2">al Sistema de Gestion Academica</h2>
        <h2 align="center" class="Estilo2"><img src="imagen/garf0012.gif" width="195" height="220">  </h2>
        <h2 align="center" class="Estilo2">las opciones se encuentran activadas para su uso</h2>
        <p align="left" class="Estilo1">&nbsp;</p>
        <p align="left" class="Estilo1"><a href="index.jsp">regresar </a></p>
        <jsp:useBean id="accesos" scope="session" class="modelo.Perfil" />
        <% HttpSession usuario= request.getSession();
           accesos.guardar_perfil(usuario);
           accesos.guardar_nombre(nombre);
        }  %>
    </body>
</html>
