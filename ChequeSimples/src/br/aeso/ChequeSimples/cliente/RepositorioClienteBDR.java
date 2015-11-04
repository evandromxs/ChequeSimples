package br.aeso.ChequeSimples.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public class RepositorioClienteBDR implements IRepositorioCliente {
	private Connection conexao;
	
	public RepositorioClienteBDR() {
    	try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/aula11", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		// Verifica se o cliente já existe no repositório
		if (!this.existe(cliente.getCpf())) throw new ClienteJaCadastradoException();
        // Criando a String SQL
        String sql ="insert into cliente (nome, cpf, banco) values (?, ?, ?)";
 
        // Criar o PreparedStatement, objeto para executar a query
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
		try {
			preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
	        // Atualizando o primeiro parametro
	        preStatement.setString(1, cliente.getNome());
	        preStatement.setString(2, cliente.getCpf());
	        preStatement.setString(3, cliente.getBanco());
	        preStatement.execute();
	        // Retorna um ResultSet com todas as chaves geradas
	        resultSet = preStatement.getGeneratedKeys();
	        Integer clienteId = 0;
	        // Pegando o identificador gerado a partir do último insert
	        while(resultSet.next()) {
	        	clienteId = resultSet.getInt(1);
	        }
	        cliente.setCodigo(clienteId);
	        
	        // Fechando conexões
	        preStatement.close();
	        resultSet.close();
	        
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
        int i = getIndice(cliente.getCpf());
        if (i == -1) throw new ClienteNaoEncontradoException();
        clientes.set(i, cliente);
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		 int i = getIndice(cpf);
	        if (i == -1) throw new ClienteNaoEncontradoException();
	       clientes.remove(i);
	}

	@Override
	public ArrayList<Cliente> listar() throws ClientesVazioException {
		if(listaVazia() == true){
			throw new ClientesVazioException();
		}else{
			return clientes;
		}
	}
	
	@Override
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
        int i = getIndice(cpf);
        if (i == -1) throw new ClienteNaoEncontradoException();
        
        return clientes.get(i);
	}

	@Override
	public boolean existe(String cpf) {
	boolean resposta;
          if (getIndice(cpf) >= 0) resposta = true;
          else resposta = false;
      return resposta;
	}

	private int getIndice(String cpf) {
	        int resposta = -1;
	        for(Cliente c : clientes){
	            if (c.getCpf().equals(cpf)) {
	                resposta = c.getId();
	            }
	        }
	        return resposta;
	    }
	
	public boolean listaVazia(){
		if(clientes.isEmpty() == true){
			return true;
		}else{
			return false;
		}
	}
}
