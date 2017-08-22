<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width-device, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Visualizar usuário</title>
</head>
<body>
	<div id="main" class="container">
		<h3 class="page-header">Resultado da busca</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>CPF</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${user.id}</td>
					<td>${user.nome}</td>
					<td>${user.sobrenome}</td>
					<td>${user.cpf}</td>
					<td>
						<form action="EditarUsuario.do" method="post">
							<button name="cpf" value="${user.cpf}">Alterar</button> 
						</form>
					</td>
					<td>
						
						<form action="ExcluirUsuario.do" method="post">
							<button name="cpf" value="${user.cpf}">Excluir</button> 
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="ConsultarUsuario.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>