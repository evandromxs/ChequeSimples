package br.aeso.ChequeSimples.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.EnderecoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.EnderecoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.EnderecosVazioException;

public class RepositorioEnderecoBDR implements IRepositorioEndereco {
	private Connection conexao;

	public RepositorioEnderecoBDR() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/chequesimplesbdr", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void cadastrar(Endereco endereco) throws EnderecoJaCadastradoException {
		// Verifica se o endereco já existe no repositório
		if (!this.existe(endereco.getCpf_cnpj()))
			throw new EnderecoJaCadastradoException();
		// Criando a String SQL
		String sql = "insert into enderecos (pessoa, cpf_cnpj, nome_razaoSocial, bloqueado) values (?, ?, ?, ?)";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		try {
			preStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Atualizando o primeiro parametro
			preStatement.setString(1, endereco.getPessoa());
			preStatement.setString(2, endereco.getCpf_cnpj());
			preStatement.setString(3, endereco.getNome_razaoSocial());
			preStatement.setInt(4, endereco.getBloqueado());
			preStatement.execute();
			// Retorna um ResultSet com todas as chaves geradas
			resultSet = preStatement.getGeneratedKeys();
			Integer enderecoId = 0;
			// Pegando o identificador gerado a partir do último insert
			while (resultSet.next()) {
				enderecoId = resultSet.getInt(1);
			}
			endereco.setId(enderecoId);

			
			
			// Fechando conexões
			preStatement.close();
			resultSet.close();
			conexao.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Endereco endereco) throws EnderecoNaoEncontradoException {
		int i = getIndice(endereco.getCpf_cnpj());
		if (i == -1){
			throw new EnderecoNaoEncontradoException();
		} else {
			try {
				String sql = "update endereco set pessoa = ?, cpf_cnpj = ?, nome_razaoSocial = ?, bloqueado = ? where idEndereco = ?";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				
				preStatement.setString(1, endereco.getPessoa());
				preStatement.setString(2, endereco.getCpf_cnpj());
				preStatement.setString(3, endereco.getNome_razaoSocial());
				preStatement.setByte(4, endereco.getBloqueado());
				preStatement.setInt(5, i);
				
				preStatement.executeUpdate();

				// Fechando conexões
				preStatement.close();
				conexao.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void remover(String cpf_cnpj) throws EnderecoNaoEncontradoException {
		int i = getIndice(cpf_cnpj);
		if (i == -1) {
			throw new EnderecoNaoEncontradoException();
		} else {
			try {
				String sql = "delete from enderecos where endereco_id = ?";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				preStatement.setInt(1, i);
				preStatement.executeUpdate();

				// Fechando conexões
				preStatement.close();
				conexao.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public ArrayList<Endereco> listar() throws EnderecosVazioException {
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		if (listaVazia() == true) {
			throw new EnderecosVazioException();
		} else {
			try {
				String sql = "select * from enderecos";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				ResultSet resultSet = preStatement.executeQuery();

				while (resultSet.next()) {
					Endereco endereco = new Endereco(null, null, null, (byte) 0);
					endereco.setId(resultSet.getInt(1));
					endereco.setPessoa(resultSet.getString(2));
					endereco.setCpf_cnpj(resultSet.getString(3));
					endereco.setPessoa(resultSet.getString(4));
					endereco.setBloqueado(resultSet.getByte(5));

					enderecos.add(endereco);
				}

				// Fechando conexões
				preStatement.close();
				resultSet.close();
				conexao.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			return enderecos;
		}
	}

	@Override
	public Endereco procurar(int idCliente) throws EnderecoNaoEncontradoException {
		Endereco endereco = new Endereco((byte) 0, null, null, null, null, null, null, null, null);
		int i = getIndice(idCliente);
		if (i == -1) {
			throw new EnderecoNaoEncontradoException();
		} else {
			try {
				String sql = "select * from enderecos where idCliente = ?";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				preStatement.setString(1, cpf_cnpj);
				ResultSet resultSet = preStatement.executeQuery();

				if (resultSet.next()) {
					endereco.setId(resultSet.getInt(1));
					endereco.setPessoa(resultSet.getString(2));
					endereco.setCpf_cnpj(resultSet.getString(3));
					endereco.setPessoa(resultSet.getString(4));
					endereco.setBloqueado(resultSet.getByte(5));
				}

				// Fechando conexões
				preStatement.close();
				resultSet.close();
				conexao.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return endereco;
	}

	@Override
	public boolean existe(int id) {
		boolean resposta;
		if (getIndice(id) < 0)
			resposta = true;
		else
			resposta = false;
		return resposta;
	}

	private int getIndice(String cpf_cnpj) {
		int resposta = -1;

		try {
			String sql = "select * from enderecos where cpf_cnpj = ?";
			PreparedStatement preStatement = conexao.prepareStatement(sql);
			preStatement.setString(1, cpf_cnpj);
			ResultSet resultSet = preStatement.executeQuery();

			while (resultSet.next()) {
				resposta = resultSet.getInt(3);
			}

			// Fechando conexões
			preStatement.close();
			resultSet.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resposta;
	}

	public boolean listaVazia() {
		boolean resposta = false;
		try {
			String sql = "select * from enderecos";
			PreparedStatement preStatement = conexao.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();

			if (resultSet.next() == false) {
				resposta = true;
			}

			// Fechando conexões
			preStatement.close();
			resultSet.close();
			conexao.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resposta;
	}
}
