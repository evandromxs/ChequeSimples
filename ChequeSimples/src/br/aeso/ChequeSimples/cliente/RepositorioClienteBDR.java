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
		if (!this.existe(cliente.getCpf_cnpj())) throw new ClienteJaCadastradoException();
        // Criando a String SQL
        String sql ="insert into cliente (pessoa, cpf_cnpj, nome_razaoSocial, bloqueado) values (?, ?, ?, ?)";
 
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
	        while(resultSet.next()) {
	        	clienteId = resultSet.getInt(1);
	        }
	        cliente.setId(clienteId);
	        
	        // Fechando conexões
	        preStatement.close();
	        resultSet.close();
	        
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
        int i = getIndice(cliente.getCpf_cnpj());
        if (i == -1) throw new ClienteNaoEncontradoException();
       // clientes.set(i, cliente);
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		 int i = getIndice(cpf);
	        if (i == -1) throw new ClienteNaoEncontradoException();
	       //clientes.remove(i);
	}

	@Override
	public ArrayList<Cliente> listar() throws ClientesVazioException {
		if(listaVazia() == true){
			throw new ClientesVazioException();
		}else{
			//return clientes;
			return null;
		}
	}
	
	@Override
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
        int i = getIndice(cpf);
        if (i == -1) throw new ClienteNaoEncontradoException();
        
        //return clientes.get(i);
        return null;
	}

	@Override
	public boolean existe(String cpf) {
	boolean resposta;
          if (getIndice(cpf) >= 0) resposta = true;
          else resposta = false;
      return resposta;
	}

	private int getIndice(String cpf_cnpj) {
	        int resposta = -1;

	        String sql ="select * from cliente where cpf_cnpj = ?";
	        // Criar o PreparedStatement, objeto para executar a query
	        PreparedStatement preStatement = conexao.prepareStatement(sql);
	        
	        preStatement.setInt(1, 2);
	        // Executando o select
	        ResultSet resultSet = preStatement.executeQuery();
	        
	        while(resultSet.next()){
	        	if(resultSet.getString(3).eq){
	        		resultSet.getString(1);
	        	}
	        }
	        
	        
	        
	        
	        
//	        for(Cliente c : clientes){
//	            if (c.getCpf().equals(cpf)) {
//	                resposta = c.getId();
//	            }
//	        }
	        return resposta;
	    }
	
	public boolean listaVazia(){
//		if(clientes.isEmpty() == true){
//			return true;
//		}else{
//			return false;
//		}
		return true;
	}
}
