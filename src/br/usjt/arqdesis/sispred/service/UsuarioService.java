package br.usjt.arqdesis.sispred.service;

import java.util.ArrayList;

import br.usjt.arqdesis.sispred.dao.UsuarioDAO;
import br.usjt.arqdesis.sispred.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();

	public UsuarioService() {
	}

	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}

	public Usuario consultar(int id) {
		return dao.consultar(id);
	}

	public void alterar(Usuario usuario) {
		dao.alterar(usuario);
	}

	public void excluir(String cpf) {
		dao.excluir(cpf);
	}

	public ArrayList<Usuario> allUsuario() {
		return dao.allUsuario();
	}

	public ArrayList<Usuario> allUsuario(String cpf) {
		return dao.allUsuario(cpf);
	}

	public Usuario consultar(String cpf) {
		return dao.consultar(cpf);
	}

	public boolean validar(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}

}