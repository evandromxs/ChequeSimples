package br.aeso.ChequeSimples.cliente;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public class RepositorioClienteBDR implements IRepositorioCliente {
	private ArrayList<Cliente> clientes;
	
	public RepositorioClienteBDR() {
		clientes = new ArrayList<Cliente>();
	}
	
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
	  	// Verifica se o cliente existe no repositório
    	if (existe(cliente.getCpf())) throw new ClienteJaCadastradoException();
		
		clientes.add(cliente);
		cliente.setId(clientes.indexOf(cliente));
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
