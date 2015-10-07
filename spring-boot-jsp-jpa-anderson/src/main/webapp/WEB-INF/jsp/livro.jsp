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
	<div class="container">
		<h2>Lista de Livros</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome do Livro</th>
					<th>Escritor</th>
					<th>Ano de Edição</th>
					<th>Classificação</th>
				</tr>
			</thead>
			</tbody>
			<c:if test="${not empty listaLivros}">
				<c:forEach var="livros" items="${listaLivros}">
					<tr>
						<td>${livros.nome}</td>
						<td>${livros.escritor}</td>
						<td>${livros.anoedicao}</td>
						<td>${livros.classificacao}</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</div>

	<button type="button" onclick="#" class="btn btn-primary">Cadastrar</button>
	<br />
</body>
</html>
