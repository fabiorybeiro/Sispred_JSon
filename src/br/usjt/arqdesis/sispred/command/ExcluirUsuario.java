package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sispred.service.UsuarioService;

public class ExcluirUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebe o cnpj para consultar o banco
		String cpf = request.getParameter("cpf");
		// cria um usuario
		//Usuario usuario = new Usuario();
		// cria um usuario service
		UsuarioService userService = new UsuarioService();
		
		RequestDispatcher view = null;
		//HttpSession session = request.getSession();
		
		// consulta e instancia um usuario
		//usuario = userService.consultar(cpf);
		// envia para o JSP
		//session.setAttribute("user", usuario);
		// acao para exclusao da empresa
		userService.excluir(cpf);
		// ...envia para jsp
		view = request.getRequestDispatcher("cadastroExcluidoSucesso.jsp");
		view.forward(request, response);
	}
}
