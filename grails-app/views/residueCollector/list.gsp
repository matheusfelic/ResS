
<%@ page import="ResidueCollector.ResidueCollector" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'residueCollector.label', default: 'ResidueCollector')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-residueCollector" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-residueCollector" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="collectorName" title="${message(code: 'residueCollector.collectorName.label', default: 'Collector Name')}" />
					
						<g:sortableColumn property="cnpj" title="${message(code: 'residueCollector.cnpj.label', default: 'Cnpj')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${residueCollectorInstanceList}" status="i" var="residueCollectorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${residueCollectorInstance.id}">${fieldValue(bean: residueCollectorInstance, field: "collectorName")}</g:link></td>
					
						<td>${fieldValue(bean: residueCollectorInstance, field: "cnpj")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${residueCollectorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
