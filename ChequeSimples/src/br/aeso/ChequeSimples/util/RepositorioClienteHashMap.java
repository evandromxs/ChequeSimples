package br.aeso.ChequeSimples.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;

public class RepositorioClienteHashMap implements IRepositorioFuncionario {
	private Map<Integer, Cliente> clientes;
	private int indice;
	
	public RepositorioClienteHashMap() {
		clientes = new HashMap<>();
	}
	
    RepositorioClienteHashMap(HashMap<Integer, Cliente> clientes, int indice) {
        this.clientes = clientes;
        this.indice = indice;
    }
	
	@Override
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
	  	// Verifica se o cliente existe no repositório
    	if (this.existe(cliente.getCpf())) throw new ClienteJaCadastradoException();
		
    	cliente.setId(this.indice);
		clientes.put(indice, cliente);
		this.indice = this.indice + 1;
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
        int i = getIndice(cliente.getCpf());
        if (i == -1) throw new ClienteNaoEncontradoException();
        clientes.replace(i, cliente);
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		 int i = getIndice(cpf);
	        if (i == -1) throw new ClienteNaoEncontradoException();
	       clientes.remove(i);
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

	@Override
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> ListTemp = new ArrayList<Cliente>();
		Set<Integer> chaves = clientes.keySet();
		for(Integer c : chaves){
			int i = 0;
			ListTemp.add(clientes.get(c));
			i++;
		}
		
		
		return ListTemp;
	}

	private int getIndice(String cpf) {
	        int resposta = -1;
	        
	        Set<Integer> chaves = clientes.keySet();
	        for(Integer c : chaves){
	            if (clientes.get(c).getCpf().equals(cpf)) {
	                resposta = clientes.get(c).getId();
	            }
	        }
	        return resposta;
	    }
}
