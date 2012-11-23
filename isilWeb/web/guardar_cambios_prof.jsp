<%-- 
    Document   : guardar_cambios_prof
    Created on : 18/03/2010, 11:39:04 AM
    Author     : Administrador
--%>

<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<% persistencia.Profesor docente = new persistencia.Profesor();
   docente.setCodProf(request.getParameter("hcodigo"));
   docente.setPatProf(request.getParameter("tpaterno"));
   docente.setMatProf(request.getParameter("tmaterno"));
   docente.setNomProf(request.getParameter("tnombres"));
   docente.setFnacProf(new java.util.Date(request.getParameter("tfnac")));
   docente.setDniProf(request.getParameter("tdni"));
   String opcion1 = request.getParameter("cbingreso");
   if(opcion1 != null){
       docente.setAnuIngr(Integer.parseInt(request.getParameter("lingreso")));
   }else{
       docente.setAnuIngr(Integer.parseInt(request.getParameter("hingreso")));
   }
   String opcion2 = request.getParameter("cbcarrera");
   if(opcion2 != null){
       docente.setEspecialidad(request.getParameter("lcarrera"));
   }else{
       docente.setEspecialidad(request.getParameter("hcarrera"));
   }      
   %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%  boolean exito= controlar.actualizar_docente(docente);  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Resultado de la actualizacion</title>
        <style type="text/css">
<!--
.Estilo1 {color: #993300}
body {
	background-image: url(fondos/background36.jpg);
}
-->
        </style>
</head>
    <body>
        <% if(exito){  %>
    <h2 align="center" class="Estilo1">Los datos del docente han sido actualizados </h2>
        <h2 align="center" class="Estilo1">&nbsp;</h2>
        <h2 align="center" class="Estilo1"><img src="imagen/252felixfoxusingcomputenj6.gif" width="253" height="252"> </h2>
        <h2 align="center" class="Estilo1">&nbsp;</h2>
        <h2 align="center" class="Estilo1">operacion completa </h2>
        <p align="left" class="Estilo1"><a href="consultas.jsp">regresar</a></p>
        <p align="left" class="Estilo1">&nbsp;</p>
        <% }else{  %>
        <h2 align="center" class="Estilo1">Error en modificacion de datos</h2>
        <h2 align="center" class="Estilo1"><img src="imagen/dog_durmiedno.gif" width="248" height="248"> </h2>
        <h2 align="center" class="Estilo1">regresar e intentar de nuevo </h2>
        <p align="left" class="Estilo1"><a href="lista_docentes.jsp">reintentar</a></p>
    <% }  %>
    </body>
</html>
