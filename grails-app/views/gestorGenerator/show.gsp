
<%@ page import="gestorGenerator.GestorGenerator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'gestorGenerator.label', default: 'GestorGenerator')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-gestorGenerator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-gestorGenerator" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list gestorGenerator">
			
				<g:if test="${gestorGeneratorInstance?.nomeDaEmpresa}">
				<li class="fieldcontain">
					<span id="nomeDaEmpresa-label" class="property-label"><g:message code="gestorGenerator.nomeDaEmpresa.label" default="Nome Da Empresa" /></span>
					
						<span class="property-value" aria-labelledby="nomeDaEmpresa-label"><g:fieldValue bean="${gestorGeneratorInstance}" field="nomeDaEmpresa"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gestorGeneratorInstance?.cNPJ}">
				<li class="fieldcontain">
					<span id="cNPJ-label" class="property-label"><g:message code="gestorGenerator.cNPJ.label" default="CNPJ" /></span>
					
						<span class="property-value" aria-labelledby="cNPJ-label"><g:fieldValue bean="${gestorGeneratorInstance}" field="cNPJ"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gestorGeneratorInstance?.telefone}">
				<li class="fieldcontain">
					<span id="telefone-label" class="property-label"><g:message code="gestorGenerator.telefone.label" default="Telefone" /></span>
					
						<span class="property-value" aria-labelledby="telefone-label"><g:fieldValue bean="${gestorGeneratorInstance}" field="telefone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gestorGeneratorInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="gestorGenerator.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${gestorGeneratorInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gestorGeneratorInstance?.endereco}">
				<li class="fieldcontain">
					<span id="endereco-label" class="property-label"><g:message code="gestorGenerator.endereco.label" default="Endereco" /></span>
					
						<span class="property-value" aria-labelledby="endereco-label"><g:fieldValue bean="${gestorGeneratorInstance}" field="endereco"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${gestorGeneratorInstance?.homePage}">
				<li class="fieldcontain">
					<span id="homePage-label" class="property-label"><g:message code="gestorGenerator.homePage.label" default="Home Page" /></span>
					
						<span class="property-value" aria-labelledby="homePage-label"><g:fieldValue bean="${gestorGeneratorInstance}" field="homePage"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${gestorGeneratorInstance?.id}" />
					<g:link class="edit" action="edit" id="${gestorGeneratorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
