/*
* IRepositorioCliente.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.endereco;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.EnderecoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.EnderecoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.EnderecosVazioException;

public interface IRepositorioEndereco {
	public void cadastrar(Endereco endereco) throws EnderecoJaCadastradoException;
	public void atualizar(Endereco endereco) throws EnderecoNaoEncontradoException;
	public void remover(int id) throws EnderecoNaoEncontradoException;
	public Endereco procurar(int id) throws EnderecoNaoEncontradoException;
	public boolean existe(int id);
	public ArrayList<Endereco> listar() throws EnderecosVazioException;
	public boolean listaVazia();
}
