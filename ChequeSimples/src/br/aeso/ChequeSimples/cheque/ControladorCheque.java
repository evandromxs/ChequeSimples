package br.aeso.ChequeSimples.cheque;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.ChequeJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequeNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.ChequesVazioException;

public class ControladorCheque {
	private IRepositorioCheque repositorioCheque;
	
	public ControladorCheque() {
		this.repositorioCheque = new RepositorioChequeArrayList();
	}
	
	public void cadastrar(Cheque cheque) throws IllegalArgumentException, ChequeJaCadastradoException, CampoObrigatorioInvalidoException {
		//Validações das informações.
		if (cheque == null) {
			throw new IllegalArgumentException("Cheque nulo.");
		}else if (cheque.getNumero() == "") {
			throw new CampoObrigatorioInvalidoException("Número do cheque é nulo ou Inválido.");
		}else{
		//Cadastrando o cheque.
			this.repositorioCheque.cadastrar(cheque);
	    }
	}
	
	public void atualizar(Cheque cheque) throws CampoObrigatorioInvalidoException, ChequeNaoEncontradoException {
		//Validações da classe Cheque.
		if (cheque.getNumero() == "") {
			throw new CampoObrigatorioInvalidoException("Número do cheque é nulo ou Inválido.");
		}else{
			this.repositorioCheque.atualizar(cheque);
		}
	}
	
	public void remover(String numero) throws ChequeNaoEncontradoException {
		// Validações da classe Cheque.
		Cheque cheque = this.procurar(numero);
		this.repositorioCheque.remover(numero);
	}
	
	public Cheque procurar(String numero) throws ChequeNaoEncontradoException {
		Cheque cheque = null;
		// Validações da classe Cheque.
		
		cheque = this.repositorioCheque.procurar(numero);
		return cheque;
	}
	
	public ArrayList<Cheque> listar() throws ChequesVazioException {
		ArrayList<Cheque> cheques = null;

		cheques =  this.repositorioCheque.listar();

		return cheques;
	}
	
	public boolean listaVazia(){
		boolean resposta = this.repositorioCheque.listaVazia();
		return resposta;
	}
}

