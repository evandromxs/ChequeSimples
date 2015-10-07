/*
* IRepositorioFuncionario.java
* Versão: 1.0
* Data de Criação : 12/02/2015
*
*/
package br.aeso.ChequeSimples.funcionario;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.FuncionarioJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.FuncionariosVazioException;

public interface IRepositorioFuncionario {
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException;
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public void remover(String cpf) throws FuncionarioNaoEncontradoException;
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException;
	public boolean existe(String cpf);
	public ArrayList<Funcionario> listar() throws FuncionariosVazioException;
	public boolean listaVazia();
}
