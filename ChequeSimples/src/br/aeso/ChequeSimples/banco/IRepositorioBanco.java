/*
* IRepositorioCliente.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.banco;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.BancoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.BancosVazioException;

public interface IRepositorioBanco {
	public void cadastrar(Banco banco) throws BancoJaCadastradoException;
	public void atualizar(Banco banco) throws BancoNaoEncontradoException;
	public void remover(String codigo) throws BancoNaoEncontradoException;
	public Banco procurar(String codigo) throws BancoNaoEncontradoException;
	public boolean existe(String codigo);
	public ArrayList<Banco> listar() throws BancosVazioException;
	public boolean listaVazia();
}
