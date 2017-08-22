package br.usjt.arqdesis.sispred.service;

import java.util.ArrayList;

import br.usjt.arqdesis.sispred.dao.EmpresaDAO;
import br.usjt.arqdesis.sispred.model.Empresa;

public class EmpresaService {
	// crio um objeto dao
	EmpresaDAO dao = new EmpresaDAO();

	public EmpresaService() {
	}

	// metodo para cadastrar uma empresa
	public int criar(Empresa empresa) {
		return dao.criar(empresa);
	}

	// metodo para excluir uma empresa
	public void excluir(int id) {
		dao.excluir(id);
	}

	// metodo para atualizar dados da empresa
	public void atualizar(Empresa empresa) {
		dao.atualizar(empresa);
	}

	// metodo para consultar uma empresa
	public Empresa consultar(int id) {
		return dao.consultar(id);
	}
	
	// metodo que retorna todas as empresas cadastradas
	public Empresa consultar(String cnpj){
		return dao.consultar(cnpj);
	}

	public ArrayList<Empresa> allEmpresas() {
		
		return dao.allEmpresas();
	}
	
	public ArrayList<Empresa> allEmpresas(String chave) {
		return dao.allEmpresas(chave);
	}
}
