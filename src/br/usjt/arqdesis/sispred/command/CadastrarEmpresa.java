package br.usjt.arqdesis.sispred.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;


public class CadastrarEmpresa implements Command{
	
	@Override
	public void executar(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		// cria atributos locais para receber os dados do formulario atraves do metodo getParameter
		String razaoSocial = request.getParameter("razaoSocial");
		String cnpj = request.getParameter("cnpj");
		String conj = request.getParameter("conjuntos");
		String horarioAbertura = request.getParameter("horarioAbertura");
		String horarioFechamento = request.getParameter("horarioFechamento");
		String tempMaxAr = request.getParameter("tempMaxAr");
		String ligarAr = request.getParameter("ligarAr");
		String desligarAr = request.getParameter("desligarAr");
		
		
		// cria o Javabean ou model ou TO (objeto empresa) com os dados recebidos dos formulario
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial(razaoSocial);
		empresa.setCnpj(cnpj);
		empresa.setConjunto(conj);
		empresa.setHorarioAbertura(horarioAbertura);
		empresa.setHorarioFechamento(horarioFechamento);
		empresa.setTempMaxAr(tempMaxAr);
		empresa.setLigarAr(ligarAr);
		empresa.setDesligarAr(desligarAr);
		
		
		//cria o service responsavel por todas as regras 
		EmpresaService empService = new EmpresaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		empService.criar(empresa);
		empService.consultar(empresa.getId());
		
		//envia o retorno para JSP
		session.setAttribute("novaEmpresa", empresa);
		
		view = request.getRequestDispatcher("cadastroIncluidoSucesso.jsp");
		view.forward(request, response);
	}
}
