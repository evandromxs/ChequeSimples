package br.aeso.ChequeSimples.telefone;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.TelefoneJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.TelefoneNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.TelefonesVazioException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;

public class ControladorTelefone {
	private IRepositorioTelefone repositorioTelefone;
	
	public ControladorTelefone() {
		this.repositorioTelefone = new RepositorioTelefoneArrayList();
	}
	
	public void cadastrar(Telefone telefone) throws IllegalArgumentException, TelefoneJaCadastradoException, CampoObrigatorioInvalidoException {
		//Valida��es das informa��es.
		if (telefone == null) {
			throw new IllegalArgumentException("Telefone nulo.");
		}else if ((telefone.getDdd() == "") || (telefone.getTelefone() == "")) {
			throw new CampoObrigatorioInvalidoException("DDD ou n�mero de telefone � nulo ou Inv�lido.");
		}else{
		//Cadastrando o telefone.
			this.repositorioTelefone.cadastrar(telefone);
	    }
	}
	
	public void atualizar(Telefone telefone) throws CampoObrigatorioInvalidoException, TelefoneNaoEncontradoException {
		//Valida��es da classe Telefone.
		if ((telefone.getDdd() == "") || (telefone.getTelefone() == "")) {
			throw new CampoObrigatorioInvalidoException("DDD ou n�mero de telefone � nulo ou Inv�lido.");
		}else{
			this.repositorioTelefone.atualizar(telefone);
		}
	}
	
	public void remover(String ddd, String telefone) throws TelefoneNaoEncontradoException {
		// Valida��es da classe Telefone.
		Telefone telefoneObj = this.procurar(ddd, telefone);
		this.repositorioTelefone.remover(ddd, telefone);
	}
	
	public Telefone procurar(String ddd, String telefone) throws TelefoneNaoEncontradoException {
		Telefone telefoneObj = null;
		// Valida��es da classe Telefone.
		
		telefoneObj = this.repositorioTelefone.procurar(ddd, telefone);
		return telefoneObj;
	}
	
	public ArrayList<Telefone> listar() throws TelefonesVazioException {
		ArrayList<Telefone> telefones = null;

		telefones =  this.repositorioTelefone.listar();

		return telefones;
	}
	
	public boolean listaVazia(){
		boolean resposta = this.repositorioTelefone.listaVazia();
		return resposta;
	}
}

