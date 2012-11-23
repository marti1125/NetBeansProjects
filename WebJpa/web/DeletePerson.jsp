<%-- 
    Document   : DeletePerson
    Created on : 02/08/2010, 09:33:15 PM
    Author     : willy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete a Person record</title>
    </head>
    <body>
        <h1>Delete a Person record</h1>
    <form id="DeletePersonForm" action="DeletePersonServlet" method="post">
    <table>
        <tr><td>ID:</td><td><input type="text" id = "id" name="id" /></td></tr>
    </table>
    <input type="submit" id="DeleteRecord" value="DeleteRecord" />
    </form>
<a href="ListPerson"><strong>Go to List of persons</strong></a>
    </body>
</html>
