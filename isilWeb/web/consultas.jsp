<%-- 
    Document   : consultas
    Created on : 16/03/2010, 09:17:21 AM
    Author     : UNI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 <jsp:useBean id="accesos" scope="session" class="modelo.Perfil" />
 <% HttpSession zperfil= accesos.ver_perfil();   %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Consultas generales del sistema</title>
    <style type="text/css">
<!--
body {
	background-image: url(fondos/background36.jpg);
}
-->
</style></head>
    <body>
        <%  if(zperfil != null){ %>
        <table width="745" height="428" border="0">
          <tr>
            <td width="116"><table width="112" border="1">
              <tr>
                <th scope="col">Opciones</th>
              </tr>
              <tr>
                <td>Alumnos</td>
              </tr>
              <tr>
                <td><a href="lista_docentes.jsp?cod=x">Docentes</a></td>
              </tr>
              <tr>
                <td>Cursos</td>
              </tr>
              <tr>
                <td>Horarios</td>
              </tr>
              <tr>
                <td><a href="index.jsp">Regresar</a></td>
              </tr>
            </table></td>
            <td width="574"><table width="591" height="358" border="0">
              <tr>
                <td height="27">&nbsp;</td>
              </tr>
              <tr>
                <td height="302">
				<script src="http://www.gmodules.com/ig/ifr?url=http://hosting.gmodules.com/ig/gadgets/file/107121218028215781703/sm-maps.xml&amp;up_last_location=0&amp;synd=open&amp;w=320&amp;h=430&amp;title=Mapa+Google&amp;lang=es&amp;country=ALL&amp;border=%23ffffff%7C0px%2C1px+solid+%23595959%7C0px%2C1px+solid+%23797979%7C0px%2C2px+solid+%23898989&amp;output=js"></script>
				</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
        <% }else{ %>
        <jsp:forward page="error_acceso.jsp" />
        <%  } %>
    </body>
</html>
