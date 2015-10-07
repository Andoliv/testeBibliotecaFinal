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
	<h2>Empréstimo de Livros</h2>
	<div class="bs-example">
		<form>
			<div class="row">
				<div class="col-xs-6">
					<div class="input-group">
						<span>Livro: </span> <select class="selectpicker">
							<c:choose>
								<c:when test="${not empty listaLivros}">
									<c:forEach var="livros" items="${listaLivros}">
										<option value="${livros.idlivro}">${livros.nome} ::
											${livros.escritor}</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option>Não existe livro cadastrado</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<br />
					<div class="input-group">
						<span>Pessoa: </span> <select class="selectpicker">
							<c:choose>
								<c:when test="${not empty listaPessoas}">
									<c:forEach var="pessoas" items="${listaPessoas}">
										<option value="${pessoas.idpessoa}">${pessoas.nome}</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option>Não existe pessoa cadastrada</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
				<div class="col-xs-6">
					<div class="input-group">
						<span class="input-group-btn">
							<button type="button" class="btn btn-default">Emprestar</button>
						</span>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
