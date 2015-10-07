package br.aeso.ChequeSimples.banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.excecoes.BancoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.BancoNaoEncontradoException;

public class RepositorioBancoArquivo implements IRepositorioBanco {
	// private ArrayList<Banco> bancos;
	private Path arquivoBanco;
	//ler
	private FileInputStream fis;
	private ObjectInputStream ois;
	//gravar
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	ArrayList<Banco> bancos;

	public RepositorioBancoArquivo() {
		bancos = new ArrayList<Banco>();
		arquivoBanco = Paths.get("src/br/aeso/ChequeSimples/banco/Banco.chs");
		//ler
		try {
			fis = new FileInputStream(arquivoBanco.toFile());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			bancos = (ArrayList<Banco>) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvar() {
		try{
		fos = new FileOutputStream(arquivoBanco.toFile());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(bancos); 
		oos.close();
		}catch(IOException e){
			e.getMessage();
		}
	}
	
	@Override
	public void cadastrar(Banco banco) throws BancoJaCadastradoException {
		// Verifica se o banco existe no repositório.
		if (this.existe(banco.getCodigo()))	{
			throw new BancoJaCadastradoException();
		}else{
			bancos.add(banco);
			salvar();
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws BancoNaoEncontradoException {
		int i = getIndice(cliente.getCpf());
		if (i == -1)
			throw new BancoNaoEncontradoException();
		banco.set(i, cliente);
	}

	@Override
	public void remover(String codigo) throws BancoNaoEncontradoException {
		int i = getIndice(codigo);
		if (i == -1)
			throw new BancoNaoEncontradoException();
		bancos.remove(i);
		
		salvar();
	}

	@Override
	public Banco procurar(String codigo) throws BancoNaoEncontradoException {
		int i = getIndice(codigo);
		if (i == -1)
			throw new BancoNaoEncontradoException();

		return bancos.get(i);
	}

	// parei aqui me perguntando como faria para entidade banco
	@Override
	public boolean existe(String codigo) {
		boolean resposta;
		if (getIndice(codigo) >= 0)
			resposta = true;
		else
			resposta = false;
		return resposta;
	}

	@Override
	public ArrayList<Banco> listar() {
		return bancos;
	}	
		
	private int getIndice(String codigo) {
		int resposta = -1;
		for (Banco b : bancos) {
			if (b.getCodigo().equals(codigo)) {
				resposta = b.getId();
			}
		}
		return resposta;
	}
}
