<%-- 
    Document   : mostrar_carrito
    Created on : 23/03/2010, 09:46:40 AM
    Author     : UNI
--%>
<jsp:useBean id="bolsita" scope="session" class="modelo.Carrito" />
<% java.util.LinkedList<modelo.Cursoprog> listado=   bolsita.descargar(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
<!--
.Estilo1 {color: #990033}
.Estilo2 {color: #996600}
.Estilo3 {
	color: #FF0000;
	font-weight: bold;
}
-->
        </style>
</head>
    <body>
        <h1>&nbsp;</h1>
        <h2 class="Estilo1">Datos de los cursos programados </h2>
        <table width="1015" height="77" border="1">
          <tr>
            <th width="241" height="40" scope="col"><span class="Estilo2">Curso</span></th>
            <th width="48" scope="col"><span class="Estilo2">Grupo</span></th>
            <th width="345" scope="col"><span class="Estilo2">Profesor</span></th>
            <th width="57" scope="col"><span class="Estilo2">Aula</span></th>
            <th width="218" scope="col"><span class="Estilo2">Horario</span></th>
            <th width="66" scope="col"><span class="Estilo2">Vacantes</span></th>
          </tr>
          <%  for (modelo.Cursoprog cprog : listado) { %>
          <tr>
              <td height="29"><%= cprog.getNomcurso() %></td>
            <td><%= cprog.getGrupo() %></td>
            <td><%= cprog.getNomprof() %></td>
            <td><%= cprog.getCodaula() %></td>
            <td><%= cprog.getHorario() %></td>
            <td><%= cprog.getVacantes() %></td>
          </tr>
          <% }  %>
        </table>
        <table width="1012" height="30" border="0">
          <tr>
            <td width="826">&nbsp;</td>
            <td width="176"><span class="Estilo3">Total de cursos: <%= listado.size() %> </span></td>
          </tr>
        </table>
        <p class="Estilo1">&nbsp;</p>
        <p class="Estilo1">&nbsp;</p>
        <p class="Estilo1">&nbsp;</p>
        <p class="Estilo1"><a href="index.jsp">regresar</a></p>
    </body>
</html>
