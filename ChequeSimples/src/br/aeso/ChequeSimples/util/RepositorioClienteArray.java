/*
* RepositorioClienteArray.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.util;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;

public class RepositorioClienteArray 
	implements IRepositorioFuncionario {
    private Cliente[] clientes;
    private int indice;
    public static final int TAMANHO_DAFAULT = 100;
    
    public RepositorioClienteArray() {
        clientes = new Cliente[TAMANHO_DAFAULT];
        indice = 0;
    }
    /**
     * Propositadamente com visibilidade default
     */
    RepositorioClienteArray(Cliente[] clientes, int indice) {
        this.clientes = clientes;
        this.indice = indice;
    }
	/**
	* Método que cadastrar um objeto de classe Cliente no Repositório
	*
	* @param Objeto da Classe Cliente.
	* @return void
	* @throws ClienteJaCadastradoException  
	*/
    public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
    	// Verifica se o cliente existe no repositório
    	if (this.existe(cliente.getCpf())) throw new ClienteJaCadastradoException();
		
    	cliente.setId(this.indice);
		clientes[this.indice] = cliente;
		this.indice = this.indice + 1;
    }
	/**
	* Método que remove um objeto de classe Cliente no Repositório
	*
	* @param Objeto da Classe Cliente.
	* @return void
	* @throws ClienteNaoEncontradoException 
	*/
    public void remover(String cpf) throws ClienteNaoEncontradoException {
        int i = getIndice(cpf);
        if (i == -1) throw new ClienteNaoEncontradoException();
        clientes[i] = clientes[indice-1];
        indice = indice - 1;
        clientes[indice] = null;
    }
	/**
	* Método que procura um objeto de classe Cliente no Repositório
	*
	* @param CPF Cliente.
	* @return Cliente
	* @throws ClienteNaoEncontradoException 
	*/
    public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
    	Cliente cliente = null;
        int i = getIndice(cpf);
        if (i == -1) throw new ClienteNaoEncontradoException();
        
        return clientes[i];
        
    }
	/**
	* Método que atualiza um objeto de classe Cliente no Repositório
	*
	* @param Objeto da Classe Cliente.
	* @return Cliente
	* @throws ClienteNaoEncontradoException 
	*/
    public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
        int i = getIndice(cliente.getCpf());
        if (i == -1) throw new ClienteNaoEncontradoException();
        clientes[i] = cliente;
    }
	/**
	* Método que verifica se um objeto de classe Cliente existe no Repositório
	*
	* @param CPF Cliente.
	* @return Boolean
	* @throws  
	*/
    public boolean existe(String cpf) {
        boolean resposta;
            if (getIndice(cpf) >= 0) resposta = true;
            else resposta = false;
        return resposta;
    }
    
	/**
	* Método que lista objetos de classe Cliente no Repositório
	*
	* @param 
	* @return ArrayList<Cliente>
	* @throws  
	*/
    public ArrayList<Cliente> listar() { 
    	ArrayList<Cliente> lista = new ArrayList<Cliente>();
    	for (int i = 0; i < indice; i = i + 1) {
            lista.add(clientes[i]);
        }
    	return lista;
    }
    
	/**
	* Método que retorna um indice valido para o Repositório
	*
	* @param CPF do Cliente
	* @return int
	* @throws  
	*/
    private int getIndice(String cpf) {
        int resposta = -1;
        boolean achou = false;
        for (int i = 0; !achou && (i < indice); i = i + 1) {
            if (clientes[i].getCpf().equals(cpf)) {
                resposta = i;
                achou = true;
            }
        }
        return resposta;
    }
}