package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;

public class EditarUsuario implements Command{
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cpf = request.getParameter("cpf");
		Usuario usuario = new Usuario();
		UsuarioService userService = new UsuarioService();
		usuario = userService.consultar(cpf);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		session.setAttribute("atualizarUser", usuario);
		
		view = request.getRequestDispatcher("AtualizarUsuario.jsp");
		
		view.forward(request, response);
	}

}
