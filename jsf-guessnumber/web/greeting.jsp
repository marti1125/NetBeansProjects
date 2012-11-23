<%-- 
    Document   : greeting
    Created on : 13/09/2010, 12:02:01 AM
    Author     : willy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title></head>
        <%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
        <%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>    
    <body bgcolor="white">
        <f:view>
            <h:form>
                <h2>
                    Hi. My name is Duke.  I'm thinking of a number from
                    <h:outputText value="#{UserNumberBean.minimum}"/> to
                    <h:outputText value="#{UserNumberBean.maximum}"/>, Can you guess it?
                </h2>
                    <h:graphicImage id="waveImg" url="/wave.med.gif"/>
                    <h:inputText id="userNo" value="#{UserNumberBean.userNumber}"
                                 validator="#{UserNumberBean.validate}"/>
                    <h:commandButton id="submit" action="success" value="submit"/>
                    <p>
                    <h:message style="color: red; font-family: 'New Century Schoolbook', serif; font-style: oblique; text-decoration: overline" id="errors1" for="userNo"/>
            </h:form>
        </f:view>
    </body>
</html>
