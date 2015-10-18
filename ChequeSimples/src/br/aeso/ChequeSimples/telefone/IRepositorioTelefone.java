/*
* IRepositorioCliente.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.telefone;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.TelefoneJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.TelefoneNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.TelefonesVazioException;

public interface IRepositorioTelefone {
	public void cadastrar(Telefone telefone) throws TelefoneJaCadastradoException;
	public void atualizar(Telefone telefone) throws TelefoneNaoEncontradoException;
	public void remover(String ddd, String telefone) throws TelefoneNaoEncontradoException;
	public Telefone procurar(String ddd, String telefone) throws TelefoneNaoEncontradoException;
	public boolean existe(String ddd, String telefone);
	public ArrayList<Telefone> listar() throws TelefonesVazioException;
	public boolean listaVazia();
}
