<%-- 
    Document   : ing_curso
    Created on : 21/04/2010, 07:05:13 PM
    Author     : Profesor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<% java.util.Vector<String[]> ciclos= controlar.lista_ciclos(); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Ingreso de nuevos cursos</title>
        <style type="text/css">
<!--
.style1 {color: #990066}
body {
	background-image: url(fondos/fondo_55.jpg);
}
-->
        </style>
</head>
    <body>
        <form name="form1" method="post" action="guardar_curso.jsp">
          <table width="326" height="315" border="0" align="center">
            <tr>
              <td height="274"><table width="309" border="1" align="center">
                <tr>
                  <th width="105" scope="row"><div align="left" class="style1">Codigo:</div></th>
                  <td width="188"><label>
                    <input name="tcodigo" type="text" id="tcodigo" size="10">
                  </label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">Nombre:</div></th>
                  <td><label>
                    <input name="tnombre" type="text" id="tnombre" size="30">
                  </label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">Creditos:</div></th>
                  <td><label>
                    <input name="rcreditos" type="radio" value="1" checked>
                  1
                  <input name="rcreditos" type="radio" value="2">
                  2
                  <input name="rcreditos" type="radio" value="3">
                  3</label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">H.Teoria:</div></th>
                  <td><label>
                    <input name="tteoria" type="text" id="tteoria" size="5">
                  </label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">H. Practica: </div></th>
                  <td><label>
                    <input name="tpractica" type="text" id="tpractica" size="5">
                  </label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">H. Laboratorio: </div></th>
                  <td><label>
                    <input name="tlab" type="text" id="tlab" size="5">
                  </label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">Ciclo:</div></th>
                  <td><label>
                    <select name="lciclo" size="1" id="lciclo">
                        <% for (String[] iciclo : ciclos) {
                        %>
                      <option value="<%= iciclo[0] %>"><%= iciclo[1] %></option>
                      <% } %>
                      </select>
                  </label></td>
                </tr>
                <tr>
                  <th scope="row"><div align="left" class="style1">Tipo:</div></th>
                  <td><label>
                    <input name="rtipo" type="radio" value="1" checked>
                  Obligatorio 
                  <input name="rtipo" type="radio" value="2">
                  Electivo</label></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td><label>
                <div align="center">
                <input type="submit" name="Submit" value="guardar">
                </div>
              </label></td>
            </tr>
          </table>
    </form>
        <h1>&nbsp;</h1>
    </body>
</html>
