<%-- 
    Document   : response
    Created on : 13/09/2010, 06:55:21 PM
    Author     : willy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guess The Number</title></head>
        <%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
        <%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>    
    <body bgcolor="white">
        <f:view>
            <h:form id="responseForm">
                <h:graphicImage id="waveImg" url="/wave.med.gif"/>
                <h2>
                    <h:outputText id="result"
                                  value="#{UserNumberBean.response}"/>
                </h2>
                    <h:commandButton id="back" value="Back" action="success"/><p>
            </h:form>
        </f:view>
    </body>
</html>
