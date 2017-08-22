package br.usjt.arqdesis.sispred.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.VendedorService;

public class ListarUsuarioJson implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		VendedorService vendedor = new VendedorService();
		ArrayList<Usuario> lista = null;
		HttpSession session = request.getSession();

		if (cpf != null && cpf.length() > 0) {
			lista = vendedor.listarUsuario(cpf);
		} else {
			lista = vendedor.listarUsuario();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarUsuarios.jsp");
		dispatcher.forward(request, response);
	}
}
