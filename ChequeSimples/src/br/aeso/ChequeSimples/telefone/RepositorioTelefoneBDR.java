package br.aeso.ChequeSimples.telefone;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.TelefoneJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.TelefoneNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.TelefonesVazioException;

public class RepositorioTelefoneBDR implements IRepositorioTelefone {
	private ArrayList<Telefone> telefones;
	
	public RepositorioTelefoneBDR() {
		telefones = new ArrayList<Telefone>();
	}
	
	@Override
	public void cadastrar(Telefone telefone) throws TelefoneJaCadastradoException {
	  	// Verifica se o telefone existe no repositório
    	if (this.existe(telefone.getDdd(), telefone.getTelefone())) {
    		throw new TelefoneJaCadastradoException();
    	}else{
		telefones.add(telefone);
		telefone.setId(telefones.indexOf(telefone));
    	}
	}

	@Override
	public void atualizar(Telefone telefone) throws TelefoneNaoEncontradoException {
        int i = getIndice(telefone.getDdd(), telefone.getTelefone());
        if (i == -1){
        	throw new TelefoneNaoEncontradoException();
        }else{
        	telefones.set(i, telefone);
        }
	}

	@Override
	public void remover(String ddd, String telefone) throws TelefoneNaoEncontradoException {
		 int i = getIndice(ddd, telefone);
	        if (i == -1) {
	        	throw new TelefoneNaoEncontradoException();
	        }else{
	        	telefones.remove(i);
	        }
	}

	@Override
	public Telefone procurar(String ddd, String telefone) throws TelefoneNaoEncontradoException {
        int i = getIndice(ddd, telefone);
        if (i == -1) {
        	throw new TelefoneNaoEncontradoException();
        }else{
        	return telefones.get(i);
        }
	}

	@Override
	public boolean existe(String ddd, String telefone) {
	boolean resposta;
          if (getIndice(ddd, telefone) >= 0) {
        	  resposta = true;
          }else{
        	  resposta = false;
          }
      return resposta;
	}

	@Override
	public ArrayList<Telefone> listar() throws TelefonesVazioException {
		if(listaVazia() == true){
			throw new TelefonesVazioException();
		}else{
			return telefones;
		}
	}

	//DEPOIS VERIFICAR O CÓDIGO ABAIXO POIS TEM QUE LEVAR EM CONTA O DDD.
	private int getIndice(String ddd, String telefone) {
	      	int resposta = -1;
	        for(Telefone t : telefones){
	            if ((t.getDdd().equals(ddd)) && (t.getTelefone().equals(telefone))) {
	                resposta = t.getId();
	            }
	        }
	        return resposta;
	    }
	
	public boolean listaVazia(){
		if(telefones.isEmpty() == true){
			return true;
		}else{
			return false;
		}
	}
}
