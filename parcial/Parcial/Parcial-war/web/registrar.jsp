<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Registrar Cliente</title>
    </head>

    <body>
        <h1>Registrar Cliente</h1>
        <p>&nbsp;</p>
        <form id="form1" name="form1" method="post" action="registrarCliente">
            <table width="250" border="0">

                 <tr>
                    <td>Distritos</td>
                    <td><select name="Distrito" id="Distrito">
                            <option>ATE</option>
                            <option>SAN BORJA</option>
                            <option>SAN ISIDRO</option>
                            <option>MIRAFLORES</option>
                            <option>LA VICTORIA</option>
                            <option>VILLA MARIA</option>
                            <option>VILLA EL SALVADOR</option>
                            <option>SURCO</option>
                            <option>SURQUILLO</option>
                            <option>MAGDALENA</option>
                    </select>      </td>
                </tr>
                
                <tr>
                    <td>Nombre Cliente</td>
                    <td><input name="Nombre Cliente" type="text" id="Nombre Cliente" /></td>
                </tr>
                <tr>
                    <td>Apellido Cliente</td>
                    <td><input name="Apellido Cliente" type="text" id="Apellido Cliente" /></td>
                </tr>
                <tr>
                    <td>Ingresos</td>
                    <td><input name="Ingresos" type="text" id="Ingresos" /></td>
                </tr>
                <tr>
                    <td>Edad</td>
                    <td><input name="Edad" type="text" id="Edad" /></td>
                </tr>
                <tr>
                    <td>Sexo</td>
                    <td><input name="Sexo" type="text" id="Sexo" /></td>
                </tr>

                <tr>
                    <td colspan="2"><input name="registrar" type="submit" id="registrar" value="Registrar" /></td>
                </tr>
            </table>
        </form>
        <p>${requestScope.mensaje}</p>
        <p style="color:red">${requestScope.error}</p>
    </body>
</html>
