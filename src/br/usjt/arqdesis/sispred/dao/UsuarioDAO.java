package br.usjt.arqdesis.sispred.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqdesis.sispred.model.Usuario;

public class UsuarioDAO {

	public int criar(Usuario Usuario) {
		String criarSql = "Insert into usuario(nome, sobrenome, cpf, username, password) Values(?,?,?,?,?)";
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(criarSql);) {
			stm.setString(1, Usuario.getNome());
			stm.setString(2, Usuario.getSobrenome());
			stm.setString(3, Usuario.getCpf());
			stm.setString(4, Usuario.getUsername());
			stm.setString(5, Usuario.getPassword());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = c.prepareStatement(sqlQuery);) {
				ResultSet rs = stm2.executeQuery();
				if (rs.next()) {
					Usuario.setId(rs.getInt(1));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Usuario.getId();

	}

	public Usuario consultar(int id) {
		Usuario Usuario = new Usuario();
		Usuario.setId(id);
		String sqlSelect = "SELECT nome, sobrenome, cpf FROM usuario WHERE id=?";
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(sqlSelect);) {
			stm.setInt(1, Usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Usuario.setNome(rs.getString("nome"));
					Usuario.setSobrenome(rs.getString("sobrenome"));
					Usuario.setCpf(rs.getString("cpf"));
				} else {
					Usuario.setId(-1);
					Usuario.setNome(null);
					Usuario.setSobrenome(null);
					Usuario.setCpf(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Usuario;
	}

	public void alterar(Usuario Usuario) {
		String sqlAtualizar = "UPDATE usuario SET nome=?, sobrenome=?, cpf=?, username=?, password=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection c = ConnectionFactory.obtemConexao();
				PreparedStatement stm = c.prepareStatement(sqlAtualizar);) {
			stm.setString(1, Usuario.getNome());
			stm.setString(2, Usuario.getSobrenome());
			stm.setString(3, Usuario.getCpf());
			stm.setString(4, Usuario.getUsername());
			stm.setString(5, Usuario.getPassword());
			stm.setInt(6, Usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(String cpf) {
		String sqlExcluir = "DELETE FROM usuario WHERE cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(sqlExcluir);) {
			stm.setString(1, cpf);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> allUsuario() {
		Usuario usuario;

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		String sqlSelect = "SELECT * FROM usuario";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {

					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSobrenome(rs.getString("sobrenome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setUsername(rs.getString("username"));
					lista.add(usuario);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Usuario> allUsuario(String cpf) {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM usuario where upper(cpf) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + cpf.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSobrenome(rs.getString("sobrenome"));
					usuario.setCpf(rs.getString("cpf"));
					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public Usuario consultar(String cpf) {
		Usuario usuario = new Usuario();

		String sqlSelect = "SELECT * FROM usuario WHERE cpf=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cpf);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSobrenome(rs.getString("sobrenome"));
					usuario.setCpf(rs.getString("cpf"));
				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setSobrenome(null);
					usuario.setCpf(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT username, password FROM usuario " + "WHERE username = ? and password = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getUsername());
				stm.setString(2, usuario.getPassword());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

}
