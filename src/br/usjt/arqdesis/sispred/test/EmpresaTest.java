package br.usjt.arqdesis.sispred.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {
	Empresa empresa, copia;
	EmpresaService empresaService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. Certifique-se tamb�m que sobrecarregou o equals na classe
	 * Cliente. Certifique-se que a fixture cliente1 foi criada no banco. Al�m
	 * disso, a ordem de execu��o dos testes � importante; por isso a anota��o
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		empresa = new Empresa();
		empresa.setId(id);
		empresa.setRazaoSocial("FABIO");
		empresa.setCnpj("000");
		empresa.setConjunto("3");
		copia = new Empresa();
		copia.setId(id);
		copia.setRazaoSocial("FABIO");
		copia.setCnpj("000");
		copia.setConjunto("3");
		;
		empresaService = new EmpresaService();
		System.out.println(empresa);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		// para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Empresa fixture = new Empresa();
		fixture.setId(1);
		fixture.setRazaoSocial("VAL DESIGN");
		fixture.setCnpj("0");
		fixture.setConjunto("1");
		EmpresaService novoService = new EmpresaService();
		Empresa novo = novoService.consultar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = empresaService.criar(empresa);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", empresa, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		empresa.setCnpj("999999");
		copia.setCnpj("999999");
		empresaService.atualizar(empresa);
		empresa = empresaService.consultar(empresa.getId());
		assertEquals("testa atualizacao", empresa, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setRazaoSocial(null);
		copia.setCnpj(null);
		copia.setConjunto(null);
		empresaService.excluir(id);
		empresa = empresaService.consultar(id);
		assertEquals("testa exclusao", empresa, copia);
	}
}