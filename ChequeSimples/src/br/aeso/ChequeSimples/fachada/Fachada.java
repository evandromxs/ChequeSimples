package br.aeso.ChequeSimples.fachada;
import java.io.IOException;
import java.util.ArrayList;

import br.aeso.ChequeSimples.banco.Banco;
import br.aeso.ChequeSimples.banco.ControladorBanco;
import br.aeso.ChequeSimples.cheque.Cheque;
import br.aeso.ChequeSimples.cheque.ControladorCheque;
import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.cliente.ControladorCliente;
import br.aeso.ChequeSimples.funcionario.ControladorFuncionario;
import br.aeso.ChequeSimples.funcionario.Funcionario;
import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.CPFInvalidoException;
import br.aeso.ChequeSimples.excecoes.BancoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequeJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequesVazioException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;
import br.aeso.ChequeSimples.excecoes.FuncionarioJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.BancoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ChequeNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.FuncionariosVazioException;
import br.aeso.ChequeSimples.excecoes.IdadeInvalidaException;

public class Fachada {
	private static Fachada instance;
	private ControladorBanco controladorBanco;
	private ControladorCheque controladorCheque;
	private ControladorCliente controladorCliente;
	private ControladorFuncionario controladorFuncionario;

	
	private Fachada() throws IOException {
		this.controladorBanco = new ControladorBanco();
		this.controladorCheque = new ControladorCheque();
		this.controladorCliente = new ControladorCliente();
		this.controladorFuncionario = new ControladorFuncionario();
	}
	
	public static Fachada getInstance() throws IOException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	//Métodos entidade Banco.
	public void cadastrarBanco(Banco banco) throws IllegalArgumentException, BancoJaCadastradoException, CampoObrigatorioInvalidoException { 
		this.controladorBanco.cadastrar(banco);
	}
	
	public void atualizarBanco(Banco banco) throws CampoObrigatorioInvalidoException, BancoNaoEncontradoException { 
		this.controladorBanco.atualizar(banco);
	}
	
	public void removerBanco(String codigo) throws BancoNaoEncontradoException { 
		this.controladorBanco.remover(codigo);
	}
	
	public Banco procurarBanco(String codigo) throws BancoNaoEncontradoException { 
		return this.controladorBanco.procurar(codigo);
	}
	
	public ArrayList<Banco> listarBanco() throws BancosVazioException { 
		return this.controladorBanco.listar();
	}
	
	public boolean listaVaziaBanco(){
		boolean resposta = this.controladorBanco.listaVazia();
		return resposta;
	}
	
	//Métodos entidade Cheque.
	public void cadastrarCheque(Cheque cheque) throws IllegalArgumentException,ChequeJaCadastradoException, CampoObrigatorioInvalidoException { 
		this.controladorCheque.cadastrar(cheque);
	}
	
	public void atualizarCheque(Cheque cheque) throws CPFInvalidoException, CampoObrigatorioInvalidoException, ChequeNaoEncontradoException { 
		this.controladorCheque.atualizar(cheque);
	}
	
	public void removerCheque(String numero) throws ChequeNaoEncontradoException { 
		this.controladorCheque.remover(numero);
	}
	
	public Cheque procurarCheque(String numero) throws ChequeNaoEncontradoException { 
		return this.controladorCheque.procurar(numero);
	}
	
	public ArrayList<Cheque> listarCheque() throws ChequesVazioException { 
		return this.controladorCheque.listar();
	}
	
	public boolean listaVaziaCheque(){
		boolean resposta = this.controladorCheque.listaVazia();
		return resposta;
	}
	
	//Métodos entidade Cliente.
	
	public void cadastrarCliente(Cliente cliente) throws IllegalArgumentException, CPFInvalidoException, ClienteJaCadastradoException, CampoObrigatorioInvalidoException, IdadeInvalidaException { 
		this.controladorCliente.cadastrar(cliente);
	}
	
	public void atualizarCliente(Cliente cliente) throws CPFInvalidoException, CampoObrigatorioInvalidoException, ClienteNaoEncontradoException { 
		this.controladorCliente.atualizar(cliente);
	}
	
	public void removerCliente(String cpf) throws CPFInvalidoException, ClienteNaoEncontradoException { 
		this.controladorCliente.remover(cpf);
	}
	
	public Cliente procurarCliente(String cpf) throws CPFInvalidoException, ClienteNaoEncontradoException { 
		return this.controladorCliente.procurar(cpf);
	}
	
	public ArrayList<Cliente> listarCliente() throws ClientesVazioException { 
		return this.controladorCliente.listar();
	}
	
	public boolean listaVaziaCliente(){
		boolean resposta = this.controladorCliente.listaVazia();
		return resposta;
	}
	//Métodos entidade Funcionário.
	
	public void cadastrarFuncionario(Funcionario funcionario) throws IllegalArgumentException, CPFInvalidoException, FuncionarioJaCadastradoException, CampoObrigatorioInvalidoException { 
		this.controladorFuncionario.cadastrar(funcionario);
	}
	
	public void atualizarFuncionario(Funcionario funcionario) throws CPFInvalidoException, CampoObrigatorioInvalidoException, FuncionarioNaoEncontradoException { 
		this.controladorFuncionario.atualizar(funcionario);
	}

	public void removerFuncionario(String cpf) throws CPFInvalidoException, FuncionarioNaoEncontradoException { 
		this.controladorFuncionario.remover(cpf);
	}
	
	public Funcionario procurarFuncionario(String cpf) throws CPFInvalidoException, FuncionarioNaoEncontradoException { 
		return this.controladorFuncionario.procurar(cpf);
	}

	public ArrayList<Funcionario> listarFuncionario() throws FuncionariosVazioException { 
		return this.controladorFuncionario.listar();
	}
	
	public boolean listaVaziaFuncionario(){
		boolean resposta = this.controladorFuncionario.listaVazia();
		return resposta;
	}
}
