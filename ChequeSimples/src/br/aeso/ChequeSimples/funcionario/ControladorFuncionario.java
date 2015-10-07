package br.aeso.ChequeSimples.funcionario;
import java.io.IOException;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.FuncionarioJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.FuncionariosVazioException;

public class ControladorFuncionario {
	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario() throws IOException {
		this.repositorioFuncionario = new RepositorioFuncionarioArrayList();
	}
	
	public void cadastrar(Funcionario funcionario) throws IllegalArgumentException, FuncionarioJaCadastradoException, CampoObrigatorioInvalidoException {
		//Validações das informações.
		if (funcionario == null) {
			throw new IllegalArgumentException("Funcionario nulo.");
		}else if (funcionario.getNome() == "") {
			throw new CampoObrigatorioInvalidoException("Nome do funcionario é nulo ou Inválido.");
		}else{
		//Cadastrando o funcionario.
			this.repositorioFuncionario.cadastrar(funcionario);
	    }
	}
	
	public void atualizar(Funcionario funcionario) throws CampoObrigatorioInvalidoException, FuncionarioNaoEncontradoException {
		//Validações da classe Funcionario.
		if (funcionario.getNome() == "") {
			throw new CampoObrigatorioInvalidoException("Nome do funcionario é nulo ou Inválido.");
		}else{
			this.repositorioFuncionario.atualizar(funcionario);
		}
	}
	
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		// Validações da classe Funcionario.
		Funcionario funcionario = this.procurar(cpf);
		this.repositorioFuncionario.remover(cpf);
	}
	
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario funcionario = null;
		// Validações da classe Funcionario.
		
		funcionario = this.repositorioFuncionario.procurar(cpf);
		return funcionario;
	}
	
	public ArrayList<Funcionario> listar() throws FuncionariosVazioException {
		ArrayList<Funcionario> funcionarios = null;

		funcionarios =  this.repositorioFuncionario.listar();

		return funcionarios;
	}
	
	public boolean listaVazia(){
		boolean resposta = this.repositorioFuncionario.listaVazia();
		return resposta;
	}
}

