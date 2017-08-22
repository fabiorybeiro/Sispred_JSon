package br.usjt.arqdesis.sispred.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqdesis.sispred.model.Empresa;

public class EmpresaDAO {

	// cria uma empresa
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa (razaoSocial, cnpj, conjunto, horarioAbertura, horarioFechamento, tempMaxAr, ligarAr, desligarAr ) VALUES (?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getCnpj());
			stm.setString(3, empresa.getConjunto());
			stm.setString(4, empresa.getHorarioAbertura());
			stm.setString(5, empresa.getHorarioFechamento());
			stm.setString(6, empresa.getTempMaxAr());
			stm.setString(7, empresa.getLigarAr());
			stm.setString(8, empresa.getDesligarAr());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);) {
				ResultSet rs = stm2.executeQuery();
				if (rs.next()) {
					empresa.setId(rs.getInt(1));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return empresa.getId();
	}

	// exclui uma empresa
	public void excluir(int id) {
		String sqlDelete = "DELETE from empresa WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// atualiza uma empresa
	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE empresa SET razaoSocial=?, cnpj=?, conjunto=?, horarioAbertura=?, horarioFechamento=?, tempMaxAr=?, ligarAr=?, desligarAr=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getCnpj());
			stm.setString(3, empresa.getConjunto());
			stm.setInt(4, empresa.getId());
			stm.setString(4, empresa.getHorarioAbertura());
			stm.setString(5, empresa.getHorarioFechamento());
			stm.setString(6, empresa.getTempMaxAr());
			stm.setString(7, empresa.getLigarAr());
			stm.setString(8, empresa.getDesligarAr());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// consulta uma empresa pelo id
	public Empresa consultar(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		String sqlSelect = "SELECT razaoSocial, cnpj, conjunto, horarioAbertura, horarioFechamento, tempMaxAr, ligarAr, desligarAr FROM empresa WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, empresa.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setConjunto(rs.getString("conjunto"));
					empresa.setHorarioAbertura(rs.getString("horarioAbertura"));
					empresa.setHorarioFechamento(rs.getString("horarioFechamento"));
					empresa.setTempMaxAr(rs.getString("tempMaxAr"));
					empresa.setLigarAr(rs.getString("ligarAr"));
					empresa.setDesligarAr(rs.getString("desligarAr"));
				} else {
					empresa.setId(-1);
					empresa.setRazaoSocial(null);
					empresa.setCnpj(null);
					empresa.setConjunto(null);
					empresa.setHorarioAbertura(null);
					empresa.setHorarioFechamento(null);
					empresa.setTempMaxAr(null);
					empresa.setLigarAr(null);
					empresa.setDesligarAr(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}

	public ArrayList<Empresa> allEmpresas(String chave) {
		Empresa empresa;
		ArrayList<Empresa> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM empresa where upper(cnpj) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					empresa = new Empresa();
					empresa.setId(rs.getInt("id"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setConjunto(rs.getString("conjunto"));
					empresa.setHorarioAbertura(rs.getString("horarioAbertura"));
					empresa.setHorarioFechamento(rs.getString("horarioFechamento"));
					empresa.setTempMaxAr(rs.getString("tempMaxAr"));
					empresa.setLigarAr(rs.getString("ligarAr"));
					empresa.setDesligarAr(rs.getString("desligarAr"));
					lista.add(empresa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	// consulta e retorna todas as empresa cadastradas
	public Empresa consultar(String cnpj) {
		Empresa empresa = new Empresa();

		String sqlSelect = "SELECT * FROM empresa WHERE cnpj=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cnpj);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setId(rs.getInt("id"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setConjunto(rs.getString("conjunto"));
					empresa.setHorarioAbertura(rs.getString("horarioAbertura"));
					empresa.setHorarioFechamento(rs.getString("horarioFechamento"));
					empresa.setTempMaxAr(rs.getString("tempMaxAr"));
					empresa.setLigarAr(rs.getString("ligarAr"));
					empresa.setDesligarAr(rs.getString("desligarAr"));
				} else {
					empresa.setId(-1);
					empresa.setRazaoSocial(null);
					empresa.setCnpj(null);
					empresa.setConjunto(null);
					empresa.setHorarioAbertura(null);
					empresa.setHorarioFechamento(null);
					empresa.setTempMaxAr(null);
					empresa.setLigarAr(null);
					empresa.setDesligarAr(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}

	public ArrayList<Empresa> allEmpresas() {
		Empresa empresa;

		ArrayList<Empresa> lista = new ArrayList<Empresa>();

		String sqlSelect = "SELECT * FROM empresa";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {

					empresa = new Empresa();
					empresa.setId(rs.getInt("id"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setConjunto(rs.getString("conjunto"));
					empresa.setHorarioAbertura(rs.getString("horarioAbertura"));
					empresa.setHorarioFechamento(rs.getString("horarioFechamento"));
					empresa.setTempMaxAr(rs.getString("tempMaxAr"));
					empresa.setLigarAr(rs.getString("ligarAr"));
					empresa.setDesligarAr(rs.getString("desligarAr"));

					lista.add(empresa);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
