<%-- 
    Document   : index
    Created on : 09/03/2010, 10:08:12 AM
    Author     : UNI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%! int visita=0;  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Sistema de Gestion Academica</title>
        <style type="text/css">
<!--
.Estilo1 {
	color: #993333;
	font-weight: bold;
}
.Estilo2 {
	color: #993300;
	font-weight: bold;
}
.Estilo3 {color: #990000}
.Estilo4 {
	color: #990033;
	font-weight: bold;
}
.Estilo5 {color: #FF0033}
body {
	background-image: url(fondos/fondo_37.jpg);
}
.style1 {color: #990000; font-weight: bold; }
-->
        </style>
</head>
<%  visita++;
   Calendar hoy=  Calendar.getInstance();
	SimpleDateFormat fechita= new SimpleDateFormat("dd/MM/yyyy");
%>
    <body>
        <table width="747" height="588" border="0">
          <tr>
            <td width="108" height="125"><img src="imagen/banner_top_acerca.jpg" width="726" height="182"></td>
          </tr>
          <tr>
            <td height="431"><table width="735" height="447" border="0">
              <tr>
                <td width="111" height="426"><table width="104" height="390" border="0">
                  <tr>
                    <td height="156"><table width="120" border="1">
                      <tr>
                        <td width="110"><span class="Estilo1">Servicios</span></td>
                      </tr>
                      <tr>
                        <td><a href="consultas.jsp">Consultas</a></td>
                      </tr>
                      <tr>
                        <td><a href="programacion.jsp">Programacion</a> </td>
                      </tr>
                      <tr>
                        <td>Matricula</td>
                      </tr>
                      <tr>
                        <td><a href="ing_curso.jsp">Reportes</a></td>
                      </tr>
                      <tr>
                        <td><a href="salir_sistema.jsp">Salir</a></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><table width="120" border="1">
                      <tr>
                        <td width="110"><span class="Estilo2">Externos</span></td>
                      </tr>
                      <tr>
                        <td><a href="http://www.google.com.pe">Google</a></td>
                      </tr>
                      <tr>
                        <td><a href="http://www.elcomercio.pe">El Comercio </a></td>
                      </tr>
                      <tr>
                        <td><a href="http://www.yahoo.com">Yahoo</a></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
                <td width="614"><table width="593" height="434" border="0">
                  <tr>
                    <td width="292"><table width="288" height="435" border="0">
                      <tr>
                        <td height="233"><p align="justify" class="Estilo3"><strong>Vision</strong></p>
                          <p align="justify" class="Estilo3">Ser el modelo educativo, alternativo e innovador en la formación de profesionales de éxito</p>
                          <p align="justify" class="style1">Mision</p>
                          <p align="justify" class="Estilo3">La experiencia ISIL es la de una Institución que brinda conocimientos, competencias y valores propios de una educación de avanzada, congruente con el mercado mediante el desarrollo de la creatividad, la tecnología el éxito empresarial y la educación para el trabajo.</p>
                          </td>
                      </tr>
                      <tr>
                        <td height="196"><table width="282" height="193" border="0">
                          <tr>
                            <td height="128"><div align="center">
                              <p><img src="imagen/logo_isil_horizontal.gif" width="211" height="56"></p>
                              <p>&nbsp;</p>
                            </div></td>
                          </tr>
                          <tr>
									  <td><p class="Estilo5"><strong>Numero de visitante: <%= visita %></strong></p>
										  <p class="Estilo5"><strong>Fecha de visita: <%= fechita.format(hoy.getTime())  %> </strong></p></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                    <td width="291"><table width="297" height="412" border="0">
                      <tr>
                        <td width="291" height="168"><form name="form1" method="post" action="validar.jsp">
                          <p align="center" class="Estilo4">Ingreso al Sistema</p>
                          <p align="center"><strong>Usuario</strong>: 
                            <label>
                            <input name="tusuario" type="text" id="tusuario" size="10">
                            </label>
</p>
                          <p align="center"><strong>Clave</strong>: 
                            <label>
                            <input name="tclave" type="password" id="tclave" size="10">
                            </label>
                          </p>
                          <p align="center">
                            <label>
                            <input type="submit" name="Submit" value="ingresar">
                            </label>
                          </p>
                        </form>
                        </td>
                      </tr>
                      <tr>
                        <td><script src="http://www.gmodules.com/ig/ifr?url=http://portal.jmcweb.org/gadgetreloj/reloj.xml&amp;synd=open&amp;w=280&amp;h=100&amp;title=Hora+de+Ingreso&amp;border=%23ffffff%7C0px%2C1px+solid+%23993333%7C0px%2C1px+solid+%23bb5555%7C0px%2C1px+solid+%23DD7777%7C0px%2C2px+solid+%23EE8888&amp;output=js"></script>
						</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
    </body>
</html>
