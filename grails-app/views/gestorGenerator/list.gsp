
<%@ page import="gestorGenerator.GestorGenerator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'gestorGenerator.label', default: 'GestorGenerator')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-gestorGenerator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-gestorGenerator" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nomeDaEmpresa" title="${message(code: 'gestorGenerator.nomeDaEmpresa.label', default: 'Nome Da Empresa')}" />
					
						<g:sortableColumn property="cNPJ" title="${message(code: 'gestorGenerator.cNPJ.label', default: 'CNPJ')}" />
					
						<g:sortableColumn property="telefone" title="${message(code: 'gestorGenerator.telefone.label', default: 'Telefone')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'gestorGenerator.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="endereco" title="${message(code: 'gestorGenerator.endereco.label', default: 'Endereco')}" />
					
						<g:sortableColumn property="homePage" title="${message(code: 'gestorGenerator.homePage.label', default: 'Home Page')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${gestorGeneratorInstanceList}" status="i" var="gestorGeneratorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${gestorGeneratorInstance.id}">${fieldValue(bean: gestorGeneratorInstance, field: "nomeDaEmpresa")}</g:link></td>
					
						<td>${fieldValue(bean: gestorGeneratorInstance, field: "cNPJ")}</td>
					
						<td>${fieldValue(bean: gestorGeneratorInstance, field: "telefone")}</td>
					
						<td>${fieldValue(bean: gestorGeneratorInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: gestorGeneratorInstance, field: "endereco")}</td>
					
						<td>${fieldValue(bean: gestorGeneratorInstance, field: "homePage")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${gestorGeneratorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
