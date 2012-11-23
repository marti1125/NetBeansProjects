<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Cd Detail</title>
            <link rel="stylesheet" type="text/css" href="/CDLibrary/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Cd Detail</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="CdId:"/>
                <h:outputText value="#{cd.cd.cdId}" title="CdId" />
                <h:outputText value="Title:"/>
                <h:outputText value="#{cd.cd.title}" title="Title" />
                <h:outputText value="Author:"/>
                <h:outputText value="#{cd.cd.author}" title="Author" />
                <h:outputText value="YearCreated:"/>
                <h:outputText value="#{cd.cd.yearCreated}" title="YearCreated" />
                <h:outputText value="Location:"/>
                <h:outputText value="#{cd.cd.location}" title="Location" />
                <h:outputText value="Rating:"/>
                <h:outputText value="#{cd.cd.rating}" title="Rating" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{cd.destroy}" value="Destroy">
                <f:param name="jsfcrud.currentCd" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cd.cd][cd.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{cd.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentCd" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cd.cd][cd.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{cd.createSetup}" value="New Cd" />
            <br />
            <h:commandLink action="#{cd.listSetup}" value="Show All Cd Items"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
