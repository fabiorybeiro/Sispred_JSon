package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;

public class AtualizarUsuario implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String nome      = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf       = request.getParameter("cpf");
		String username  = request.getParameter("username"); 
		String password  = request.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setCpf(cpf);
		usuario.setUsername(username);
		usuario.setPassword(password);
		
		UsuarioService userService = new UsuarioService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		userService.alterar(usuario);
		
		session.setAttribute("user",usuario);
		//...envia para jsp
		view = request.getRequestDispatcher("Confirmacao.jsp");
		view.forward(request, response);
	}
}
