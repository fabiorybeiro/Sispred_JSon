package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;

public class CadastrarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// cria atributos locais para receber os dados do formulario atraves do
		// metodo getParameter
		String nome      = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf       = request.getParameter("cpf");
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		
		RequestDispatcher view = null;
		
		if(cpf != null) {
			// cria o Javabean ou model ou TO (objeto empresa) com os dados
			// recebidos dos formulario
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setCpf(cpf);
			usuario.setUsername(username);
			usuario.setPassword(password);
	
			// cria o service responsavel por todas as regras
			UsuarioService user = new UsuarioService();
			
			HttpSession session = request.getSession();
			user.criar(usuario);
			user.consultar(usuario.getId());
	
			// envia o retorno para JSP
			session.setAttribute("user", usuario);
	
			view = request.getRequestDispatcher("cadastroIncluidoSucesso.jsp");
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("CadastrarUsuario.jsp");
			view.forward(request, response);
		}
	}
}
