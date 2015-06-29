<%@ page import="gestorGenerator.GestorGenerator" %>



<div class="fieldcontain ${hasErrors(bean: gestorGeneratorInstance, field: 'nomeDaEmpresa', 'error')} required">
	<label for="nomeDaEmpresa">
		<g:message code="gestorGenerator.nomeDaEmpresa.label" default="Nome Da Empresa" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nomeDaEmpresa" required="" value="${gestorGeneratorInstance?.nomeDaEmpresa}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gestorGeneratorInstance, field: 'cNPJ', 'error')} required">
	<label for="cNPJ">
		<g:message code="gestorGenerator.cNPJ.label" default="CNPJ" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cNPJ" required="" value="${gestorGeneratorInstance?.cNPJ}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gestorGeneratorInstance, field: 'telefone', 'error')} required">
	<label for="telefone">
		<g:message code="gestorGenerator.telefone.label" default="Telefone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefone" required="" value="${gestorGeneratorInstance?.telefone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gestorGeneratorInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="gestorGenerator.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${gestorGeneratorInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gestorGeneratorInstance, field: 'endereco', 'error')} required">
	<label for="endereco">
		<g:message code="gestorGenerator.endereco.label" default="Endereco" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="endereco" required="" value="${gestorGeneratorInstance?.endereco}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gestorGeneratorInstance, field: 'homePage', 'error')} ">
	<label for="homePage">
		<g:message code="gestorGenerator.homePage.label" default="Home Page" />
		
	</label>
	<g:textField name="homePage" value="${gestorGeneratorInstance?.homePage}"/>
</div>

