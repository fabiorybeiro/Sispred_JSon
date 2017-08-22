<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar empresa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Lista de empresas</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Razão Social</th>
					<th>CNPJ</th>
					<th>N. Conjunto</th>
				</tr>
			</thead>
			<c:forEach var="empresa" items="${lista}">
				<tr>
					<td>${empresa.id}</td>
					<td>${empresa.razaoSocial}</td>
					<td>${empresa.cnpj}</td>
					<td>${empresa.conjunto}</td>
					<td><a
						href="controller.do?command=EditarEmpresa&cnpj=${empresa.cnpj}"
						class="btn btn-primary">Alterar</a></td>
					<td><a
						href="controller.do?command=ExcluirEmpresa&cnpj=${empresa.cnpj}"
						class="btn btn-primary">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>