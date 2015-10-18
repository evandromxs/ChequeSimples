package br.aeso.ChequeSimples.endereco;

import java.util.ArrayList;

import br.aeso.ChequeSimples.excecoes.EnderecoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.EnderecoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.EnderecosVazioException;

public class RepositorioEnderecoBDR implements IRepositorioEndereco {
	private ArrayList<Endereco> enderecos;
	
	public RepositorioEnderecoBDR() {
		enderecos = new ArrayList<Endereco>();
	}
	
	@Override
	public void cadastrar(Endereco endereco) throws EnderecoJaCadastradoException {
	  	// Verifica se o endereco existe no repositório
    	if (existe(endereco.getId())) {
    		throw new EnderecoJaCadastradoException();
    	}else{
		enderecos.add(endereco);
		endereco.setId(enderecos.indexOf(endereco));
    	}
	}

	@Override
	public void atualizar(Endereco endereco) throws EnderecoNaoEncontradoException {
        int id = endereco.getId();
        if (existe(id)){
        	throw new EnderecoNaoEncontradoException();
        }else{
        	enderecos.set(id, endereco);
        }
	}

	@Override
	public void remover(int id) throws EnderecoNaoEncontradoException {
	        if (existe(id)) {
	        	throw new EnderecoNaoEncontradoException();
	        }else{
	        	enderecos.remove(id);
	        }
	}

	@Override
	public Endereco procurar(int id) throws EnderecoNaoEncontradoException {
        if (existe(id)) {
        	throw new EnderecoNaoEncontradoException();
        }else{
        	return enderecos.get(id);
        }
	}

	@Override
	public boolean existe(int id) {
	boolean resposta;
          if (id >= 0) {
        	  resposta = true;
          }else{
        	  resposta = false;
          }
      return resposta;
	}

	@Override
	public ArrayList<Endereco> listar() throws EnderecosVazioException {
		if(listaVazia() == true){
			throw new EnderecosVazioException();
		}else{
			return enderecos;
		}
	}
	
	public boolean listaVazia(){
		if(enderecos.isEmpty() == true){
			return true;
		}else{
			return false;
		}
	}
}
