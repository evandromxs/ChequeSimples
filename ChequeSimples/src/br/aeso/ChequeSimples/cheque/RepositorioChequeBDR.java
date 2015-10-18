package br.aeso.ChequeSimples.cheque;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.ChequeJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequeNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ChequesVazioException;

public class RepositorioChequeBDR implements IRepositorioCheque {
	private ArrayList<Cheque> cheques;
	
	public RepositorioChequeBDR() {
		cheques = new ArrayList<Cheque>();
	}
	
	@Override
	public void cadastrar(Cheque cheque) throws ChequeJaCadastradoException {
	  	// Verifica se o cheque existe no repositório
    	if (this.existe(cheque.getNumero())) {
    		throw new ChequeJaCadastradoException();
    	}else{
		cheques.add(cheque);
		cheque.setId(cheques.indexOf(cheque));
    	}
	}

	@Override
	public void atualizar(Cheque cheque) throws ChequeNaoEncontradoException {
        int i = getIndice(cheque.getNumero());
        if (i == -1){
        	throw new ChequeNaoEncontradoException();
        }else{
        	cheques.set(i, cheque);
        }
	}

	@Override
	public void remover(String numero) throws ChequeNaoEncontradoException {
		 int i = getIndice(numero);
	        if (i == -1) {
	        	throw new ChequeNaoEncontradoException();
	        }else{
	        	cheques.remove(i);
	        }
	}

	@Override
	public Cheque procurar(String numero) throws ChequeNaoEncontradoException {
        int i = getIndice(numero);
        if (i == -1) {
        	throw new ChequeNaoEncontradoException();
        }else{
        	return cheques.get(i);
        }
	}

	@Override
	public boolean existe(String numero) {
	boolean resposta;
          if (getIndice(numero) >= 0) {
        	  resposta = true;
          }else{
        	  resposta = false;
          }
      return resposta;
	}

	@Override
	public ArrayList<Cheque> listar() throws ChequesVazioException {
		if(listaVazia() == true){
			throw new ChequesVazioException();
		}else{
			return cheques;
		}
	}

	private int getIndice(String numero) {
	        int resposta = -1;
	        for(Cheque c : cheques){
	            if (c.getNumero().equals(numero)) {
	                resposta = c.getId();
	            }
	        }
	        return resposta;
	    }
	
	public boolean listaVazia(){
		if(cheques.isEmpty() == true){
			return true;
		}else{
			return false;
		}
	}
}
