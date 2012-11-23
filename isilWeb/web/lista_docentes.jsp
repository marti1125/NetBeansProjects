<%-- 
    Document   : lista_docentes
    Created on : 16/03/2010, 09:37:30 AM
    Author     : UNI
--%>
<% String cod= request.getParameter("cod");
   String ape= request.getParameter("ape");
	String nom= request.getParameter("nom");
	String fnc= request.getParameter("fnc");
	String dni= request.getParameter("dni");
	String ing= request.getParameter("ing");
	String esp= request.getParameter("esp");
%>

<jsp:useBean id="controlar" scope="page" class="modelo.Controlador" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% java.util.List listado= controlar.relacion_profes();  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Consulta de datos - Docentes</title>
        <style type="text/css">
<!--
.Estilo1 {color: #990000}
body {
	background-image: url(fondos/CelticBib.gif);
}
-->
        </style>
</head>
    <body>
        <table width="726" height="396" border="0">
          <tr>
            <td height="105"><form name="form1" method="post" action="buscar_docente.jsp">
               <p align="center">&nbsp;</p>
               <p align="center"><span class="Estilo1"><strong>Escoger docente: 
                     <label>                   </label>
               </strong>
                 <label></label>
               </span>
                 <label><select name="ldocente" size="1" id="ldocente">
                         <% for (Object profe : listado) {
                          persistencia.Profesor doc1= (persistencia.Profesor)profe;
                         %>
                   <option value="<%= doc1.getCodProf() %>"><%= doc1.nombre_completo() %></option>
                   <% } %>
                     </select>
                 </label>
               </p>
               <p align="center">&nbsp;</p>
               <p align="center">
                 <label>
                 <input type="submit" name="Submit" value="consultar">
                 </label>
               </p>
               <p>&nbsp;</p>
               <p><a href="consultas.jsp">regresar               </a></p>
            </form>
            </td>
          </tr>
          <tr>
            <td height="169">

					<% if(!cod.equals("x")){
					 String pagina="mostrar_docente.jsp?cod="+cod+"&ape="+ape+"&nom="+nom+"&fnc="+
        fnc+"&dni="+dni+"&ing="+ing+"&esp="+esp;
%>
                <jsp:include page="<%= pagina %>" />
					 <%  } %>
            </td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
    </body>
</html>
