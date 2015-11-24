package br.aeso.ChequeSimples.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public class RepositorioClienteBDR implements IRepositorioCliente {
	private Connection conexao;

	public RepositorioClienteBDR() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/chequesimplesbdr", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		// Verifica se o cliente já existe no repositório
		if (!this.existe(cliente.getCpf_cnpj()))
			throw new ClienteJaCadastradoException();
		// Criando a String SQL
		String sql = "insert into clientes (pessoa, cpf_cnpj, nome_razaoSocial, bloqueado) values (?, ?, ?, ?)";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		try {
			preStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Atualizando o primeiro parametro
			preStatement.setString(1, cliente.getPessoa());
			preStatement.setString(2, cliente.getCpf_cnpj());
			preStatement.setString(3, cliente.getNome_razaoSocial());
			preStatement.setInt(4, cliente.getBloqueado());
			preStatement.execute();
			// Retorna um ResultSet com todas as chaves geradas
			resultSet = preStatement.getGeneratedKeys();
			Integer clienteId = 0;
			// Pegando o identificador gerado a partir do último insert
			while (resultSet.next()) {
				clienteId = resultSet.getInt(1);
			}
			cliente.setId(clienteId);

			
			
			// Fechando conexões
			preStatement.close();
			resultSet.close();
			conexao.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		int i = getIndice(cliente.getCpf_cnpj());
		if (i == -1){
			throw new ClienteNaoEncontradoException();
		} else {
			try {
				String sql = "update cliente set pessoa = ?, cpf_cnpj = ?, nome_razaoSocial = ?, bloqueado = ? where idCliente = ?";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				
				preStatement.setString(1, cliente.getPessoa());
				preStatement.setString(2, cliente.getCpf_cnpj());
				preStatement.setString(3, cliente.getNome_razaoSocial());
				preStatement.setByte(4, cliente.getBloqueado());
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
	public void remover(String cpf_cnpj) throws ClienteNaoEncontradoException {
		int i = getIndice(cpf_cnpj);
		if (i == -1) {
			throw new ClienteNaoEncontradoException();
		} else {
			try {
				String sql = "delete from clientes where cliente_id = ?";
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
	public ArrayList<Cliente> listar() throws ClientesVazioException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		if (listaVazia() == true) {
			throw new ClientesVazioException();
		} else {
			try {
				String sql = "select * from clientes";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				ResultSet resultSet = preStatement.executeQuery();

				while (resultSet.next()) {
					Cliente cliente = new Cliente(null, null, null, (byte) 0);
					cliente.setId(resultSet.getInt(1));
					cliente.setPessoa(resultSet.getString(2));
					cliente.setCpf_cnpj(resultSet.getString(3));
					cliente.setPessoa(resultSet.getString(4));
					cliente.setBloqueado(resultSet.getByte(5));

					clientes.add(cliente);
				}

				// Fechando conexões
				preStatement.close();
				resultSet.close();
				conexao.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			return clientes;
		}
	}

	@Override
	public Cliente procurar(String cpf_cnpj) throws ClienteNaoEncontradoException {
		Cliente cliente = new Cliente(null, null, null, (byte) 0);
		int i = getIndice(cpf_cnpj);
		if (i == -1) {
			throw new ClienteNaoEncontradoException();
		} else {
			try {
				String sql = "select * from clientes where cpf_cnpj = ?";
				PreparedStatement preStatement = conexao.prepareStatement(sql);
				preStatement.setString(1, cpf_cnpj);
				ResultSet resultSet = preStatement.executeQuery();

				if (resultSet.next()) {
					cliente.setId(resultSet.getInt(1));
					cliente.setPessoa(resultSet.getString(2));
					cliente.setCpf_cnpj(resultSet.getString(3));
					cliente.setPessoa(resultSet.getString(4));
					cliente.setBloqueado(resultSet.getByte(5));
				}

				// Fechando conexões
				preStatement.close();
				resultSet.close();
				conexao.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return cliente;
	}

	@Override
	public boolean existe(String cpf_cnpj) {
		boolean resposta;
		if (getIndice(cpf_cnpj) < 0)
			resposta = true;
		else
			resposta = false;
		return resposta;
	}

	private int getIndice(String cpf_cnpj) {
		int resposta = -1;

		try {
			String sql = "select * from clientes where cpf_cnpj = ?";
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
			String sql = "select * from clientes";
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
