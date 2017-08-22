package br.usjt.arqdesis.sispred.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;

public class ListarUsuario implements Command{
	
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UsuarioService usuario = new UsuarioService();
		ArrayList<Usuario> lista = null;
		HttpSession session = request.getSession();
		lista = usuario.allUsuario();
		
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarUsuarios.jsp");
		dispatcher.forward(request, response);
	}
}
