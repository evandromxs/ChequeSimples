package br.aeso.ChequeSimples.cliente;

import java.sql.Connection;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public class RepositorioClienteArrayList implements IRepositorioCliente {
	private ArrayList<Cliente> clientes;
	
	public RepositorioClienteArrayList() {
		clientes = new ArrayList<Cliente>();
	}
	
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
	  	// Verifica se o cliente existe no repositório
    	if (existe(cliente.getCpf())){
    		throw new ClienteJaCadastradoException();
    	} 
		
		clientes.add(cliente);
		cliente.setId(clientes.indexOf(cliente));
		
		/*
		String sql = "INSERT INTO cliente (razao_social) VALUES (?)";
		
		PreparedStatement prepSt = null;
	
		prepSt = preparedStatement(sql);
		
		prepSt.setString(1, cliente.getNome());
		
		prepSt.executeUpdate();
		*/
		
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
