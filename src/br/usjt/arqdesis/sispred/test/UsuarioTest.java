package br.usjt.arqdesis.sispred.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UsuarioTest {

	Usuario usuario, copia;
	UsuarioService UsuarioService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tamb�m que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Al�m disso, a ordem de execu��o dos testes � importante; por
	 * isso a anota��o FixMethodOrder logo acima do nome desta classe
	 */
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome("Renan");
		usuario.setSobrenome("Dantas");
		usuario.setCpf("0");
		copia = new Usuario();
		copia.setId(id);
		copia.setNome("Renan");
		copia.setSobrenome("Dantas");
		copia.setCpf("0");
		UsuarioService = new UsuarioService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Consultar() {
		System.out.println("Consultar");	
		Usuario fixture = new Usuario();
		fixture.setId(1);
		fixture.setNome("Renan");
		fixture.setSobrenome("Dantas");
		fixture.setCpf("0");
		UsuarioService novoService = new UsuarioService();
		Usuario novo = novoService.consultar(1);
		assertEquals("testa Consultar", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("Criar");
		id = UsuarioService.criar(usuario);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Alterar() {
		System.out.println("Alterar");
		usuario.setCpf("1111111111");
		copia.setCpf("1111111111");	
		UsuarioService.alterar(usuario);
		usuario = UsuarioService.consultar(usuario.getId());
		assertEquals("testa alteracao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("Excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setSobrenome(null);
		copia.setCpf(null);
		UsuarioService.excluir(usuario.getCpf());
		usuario = UsuarioService.consultar(usuario.getCpf());
		assertEquals("testa exclusao", usuario, copia);
	}
}
