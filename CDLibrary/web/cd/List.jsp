<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Cd Items</title>
            <link rel="stylesheet" type="text/css" href="/CDLibrary/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Listing Cd Items</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(No Cd Items Found)<br />" rendered="#{cd.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{cd.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{cd.pagingInfo.firstItem + 1}..#{cd.pagingInfo.lastItem} of #{cd.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{cd.prev}" value="Previous #{cd.pagingInfo.batchSize}" rendered="#{cd.pagingInfo.firstItem >= cd.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{cd.next}" value="Next #{cd.pagingInfo.batchSize}" rendered="#{cd.pagingInfo.lastItem + cd.pagingInfo.batchSize <= cd.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{cd.next}" value="Remaining #{cd.pagingInfo.itemCount - cd.pagingInfo.lastItem}"
                               rendered="#{cd.pagingInfo.lastItem < cd.pagingInfo.itemCount && cd.pagingInfo.lastItem + cd.pagingInfo.batchSize > cd.pagingInfo.itemCount}"/>
                <h:dataTable value="#{cd.cdItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="CdId"/>
                        </f:facet>
                        <h:outputText value="#{item.cdId}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Title"/>
                        </f:facet>
                        <h:outputText value="#{item.title}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Author"/>
                        </f:facet>
                        <h:outputText value="#{item.author}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="YearCreated"/>
                        </f:facet>
                        <h:outputText value="#{item.yearCreated}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Location"/>
                        </f:facet>
                        <h:outputText value="#{item.location}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Rating"/>
                        </f:facet>
                        <h:outputText value="#{item.rating}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Show" action="#{cd.detailSetup}">
                            <f:param name="jsfcrud.currentCd" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][cd.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Edit" action="#{cd.editSetup}">
                            <f:param name="jsfcrud.currentCd" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][cd.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Destroy" action="#{cd.destroy}">
                            <f:param name="jsfcrud.currentCd" value="#{jsfcrud_class['mypackage.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][cd.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{cd.createSetup}" value="New Cd"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />


        </h:form>
        </body>
    </html>
</f:view>
