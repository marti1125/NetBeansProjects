<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <style>
            h3, p {
                text-align:center;
            }
        </style>
    </head>
    <body>
        <h3>Mensaje</h3>

        <p style="color:#721B15">
            <%=session.getAttribute("msg")%>
        </p>

        <p>
            <a href="../index.jsp">Home</a>
        </p>
    </body>
</html>


