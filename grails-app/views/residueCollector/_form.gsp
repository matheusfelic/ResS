<%@ page import="ResidueCollector.ResidueCollector" %>



<div class="fieldcontain ${hasErrors(bean: residueCollectorInstance, field: 'collectorName', 'error')} required">
	<label for="collectorName">
		<g:message code="residueCollector.collectorName.label" default="Collector Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="collectorName" required="" value="${residueCollectorInstance?.collectorName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: residueCollectorInstance, field: 'cnpj', 'error')} required">
	<label for="cnpj">
		<g:message code="residueCollector.cnpj.label" default="Cnpj" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj" maxlength="18" required="" value="${residueCollectorInstance?.cnpj}"/>
</div>

