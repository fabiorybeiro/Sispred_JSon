<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width-device, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Atualizar Usuário</title>
</head>
<body>
	<div id="main" class="container">
	<form action="controller.do" method="post">
	<h3 class="page-header">${atualizarUser.nome}</h3>
	<div class="row">
			<div class="col-md-6">
				<!-- <strong>ID <br></strong> --> <input type="hidden" name="id"  value="${atualizarUser.id}"/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p><strong>Nome</strong></p>
				<p><input type="text" name="nome" required value="${atualizarUser.nome}" required/></p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p><strong>Sobrenome</strong></p>
				<p><input type="text" name="sobrenome" required value="${atualizarUser.sobrenome}" required/></p>
			</div>
		</div>
		<div>
			<div>
				<!-- <p><strong>CPF</strong></p> -->
				<p><input type="text" name="cpf" required maxlength="11" value="${atualizarUser.cpf}" /></p>
			</div>
		</div>
		<div>
			<div>
				<p><strong>E-mail</strong></p>
				<p><input type="email" name="username" required maxlength="50" value="${atualizarUser.username}" required/></p>
			</div>
		</div>
		<div>
			<div>
				<p><strong>Senha</strong></p>
				<p><input type="password" name="password" required maxlength="50" value="${atualizarUser.password}" required/></p>
			</div>
		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" name="command" value="AtualizarUsuario" class="btn btn-default">Alterar</button>
				<a href="EditarUsuario.jsp" class="btn btn-default">Voltar</a>
            </div>
        </div>
        </form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>	
</body>
</html>