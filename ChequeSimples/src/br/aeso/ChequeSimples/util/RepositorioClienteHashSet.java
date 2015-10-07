package br.aeso.ChequeSimples.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;

public class RepositorioClienteHashSet implements IRepositorioFuncionario {
	private Set<Cliente> clientes;
	private int indice;
	
	public RepositorioClienteHashSet() {
		clientes = new HashSet<Cliente>();
	}
	
    RepositorioClienteHashSet(Set<Cliente> clientes, int indice) {
        this.clientes = clientes;
        this.indice = indice;
    }
	
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
	  	// Verifica se o cliente existe no repositório
    	if (this.existe(cliente.getCpf())) throw new ClienteJaCadastradoException();
		
    	cliente.setId(this.indice);
		clientes.add(cliente);
		this.indice = this.indice + 1;
		}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
        int i = getIndice(cliente.getCpf());
        if (i == -1) throw new ClienteNaoEncontradoException();
        for(Cliente c : clientes){
        	c = cliente;
        }
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		 int i = getIndice(cpf);
	        if (i == -1) throw new ClienteNaoEncontradoException();
	       clientes.remove(i);
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		Cliente cliente = null;
		int i = getIndice(cpf);
        if (i == -1) throw new ClienteNaoEncontradoException();
        	for(Cliente c : clientes){
        		if(c.getCpf().equals(cpf)){
        			return c;
        		}
        	}
        throw new ClienteNaoEncontradoException();
	}

	@Override
	public boolean existe(String cpf) {
	boolean resposta;
          if (getIndice(cpf) >= 0) resposta = true;
          else resposta = false;
      return resposta;
	}

	@Override

	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> ListTemp = new ArrayList<Cliente>();
		for(Cliente c : clientes){
			int i = 0;
			ListTemp.add(c);
			i++;
		}
		
		
		return ListTemp;
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
}
