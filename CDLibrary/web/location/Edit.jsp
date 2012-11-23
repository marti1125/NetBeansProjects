<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Location</title>
            <link rel="stylesheet" type="text/css" href="/CDLibrary/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Editing Location</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="LocationId:"/>
                <h:outputText value="#{location.location.locationId}" title="LocationId" />
                <h:outputText value="Location:"/>
                <h:inputText id="location" value="#{location.location.location}" title="Location" />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{location.edit}" value="Save">
                <f:param name="jsfcrud.currentLocation" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][location.location][location.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{location.detailSetup}" value="Show" immediate="true">
                <f:param name="jsfcrud.currentLocation" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][location.location][location.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <h:commandLink action="#{location.listSetup}" value="Show All Location Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
