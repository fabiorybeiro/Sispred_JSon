package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;

public class AtualizarEmpresa implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String razaoSocial = request.getParameter("razaoSocial");
		String cnpj = request.getParameter("cnpj");
		String conjunto = request.getParameter("conjunto");
		String horarioAbertura = request.getParameter("horarioAbertura");
		String horarioFechamento = request.getParameter("horarioFechamento");
		String tempMaxAr = request.getParameter("tempMaxAr");
		String ligarAr = request.getParameter("ligarAr");
		String desligarAr = request.getParameter("desligarAr");
		

		Empresa emp = new Empresa();
		emp.setId(id);
		emp.setRazaoSocial(razaoSocial);
		emp.setCnpj(cnpj);
		emp.setConjunto(conjunto);
		emp.setHorarioAbertura(horarioAbertura);
		emp.setHorarioFechamento(horarioFechamento);
		emp.setTempMaxAr(tempMaxAr);
		emp.setLigarAr(ligarAr);
		emp.setDesligarAr(desligarAr);

		EmpresaService empresaService = new EmpresaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		empresaService.atualizar(emp);
		empresaService.allEmpresas(cnpj);

		session.setAttribute("emp", emp);
		// ...envia para jsp
		view = request.getRequestDispatcher("Confirmacao.jsp");
		view.forward(request, response);
	}
}
