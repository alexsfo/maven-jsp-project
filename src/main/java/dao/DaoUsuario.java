package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.*;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanCadastro usuario) {
		try {
			String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getEmail());
			insert.setString(3, usuario.getSenha());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	
	public ArrayList<BeanCadastro> listar() throws Exception {

		ArrayList<BeanCadastro> listar = new ArrayList<BeanCadastro>();

		String sql = "select * from usuario";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			BeanCadastro beanCadastro = new BeanCadastro();
			beanCadastro.setId(resultSet.getLong("id"));
			beanCadastro.setNome(resultSet.getString("nome"));
			beanCadastro.setSenha(resultSet.getString("senha"));
			beanCadastro.setEmail(resultSet.getString("email"));
			listar.add(beanCadastro);
		}
		return listar;
		
	}

	public void delete(String nome) {
		try {
			String sql = "delete from usuario where nome = '" + nome + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public BeanCadastro consultar(String nome) throws Exception {

		String sql = "select * from usuario where nome = '" + nome + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		BeanCadastro beanCadastro = new BeanCadastro();
		
		
		if (resultSet.next()) {
			beanCadastro.setId(resultSet.getLong("id"));
			beanCadastro.setNome(resultSet.getString("nome"));
			beanCadastro.setSenha(resultSet.getString("senha"));
			beanCadastro.setEmail(resultSet.getString("email"));

		}
		return beanCadastro;
	}

	public void atualizar(BeanCadastro usuario) {
		try {
			String sql = "update usuario set nome = ?, email = ?, senha = ? where id = " + usuario.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());

			preparedStatement.executeUpdate();

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	public void salvarTelefone(BeanTelefone telefone) {

		try {

			String sql = "INSERT INTO telefoneuser(ddd, numero, tipo, usuariopessoa) VALUES (?, ?, ?, ?)";

			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setLong(1, telefone.getDdd());
			insert.setString(2, telefone.getNumero());
			insert.setString(3, telefone.getTipo());
			insert.setLong(4, telefone.getIdUsuario());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<BeanUsuarioFone> listaUsuarioFone(Long idUser) {
		List<BeanUsuarioFone> beanUsuarioFones = new ArrayList<>();

		String sql = " select nome, email, ddd, numero, tipo from telefoneuser as fone ";
		sql += "inner join usuario as userp ";
		sql += " on fone.usuariopessoa = userp.id ";
		sql += "where userp.id = " + idUser;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				BeanUsuarioFone beanUsuarioFone = new BeanUsuarioFone();
				beanUsuarioFone.setNome(resultSet.getString("nome"));
				beanUsuarioFone.setEmail(resultSet.getString("email"));
				beanUsuarioFone.setDdd(resultSet.getLong("ddd"));
				beanUsuarioFone.setNumero(resultSet.getString("numero"));
				beanUsuarioFone.setTipo(resultSet.getString("tipo"));
				beanUsuarioFones.add(beanUsuarioFone);
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return beanUsuarioFones;
	}

	public void deleteFonesByUser(Long idUser) {
		try {

			String sqlFone = "delete from telefoneuser where usuariopessoa = " + idUser;
			String sqlUser = "delete from usuario where id = " + idUser;

			PreparedStatement statement1 = connection.prepareStatement(sqlFone);
			statement1.executeUpdate();
			connection.commit();

			PreparedStatement statement2 = connection.prepareStatement(sqlUser);
			statement2.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	}

}
