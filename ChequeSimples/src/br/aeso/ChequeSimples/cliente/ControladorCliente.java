package br.aeso.ChequeSimples.cliente;
import java.io.IOException;
import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws IOException {
		this.repositorioCliente = new RepositorioClienteArrayList();
	}
	
	public void cadastrar(Cliente cliente) throws IllegalArgumentException, ClienteJaCadastradoException, CampoObrigatorioInvalidoException {
		//Validações das informações.
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente nulo.");
		}else if (cliente.getNome() == "") {
			throw new CampoObrigatorioInvalidoException("Nome do cliente é nulo ou Inválido.");
		}else{
		//Cadastrando o cliente.
			this.repositorioCliente.cadastrar(cliente);
	    }
	}
	
	public void atualizar(Cliente cliente) throws CampoObrigatorioInvalidoException, ClienteNaoEncontradoException {
		//Validações da classe Cliente.
		if (cliente.getNome() == "") {
			throw new CampoObrigatorioInvalidoException("Nome do cliente é nulo ou Inválido.");
		}else{
			this.repositorioCliente.atualizar(cliente);
		}
	}
	
	public void remover(String codigo) throws ClienteNaoEncontradoException {
		// Validações da classe Cliente.
		Cliente cliente = this.procurar(codigo);
		this.repositorioCliente.remover(codigo);
	}
	
	public Cliente procurar(String codigo) throws ClienteNaoEncontradoException {
		Cliente cliente = null;
		// Validações da classe Cliente.
		
		cliente = this.repositorioCliente.procurar(codigo);
		return cliente;
	}
	
	public ArrayList<Cliente> listar() throws ClientesVazioException {
		ArrayList<Cliente> clientes = null;

		clientes =  this.repositorioCliente.listar();

		return clientes;
	}
	
	public boolean listaVazia(){
		boolean resposta = this.repositorioCliente.listaVazia();
		return resposta;
	}
}

