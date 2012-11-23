<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Location Items</title>
            <link rel="stylesheet" type="text/css" href="/CDLibrary/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Listing Location Items</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(No Location Items Found)<br />" rendered="#{location.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{location.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{location.pagingInfo.firstItem + 1}..#{location.pagingInfo.lastItem} of #{location.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{location.prev}" value="Previous #{location.pagingInfo.batchSize}" rendered="#{location.pagingInfo.firstItem >= location.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{location.next}" value="Next #{location.pagingInfo.batchSize}" rendered="#{location.pagingInfo.lastItem + location.pagingInfo.batchSize <= location.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{location.next}" value="Remaining #{location.pagingInfo.itemCount - location.pagingInfo.lastItem}"
                               rendered="#{location.pagingInfo.lastItem < location.pagingInfo.itemCount && location.pagingInfo.lastItem + location.pagingInfo.batchSize > location.pagingInfo.itemCount}"/>
                <h:dataTable value="#{location.locationItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="LocationId"/>
                        </f:facet>
                        <h:outputText value="#{item.locationId}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Location"/>
                        </f:facet>
                        <h:outputText value="#{item.location}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Show" action="#{location.detailSetup}">
                            <f:param name="jsfcrud.currentLocation" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][location.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Edit" action="#{location.editSetup}">
                            <f:param name="jsfcrud.currentLocation" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][location.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Destroy" action="#{location.destroy}">
                            <f:param name="jsfcrud.currentLocation" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][location.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{location.createSetup}" value="New Location"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />


        </h:form>
        </body>
    </html>
</f:view>
