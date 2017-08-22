package br.usjt.arqdesis.sispred.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqdesis.sispred.dao.UsuarioDAO;
import br.usjt.arqdesis.sispred.model.Usuario;

public class VendedorService {
	private UsuarioDAO dao;
	
	public VendedorService() {
		dao = new UsuarioDAO();
	}
	
	public ArrayList<Usuario> listarUsuario() throws IOException{
		return dao.allUsuario();
	}
	
	public ArrayList<Usuario> listarUsuario(String cpf) throws IOException{
		return dao.allUsuario(cpf);
	}
}
