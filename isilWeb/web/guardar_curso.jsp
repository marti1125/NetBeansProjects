<%-- 
    Document   : guardar_curso
    Created on : 21/04/2010, 08:12:38 PM
    Author     : Profesor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<% persistencia.Curso xcurso= new persistencia.Curso();
  xcurso.setCodCurso(request.getParameter("tcodigo"));
  xcurso.setNomCurso(request.getParameter("tnombre"));
  xcurso.setCredCurso(new Integer(request.getParameter("rcreditos")));
  xcurso.setHrsTeoria(new Integer(request.getParameter("tteoria")));
  xcurso.setHrsPract(new Integer(request.getParameter("tpractica")));
  xcurso.setHrsLab(new Integer(request.getParameter("tlab")));
  xcurso.setCiclo(new Integer(request.getParameter("lciclo")));
  xcurso.setTipoCurso(request.getParameter("rtipo"));
  boolean exito= controlar.insertar_curso(xcurso);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Resultado de la insercion</title>
        <style type="text/css">
<!--
.style1 {color: #990066}
.style2 {color: #330099}
body {
	background-image: url(fondos/background69.jpg);
}
-->
        </style>
</head>
    <body>
        <% if(exito){  %>
        <h1 align="center" class="style1">El curso fue almacenado correctamente </h1>
        <p align="center">&nbsp;</p>
        <p align="center"><img src="imagen/009.jpg" width="300" height="300"></p>
        <p align="left"><a href="ing_curso.jsp">regresar</a></p>
        <p align="left">&nbsp;</p>
        <% }else{  %>
        <h2 align="center" class="style2">Error en guardado de curso</h2>
        <h2 align="center" class="style2"><img src="imagen/plazalinuxinstall.gif" width="207" height="203"> </h2>
        <h2 align="center" class="style2">corregir errores y volver a intentar </h2>
        <p align="left" class="style2"><a href="ing_curso.jsp">reintentar</a></p>
   <% } %>
    </body>
</html>
