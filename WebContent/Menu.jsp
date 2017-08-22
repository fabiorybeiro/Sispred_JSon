<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">SisPred</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.jsp">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Empresa <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="controller.do?command=CadastrarEmpresa">Cadastrar</a></li>
					<li><a href="controller.do?command=ConsultarEmpresa">Consultar</a></li>
					<li><a href="controller.do?command=ListarEmpresa">Listar Empresas</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Usuário <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="controller.do?command=CadastrarUsuario">Cadastrar</a></li>
					<li><a href="controller.do?command=ConsultarUsuario">Consultar</a></li>
					<li><a href="controller.do?command=ListarUsuarioJson">Listar Usuários Json</a></li>
				</ul></li>
				<c:if test="${not empty lista}">
					<li><a href="controller.do?command=Logout">Sair</a></li>
				</c:if>
				<c:if test="${empty lista}">
					<li><a href="controller.do">Login</a></li>
				</c:if>
		</ul>
	</div>
</nav>