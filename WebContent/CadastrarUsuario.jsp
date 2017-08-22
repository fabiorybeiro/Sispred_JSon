<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastrar de Empresas</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
		<h3 class="page-header">Cadastrar de Usuario</h3>
		<form action="controller.do" method="post">
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Nome </label> <input type="text"
						name="nome" id="nome"
						placeholder="Digite seu Nome" class="form-control" required
						maxlength="100">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="sobrenome">Sobrenome</label> <input type="text" name="sobrenome"
						id="sobrenome" class="form-control" placeholder="Digite seu Sobrenome" required
						maxlength="100">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="cpf">CPF</label> <input type="text" name="cpf"
						id="cpf" class="form-control" placeholder="Digite seu CPF" required
						maxlength="11">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="email">E-mail</label> <input type="email" name="username"
						id="username" class="form-control" placeholder="Digite seu E-mail" required
						maxlength="50">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="password">Senha</label> <input type="password" name="password"
						id="password" class="form-control" placeholder="Digite uma senha" required
						maxlength="50">
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="command" value="CadastrarUsuario">Criar</button>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>