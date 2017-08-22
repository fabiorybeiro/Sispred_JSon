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

public class ConsultarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cnpj = request.getParameter("data[search]");
		EmpresaService empresa = new EmpresaService();
		ArrayList<Empresa> lista = null;
		HttpSession session = request.getSession();
		if (cnpj != null && cnpj.length() > 0) {
			lista = empresa.allEmpresas(cnpj);
		} else {
			lista = empresa.allEmpresas();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarEmpresa.jsp");
		dispatcher.forward(request, response);
	}
}
