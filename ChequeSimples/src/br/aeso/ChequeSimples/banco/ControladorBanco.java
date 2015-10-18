package br.aeso.ChequeSimples.banco;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.BancoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;

public class ControladorBanco {
	private IRepositorioBanco repositorioBanco;
	
	public ControladorBanco() {
		this.repositorioBanco = new RepositorioBancoArrayList();
	}
	
	public void cadastrar(Banco banco) throws IllegalArgumentException, BancoJaCadastradoException, CampoObrigatorioInvalidoException {
		//Validações das informações.
		if (banco == null) {
			throw new IllegalArgumentException("Banco nulo.");
		}else if (banco.getNome() == "") {
			throw new CampoObrigatorioInvalidoException("Nome do banco é nulo ou Inválido.");
		}else{
		//Cadastrando o banco.
			this.repositorioBanco.cadastrar(banco);
	    }
	}
	
	public void atualizar(Banco banco) throws CampoObrigatorioInvalidoException, BancoNaoEncontradoException {
		//Validações da classe Banco.
		if (banco.getNome() == "") {
			throw new CampoObrigatorioInvalidoException("Nome do banco é nulo ou Inválido.");
		}else{
			this.repositorioBanco.atualizar(banco);
		}
	}
	
	public void remover(String codigo) throws BancoNaoEncontradoException {
		// Validações da classe Banco.
		Banco banco = this.procurar(codigo);
		this.repositorioBanco.remover(codigo);
	}
	
	public Banco procurar(String codigo) throws BancoNaoEncontradoException {
		Banco banco = null;
		// Validações da classe Banco.
		
		banco = this.repositorioBanco.procurar(codigo);
		return banco;
	}
	
	public ArrayList<Banco> listar() throws BancosVazioException {
		ArrayList<Banco> bancos = null;

		bancos =  this.repositorioBanco.listar();

		return bancos;
	}
	
	public boolean listaVazia(){
		boolean resposta = this.repositorioBanco.listaVazia();
		return resposta;
	}
}

