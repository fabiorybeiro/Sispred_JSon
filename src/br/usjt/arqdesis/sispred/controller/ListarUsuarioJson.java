package br.usjt.arqdesis.sispred.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;
import br.usjt.arqdesis.sispred.service.VendedorService;
import br.usjt.arqdesis.sispred.util.JSonFacade;

@WebServlet("/usuario")
public class ListarUsuarioJson extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Configução do request e response para todos os métodos
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}
	
	// Listar todos os usuarios
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cpf = request.getParameter("cpf");
		VendedorService vendedor = new VendedorService();
		ArrayList<Usuario> lista = null;
		PrintWriter out = response.getWriter();
		try {
			if(cpf != null && cpf.length() > 0) {
				lista = vendedor.listarUsuario(cpf);
			} else {
				lista = vendedor.listarUsuario();
			}
			out.println(JSonFacade.listToJSon(lista));
		} catch(Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
	// Inclusao de um novo usuario
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();
		try {
			Usuario user = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService us = new UsuarioService();
			int id = us.criar(user);
			user.setId(id);
			//retorna o usuario cadastrado com o id atribuido pelo banco
			out.println(JSonFacade.usuarioToJSon(user));
		} catch(Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
	// Atualiza um usuario
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario user = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService us = new UsuarioService();
			us.alterar(user);
			//retorna o usuario atualizado
			out.println(JSonFacade.usuarioToJSon(user));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	// Exclui um usuario
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario user = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService us = new UsuarioService();
			us.excluir(user.getCpf());
			user = us.consultar(user.getId());
			//retorna dados null se o usuario foi deletado
			out.println(JSonFacade.usuarioToJSon(user));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
}
