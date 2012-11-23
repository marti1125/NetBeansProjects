<%-- 
    Document   : buscar_docente
    Created on : 16/03/2010, 11:10:07 AM
    Author     : UNI
--%>
<% String cdocente= request.getParameter("ldocente"); %>
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<% persistencia.Profesor profe= controlar.datos_profesor(cdocente); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%  String pagina="lista_docentes.jsp?cod="+profe.getCodProf()+"&ape="+
        profe.apellidos()+"&nom="+profe.getNomProf()+"&fnc="+
        profe.fecha_nac()+"&dni="+profe.getDniProf()+"&ing="+profe.getAnuIngr()+
        "&esp="+profe.getEspecialidad();
%>
<jsp:forward page="<%= pagina  %>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
