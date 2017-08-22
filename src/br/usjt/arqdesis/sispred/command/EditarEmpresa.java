package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;

public class EditarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = new Empresa();
		EmpresaService emp = new EmpresaService();
		empresa = emp.consultar(cnpj);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		session.setAttribute("atualizarEmpresa", empresa);

		view = request.getRequestDispatcher("AtualizarEmpresa.jsp");

		view.forward(request, response);
	}

}
