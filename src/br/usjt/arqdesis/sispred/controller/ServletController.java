package br.usjt.arqdesis.sispred.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sispred.command.Command;
import br.usjt.arqdesis.sispred.dao.ConnectionFactory;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doExecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			Command comando = (Command) Class.forName("br.usjt.arqdesis.sispred.command." + request.getParameter("command")).newInstance();
			comando.executar(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doExecute(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doExecute(request, response);
	}

	@Override
	public void init() {
		try {
			ConnectionFactory.obtemConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			ConnectionFactory.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
