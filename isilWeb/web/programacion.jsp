<%-- 
    Document   : programacion
    Created on : 23/03/2010, 09:30:23 AM
    Author     : UNI
--%>
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="accesos" scope="session" class="modelo.Perfil" />
 <% HttpSession zperfil= accesos.ver_perfil();   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% String nsemestre= controlar.ver_semestre_actual();
  java.util.Vector<persistencia.Curso> cursos= controlar.relacion_cursos();
  java.util.List docentes= controlar.relacion_docentes();
  java.util.ArrayList aulas= controlar.relacion_aulas();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Programacion de cursos</title>
        <style type="text/css">
<!--
.Estilo1 {color: #000099}
body {
	background-image: url(fondos/fondo_56.gif);
}
-->
        </style>
</head>
    <body>
          <%  if(zperfil != null){ %>
        <table width="759" height="541" border="0">
          <tr>
            <td height="285"><form name="form1" method="post" action="guardar_carrito.jsp">
              <table width="743" height="245" border="0">
                <tr>
                  <td width="286"><span class="Estilo1"></span></td>
                  <td width="179"><span class="Estilo1"><strong>Semestre: <%= nsemestre %>
                    <input name="hsemestre" type="hidden" id="hsemestre" value="<%= nsemestre %>">
                  </strong></span></td>
                  <td width="264"><span class="Estilo1"></span></td>
                </tr>
                <tr>
                  <td><span class="Estilo1"><strong>Curso: 
                    <label>
                    <select name="lcurso" size="1" id="lcurso">
                        <% for (persistencia.Curso xcurso : cursos) {  %>
                      <option value="<%= xcurso.getCodCurso() %>"><%= xcurso.getNomCurso() %></option>
                      <%  }  %>
                    </select>
                    </label>
                  </strong></span></td>
                  <td><span class="Estilo1"></span></td>
                  <td><span class="Estilo1"><strong>Grupo:
                    <label>
                    <input name="rgrupo" type="radio" value="1">
                    1</label>
                    <label>
                    <input name="rgrupo" type="radio" value="2">
                    2</label>
                    <label>
                    <input name="rgrupo" type="radio" value="3">
                    3</label>
                  </strong></span></td>
                </tr>
                <tr>
                  <td><span class="Estilo1"><strong>Profesor:
                    <label>
                    <select name="ldocente" size="1" id="ldocente">
                        <%  for (Object doc1 : docentes) {
                           persistencia.Profesor xprof= (persistencia.Profesor)doc1;       
                       %>
                      <option value="<%= xprof.getCodProf()  %>"><%= xprof.nombre_completo()  %></option>
                    <% } %>
                    </select>
                    </label>
                  </strong></span></td>
                  <td><span class="Estilo1"></span></td>
                  <td><span class="Estilo1"><strong>Aula:
                    <label>
                    <select name="laula" size="1" id="laula">
                         <%  for (Object doc1 : aulas) {
                           persistencia.Aula xaula= (persistencia.Aula)doc1;
                       %>
                      <option value="<%= xaula.getCodAula() %>"><%= xaula.getCodAula() %></option>
                      <%  } %>
                    </select>
                    </label>
                  </strong></span></td>
                </tr>
                <tr>
                  <td><span class="Estilo1"><strong>Horario:
                    <label>
                    <input name="thorario" type="text" id="thorario">
                    </label>
                  </strong></span></td>
                  <td><span class="Estilo1"></span></td>
                  <td><span class="Estilo1"><strong>Vacantes:
                    <label>
                    <input name="tvacantes" type="text" id="tvacantes" size="7">
                    </label>
                  </strong></span></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td><label>
                    <div align="center">
                    <input type="submit" name="Submit" value="Enviar">
                    </div>
                  </label></td>
                  <td>&nbsp;</td>
                </tr>
              </table>
                        </form>
            </td>
          </tr>
          <tr>
            <td>
                <%@include  file="mostrar_carrito.jsp" %>
            </td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
         <% }else{ %>
        <jsp:forward page="error_acceso.jsp" />
        <%  } %>
    </body>
</html>
