<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Biblioteca Anderson</title>
<link rel="stylesheet"
	href="<c:url value="/static/bootstrap-3.3.5-dist/css/bootstrap.min.css" />">
<script src="<c:url value="/static/lib/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/script.js" />"></script>
</head>
<body>

<c:url var="actionUrl" value="/savePessoa" />

<form:form id="cadastraPessoa" commandName="cadastraPessoa" method="post" action="<%--${actionUrl } --%>">

	<fieldset>
		<legend>Cadastro de Pessoa</legend>
			<br />
			<form:input id="nome" path="nome" placeholder="Nome do Pessoa" maxlength="200" class="form-control"/><br />
			<form:input id="datanascimento" path="datanascimento" placeholder="Data de Nascimento" maxlength="10" class="form-control"/><br />
			<form:input id="cpf" path="cpf" placeholder="CPF" maxlength="11" class="form-control" type="number"/><br />
			<form:input id="idpessoa" path="idlivro" type="hidden" />
			<form:button id="voltar" class="btn btn-primary">Voltar</form:button>
			<form:button type="reset" class="btn btn-primary">Limpar</form:button>
			<form:button type="submit" class="btn btn-primary">Confirmar</form:button>
	</fieldset>
</form:form>

</body>
</html>