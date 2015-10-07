/*
* IRepositorioCliente.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.cliente;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException;
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public void remover(String cpf) throws ClienteNaoEncontradoException;
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
	public boolean existe(String cpf);
	public ArrayList<Cliente> listar() throws ClientesVazioException;
	public boolean listaVazia();
}
