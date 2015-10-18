package br.aeso.ChequeSimples.funcionario;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.FuncionarioJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.FuncionariosVazioException;

public class RepositorioFuncionarioBDR implements IRepositorioFuncionario {
	private ArrayList<Funcionario> funcionarios;
	
	public RepositorioFuncionarioBDR() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	@Override
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException {
	  	// Verifica se o funcionario existe no repositório
    	if (this.existe(funcionario.getCpf())) {
    		throw new FuncionarioJaCadastradoException();
    	}else{
		funcionarios.add(funcionario);
		funcionario.setId(funcionarios.indexOf(funcionario));
    	}
	}

	@Override
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
        int i = getIndice(funcionario.getCpf());
        if (i == -1){
        	throw new FuncionarioNaoEncontradoException();
        }else{
        	funcionarios.set(i, funcionario);
        }
	}

	@Override
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		 int i = getIndice(cpf);
	        if (i == -1) {
	        	throw new FuncionarioNaoEncontradoException();
	        }else{
	        	funcionarios.remove(i);
	        }
	}

	@Override
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
        int i = getIndice(cpf);
        if (i == -1) {
        	throw new FuncionarioNaoEncontradoException();
        }else{
        	return funcionarios.get(i);
        }
	}

	@Override
	public boolean existe(String cpf) {
	boolean resposta;
          if (getIndice(cpf) >= 0) {
        	  resposta = true;
          }else{
        	  resposta = false;
          }
      return resposta;
	}

	@Override
	public ArrayList<Funcionario> listar() throws FuncionariosVazioException {
		if(listaVazia() == true){
			throw new FuncionariosVazioException();
		}else{
			return funcionarios;
		}
	}

	private int getIndice(String cpf) {
	        int resposta = -1;
	        for(Funcionario f : funcionarios){
	            if (f.getCpf().equals(cpf)) {
	                resposta = f.getId();
	            }
	        }
	        return resposta;
	    }
	
	public boolean listaVazia(){
		if(funcionarios.isEmpty() == true){
			return true;
		}else{
			return false;
		}
	}
}
