<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Cd</title>
            <link rel="stylesheet" type="text/css" href="/CDLibrary/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>New Cd</h1>
        <h:form>
            <h:inputHidden id="validateCreateField" validator="#{cd.validateCreate}" value="value"/>
            <h:panelGrid columns="2">
                <h:outputText value="CdId:"/>
                <h:inputText id="cdId" value="#{cd.cd.cdId}" title="CdId" required="true" requiredMessage="The cdId field is required." />
                <h:outputText value="Title:"/>
                <h:inputText id="title" value="#{cd.cd.title}" title="Title" />
                <h:outputText value="Author:"/>
                <h:inputText id="author" value="#{cd.cd.author}" title="Author" />
                <h:outputText value="YearCreated:"/>
                <h:inputText id="yearCreated" value="#{cd.cd.yearCreated}" title="YearCreated" />
                <h:outputText value="Location:"/>
                <h:inputText id="location" value="#{cd.cd.location}" title="Location" />
                <h:outputText value="Rating:"/>
                <h:inputText id="rating" value="#{cd.cd.rating}" title="Rating" />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{cd.create}" value="Create"/>
            <br />
            <br />
            <h:commandLink action="#{cd.listSetup}" value="Show All Cd Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
