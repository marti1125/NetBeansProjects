<%-- 
    Document   : guardar_carrito
    Created on : 23/03/2010, 11:27:38 AM
    Author     : UNI
--%>
<%  String semestre= request.getParameter("hsemestre");
String ccurso= request.getParameter("lcurso");
int grupo= Integer.parseInt(request.getParameter("rgrupo"));
String cdocente= request.getParameter("ldocente");
String caula= request.getParameter("laula");
String horario= request.getParameter("thorario");
int vacantes= Integer.parseInt(request.getParameter("tvacantes"));
%>
<jsp:useBean id="cursote" scope="page" class="modelo.Cursoprog" />
<% cursote.setCodaula(caula);
   cursote.setCodcurso(ccurso);
   cursote.setCodprof(cdocente);
   cursote.setGrupo(grupo);
   cursote.setHorario(horario);
   cursote.setSemestre(semestre);
   cursote.setVacantes(vacantes);
   cursote.completar();
%>
<jsp:useBean id="bolsita" scope="session" class="modelo.Carrito" />
<% bolsita.agregar(cursote);   %>
<jsp:forward page="programacion.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
