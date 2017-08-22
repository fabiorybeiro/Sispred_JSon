<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Consultar Usuário</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Consultar Usuário</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" name="data[search]" id="cpf" maxlength="11" placeholder="Para listar todos, clique em Consultar">
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-4">
                    <button type="submit" class="btn btn-primary" name="command" value="ConsultarUsuario" >Consultar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <hr />
    <c:if test="${not empty lista}">
     <div id="main" class="container">
		<h3 class="page-header">Lista de usuários cadastrados</h3>
		<form action="controller.do" method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Sobrenome</th>
						<th>CPF</th>
						<th>Username</th>
						<th>Alterar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<c:forEach var="user" items="${lista}">
					<tr>
						<td>${user.id}</td>
						<td>${user.nome}</td>
						<td>${user.sobrenome}</td>
						<td>${user.cpf}</td>
						<td>${user.username}</td>
						<td><a
							href="controller.do?command=EditarUsuario&cpf=${user.cpf}"
							class="btn btn-primary">Alterar</a></td>
						<td><a
							href="controller.do?command=ExcluirUsuario&cpf=${user.cpf}"
							class="btn btn-primary">Excluir</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	</c:if>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>