/*
* IRepositorioCheque.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.cheque;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.ChequeJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequeNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ChequesVazioException;

public interface IRepositorioCheque {
	public void cadastrar(Cheque cheque) throws ChequeJaCadastradoException;
	public void atualizar(Cheque cheque) throws ChequeNaoEncontradoException;
	public void remover(String numero) throws ChequeNaoEncontradoException;
	public Cheque procurar(String numero) throws ChequeNaoEncontradoException;
	public boolean existe(String numero);
	public ArrayList<Cheque> listar() throws ChequesVazioException;
	public boolean listaVazia();
}
