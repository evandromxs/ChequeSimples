package br.aeso.ChequeSimples.endereco;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.EnderecoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.EnderecoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.EnderecosVazioException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;

public class ControladorEndereco {
	private IRepositorioEndereco repositorioEndereco;
	
	public ControladorEndereco() {
		this.repositorioEndereco = new RepositorioEnderecoArrayList();
	}
	
	public void cadastrar(Endereco endereco) throws IllegalArgumentException, EnderecoJaCadastradoException, CampoObrigatorioInvalidoException {
		//Valida��es das informa��es.
		if (endereco == null) {
			throw new IllegalArgumentException("Endereco nulo.");
		}else if (endereco.getLogradouro() == "") {
			throw new CampoObrigatorioInvalidoException("Logradouro do endereco � nulo ou Inv�lido.");
		}else if (endereco.getBairro() == "") {
			throw new CampoObrigatorioInvalidoException("Bairro do endereco � nulo ou Inv�lido.");
		}else if (endereco.getCidade() == "") {
			throw new CampoObrigatorioInvalidoException("Cidade do endereco � nulo ou Inv�lido.");
		}else if (endereco.getEstado() == "") {
			throw new CampoObrigatorioInvalidoException("Estado do endereco � nulo ou Inv�lido.");
		}else if (endereco.getCep() == "") {
			throw new CampoObrigatorioInvalidoException("Cep do endereco � nulo ou Inv�lido.");
		}else{
		//Cadastrando o endereco.
			this.repositorioEndereco.cadastrar(endereco);
	    }
	}
	
	public void atualizar(Endereco endereco) throws CampoObrigatorioInvalidoException, EnderecoNaoEncontradoException {
		//Valida��es da classe Endereco.
		if (endereco == null) {
			throw new IllegalArgumentException("Endereco nulo.");
		}else if (endereco.getLogradouro() == "") {
			throw new CampoObrigatorioInvalidoException("Logradouro do endereco � nulo ou Inv�lido.");
		}else if (endereco.getBairro() == "") {
			throw new CampoObrigatorioInvalidoException("Bairro do endereco � nulo ou Inv�lido.");
		}else if (endereco.getCidade() == "") {
			throw new CampoObrigatorioInvalidoException("Cidade do endereco � nulo ou Inv�lido.");
		}else if (endereco.getEstado() == "") {
			throw new CampoObrigatorioInvalidoException("Estado do endereco � nulo ou Inv�lido.");
		}else if (endereco.getCep() == "") {
			throw new CampoObrigatorioInvalidoException("Cep do endereco � nulo ou Inv�lido.");
		}else{
			this.repositorioEndereco.atualizar(endereco);
		}
	}
	
	public void remover(int id) throws EnderecoNaoEncontradoException {
		// Valida��es da classe Endereco.
		Endereco endereco = procurar(id);
		this.repositorioEndereco.remover(id);
	}
	
	public Endereco procurar(int id) throws EnderecoNaoEncontradoException {
		Endereco endereco = null;
		// Valida��es da classe Endereco.
		
		endereco = this.repositorioEndereco.procurar(id);
		return endereco;
	}
	
	public ArrayList<Endereco> listar() throws EnderecosVazioException {
		ArrayList<Endereco> enderecos = null;

		enderecos =  this.repositorioEndereco.listar();

		return enderecos;
	}
	
	public boolean listaVazia(){
		boolean resposta = this.repositorioEndereco.listaVazia();
		return resposta;
	}
}

