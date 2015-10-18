package br.aeso.ChequeSimples.banco;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.BancoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.BancosVazioException;

public class RepositorioBancoBDR implements IRepositorioBanco {
	private ArrayList<Banco> bancos;
	
	public RepositorioBancoBDR() {
		bancos = new ArrayList<Banco>();
	}
	
	@Override
	public void cadastrar(Banco banco) throws BancoJaCadastradoException {
	  	// Verifica se o banco existe no repositório
    	if (this.existe(banco.getCodigo())) {
    		throw new BancoJaCadastradoException();
    	}else{
		bancos.add(banco);
		banco.setId(bancos.indexOf(banco));
    	}
	}

	@Override
	public void atualizar(Banco banco) throws BancoNaoEncontradoException {
        int i = getIndice(banco.getCodigo());
        if (i == -1){
        	throw new BancoNaoEncontradoException();
        }else{
        	bancos.set(i, banco);
        }
	}

	@Override
	public void remover(String codigo) throws BancoNaoEncontradoException {
		 int i = getIndice(codigo);
	        if (i == -1) {
	        	throw new BancoNaoEncontradoException();
	        }else{
	        	bancos.remove(i);
	        }
	}

	@Override
	public Banco procurar(String codigo) throws BancoNaoEncontradoException {
        int i = getIndice(codigo);
        if (i == -1) {
        	throw new BancoNaoEncontradoException();
        }else{
        	return bancos.get(i);
        }
	}

	@Override
	public boolean existe(String codigo) {
	boolean resposta;
          if (getIndice(codigo) >= 0) {
        	  resposta = true;
          }else{
        	  resposta = false;
          }
      return resposta;
	}

	@Override
	public ArrayList<Banco> listar() throws BancosVazioException {
		if(listaVazia() == true){
			throw new BancosVazioException();
		}else{
			return bancos;
		}
	}

	private int getIndice(String codigo) {
	        int resposta = -1;
	        for(Banco b : bancos){
	            if (b.getCodigo().equals(codigo)) {
	                resposta = b.getId();
	            }
	        }
	        return resposta;
	    }
	
	public boolean listaVazia(){
		if(bancos.isEmpty() == true){
			return true;
		}else{
			return false;
		}
	}
}
