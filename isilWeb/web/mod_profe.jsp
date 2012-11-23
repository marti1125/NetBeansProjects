<%-- 
    Document   : mod_profe
    Created on : 18/03/2010, 10:42:40 AM
    Author     : Alumno
--%>
<% String codigo= request.getParameter("c");   %>
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<% persistencia.Profesor profe= controlar.datos_profesor(codigo); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Actualizacion de datos - Profesor</title>
        <style type="text/css">
<!--
.Estilo1 {color: #990000}
body {
	background-image: url(fondos/fondo_73.gif);
}
.Estilo2 {color: #FF3333}
-->
        </style>
</head>
    <body>
        <h2 class="Estilo1">Modificacion de datos </h2>
        <form name="form1" method="post" action="guardar_cambios_prof.jsp">
          <div align="center">
          <table width="534" border="1">
            <tr>
              <th width="97" scope="row"><div align="left" class="Estilo2">Codigo:</div></th>
              <td width="421"><%= profe.getCodProf()  %>
              <input name="hcodigo" type="hidden" id="hcodigo" value="<%= profe.getCodProf()  %>"></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">Ap. Paterno: </div></th>
              <td><label>
                <input name="tpaterno" type="text" id="tpaterno" value="<%= profe.getPatProf()  %>">
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">Ap. Materno: </div></th>
              <td><label>
                <input name="tmaterno" type="text" id="tmaterno" value="<%= profe.getMatProf()  %>">
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">Nombres:</div></th>
              <td><label>
                <input name="tnombres" type="text" id="tnombres" value="<%= profe.getNomProf()  %>">
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">Fec. Nacimiento: </div></th>
              <td><label>
                <input name="tfnac" type="text" id="tfnac" value="<%= profe.fecha_nac()  %>" size="12">
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">DNI:</div></th>
              <td><label>
                <input name="tdni" type="text" id="tdni" value="<%= profe.getDniProf()  %>" size="10">
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">Año de ingreso: </div></th>
              <td><label></label>
                <table width="353" border="0">
                  <tr>
                    <td width="70"><%= profe.getAnuIngr()  %>
                    <input name="hingreso" type="hidden" id="hingreso" value="<%= profe.getAnuIngr()  %>"></td>
                    <td width="167"><label>
                      <select name="lingreso" size="1" id="lingreso">
                        <option value="2000">2000</option>
                        <option value="2001">2001</option>
                        <option value="2002">2002</option>
                        <option value="2003">2003</option>
                        <option value="2004">2004</option>
                        <option value="2005">2005</option>
                        <option value="2006">2006</option>
                        <option value="2007">2007</option>
                        <option value="2008">2008</option>
                        <option value="2009">2009</option>
                        </select>
                    </label></td>
                    <td width="102"><label>
                      <input name="cbingreso" type="checkbox" id="cbingreso" value="m">
                    modificar</label></td>
                  </tr>
                </table></td>
            </tr>
            <tr>
              <th scope="row"><div align="left" class="Estilo2">Especialidad:</div></th>
              <td><label></label>
                <table width="413" border="0">
                  <tr>
                    <td width="153"><%= profe.getEspecialidad()  %>
                    <input name="hcarrera" type="hidden" id="hcarrera" value="<%= profe.getEspecialidad()  %>"></td>
                    <td width="160"><label>
                      <select name="lcarrera" size="1" id="lcarrera">
                        <option value="Lic. en Computacion">Lic. en Computacion</option>
                        <option value="Ing. de Sistemas">Ing. de Sistemas</option>
                        <option value="Ing. Electronico">Ing. Electronico</option>
                        <option value="Matematico">Matematico</option>
                        <option value="Contador">Contador</option>
                        </select>
                    </label></td>
                    <td width="86"><label>
                      <input name="cbcarrera" type="checkbox" id="cbcarrera" value="m">
                    modificar</label></td>
                  </tr>
                </table></td>
            </tr>
                    </table>
          <p>
            <label>
            <input type="submit" name="Submit" value="actualizar">
            </label>
          </p>
          </div>
        </form>
        <p class="Estilo1">&nbsp;</p>
    </body>
</html>
