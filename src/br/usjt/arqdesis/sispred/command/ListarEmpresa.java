package br.usjt.arqdesis.sispred.command;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;

public class ListarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmpresaService emp = new EmpresaService();
		ArrayList<Empresa> lista = null;
		HttpSession session = request.getSession();
		lista = emp.allEmpresas();
		
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEmpresas.jsp");
		dispatcher.forward(request, response);
	}

}
