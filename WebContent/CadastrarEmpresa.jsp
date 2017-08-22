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
		<h3 class="page-header">Cadastrar de Empresas</h3>
		<form action="controller.do" method="post">
			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">Razão Social: </label> <input type="text"
						name="razaoSocial" id="razaoSocial"
						placeholder="Nome da Razão Social" class="form-control" required
						maxlength="100">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="cnpj">CNPJ</label> <input type="text" name="cnpj"
						id="cnpj" class="form-control" placeholder="CNPJ com 14 digitos"
						required maxlength="14">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="conjuntos">Número de Conjuntos</label><br> <label
						class="radio-inline"><input type="radio" name="conjuntos"
						value="1" checked="checked"> 1 </label> <label
						class="radio-inline"><input type="radio" name="conjuntos"
						value="2"> 2 </label> <label class="radio-inline"><input
						type="radio" name="conjuntos" value="3"> 3 </label> <label
						class="radio-inline"><input type="radio" name="conjuntos"
						value="4"> 4 </label> <label class="radio-inline"><input
						type="radio" name="conjuntos" value="5"> 5 </label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<label for="horarioFuncionamento">Horário de Funcionamento</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-3">
					Das <input type=time name="horarioAbertura" id="horarioAbertura"
						class="form-control" placeholder="hh:mm" required maxlength="5">
				</div>
				<div class="form-group col-sm-3">
					Até <input type=time name="horarioFechamento"
						id="horarioFechamento" class="form-control" placeholder="hh:mm"
						required maxlength="5">

				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label for="tempMaxAr">Temperatura Máxima do
						ar-condicionado</label>
					<div></div>
					<input type=text name="tempMaxAr" id="tempMaxAr"
						class="form-control" placeholder="Digite a temperatura máxima"
						required maxlength="2">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="horarioAr">Horário do ar-condicionado</label>

					<p>
						Das <input type=time name="ligarAr" id="ligarAr"
							class="form-control" placeholder="hh:mm" required maxlength="5">

						Até <input type=time name="desligarAr" id="desligarAr"
							class="form-control" placeholder="hh:mm" required maxlength="5">
					</p>
				</div>
			</div>
			<button type="submit" name="command" value="CadastrarEmpresa"
				class="btn btn-primary">Salvar</button>
		</form>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>