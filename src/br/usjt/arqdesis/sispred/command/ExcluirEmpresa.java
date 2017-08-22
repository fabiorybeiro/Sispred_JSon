package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;

public class ExcluirEmpresa implements Command{
	
	@Override
	public void executar(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// recebe o cnpj para consultar o banco
		String cnpj = request.getParameter("cnpj");
		// cria uma empresa
		Empresa empresa = new Empresa();
		// cria uma empresa service
		EmpresaService emp = new EmpresaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		// consulta e instancia uma empresa
		empresa = emp.consultar(cnpj);
		// envia para o JSP
		session.setAttribute("novaEmpresa",empresa);
		// acao para exclusao da empresa
		emp.excluir(empresa.getId());
		//...envia para jsp
		view = request.getRequestDispatcher("cadastroExcluidoSucesso.jsp");
		view.forward(request, response);
		
	}
}
