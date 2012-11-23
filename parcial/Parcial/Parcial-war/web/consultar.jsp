<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Cliente</title>
    </head>
    <body>
        <h1>Consultar Clientes Por Apellido</h1>
        <form name="form1" method="post" action="Consultar">
            <p>
                <input name="consultar" type="submit" id="consultar" value="Consultar">
            </p>
            <table width="250" border="1">
                <tr>
                    <td>ID</td>
                    <td>Distrito</td>
                    <td>Nombre Cliente</td>
                    <td>Apellido Cliente</td>
                    <td>Ingresos</td>
                    <td>Edad</td>
                    <td>Sexo</td>
                </tr>
                <c:forEach items="${requestScope.lista}" var="item">
                    <tr>
                        <td>${item.CLI_ID}</td>
                        <td>${item.DIS_ID}</td>
                        <td>${item.CLI_NOMBRE}</td>
                        <td>${item.CLI_APELLIDO}</td>
                        <td>${item.CLI_INGRESOS}</td>
                        <td>${item.CLI_EDAD}</td>
                        <td>${item.CLI_SEXO}</td>
                      </tr>
                </c:forEach>
            </table>
        </form>
        <p>&nbsp;</p>
        <p style="color:red">${requestScope.error}</p>
    </body>
</html>
