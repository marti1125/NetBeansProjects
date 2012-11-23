<%-- 
    Document   : verSessiones
    Created on : 17-ene-2010, 22:58:15
    Author     : JORGE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="java.util.*,java.text.*" session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%
HttpSession sesion=request.getSession();
SimpleDateFormat fechita= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

out.println("IdSesion: "+sesion.getId());

// MOMENTO DE CREACION DE SESION
out.println("<br>Creacion: "+sesion.getCreationTime());
Date momento=new Date(sesion.getCreationTime());
out.println("<br>Creacion: "+fechita.format(momento));

// ULTIMO ACCESO DE SESION
Date acceso=new Date(sesion.getLastAccessedTime());
out.println("<br>\t\tUltimo acceso: "+fechita.format(acceso));

// SABER SI LA SESION ES NUEVA O VIENE DE UNA YA CREADA
out.println("<br>Nueva: "+sesion.isNew());

// CREAR ATRIBUTOS EN LA SESION
sesion.setAttribute("ultimo", acceso);

// OBTENER ATRIBUTOS DE LA SESION
out.println("<br>"+sesion.getAttribute("ultimo"));

// IDENTIFICAR SI EXISTE O NO ATRIBUTO DENTRO DE UNA SESION
if(sesion.getAttribute("ultimo") != null)
{
   out.println("<br>"+sesion.getAttribute("ultimo"));
}

// CANCELAR LA SESION
sesion.invalidate();
%>
    </body>
</html>
