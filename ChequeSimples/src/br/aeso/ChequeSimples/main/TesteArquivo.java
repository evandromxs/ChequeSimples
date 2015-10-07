package br.aeso.ChequeSimples.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import br.aeso.ChequeSimples.banco.Banco;

public class TesteArquivo {

	private static Scanner teclado;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//endereço do arquivo
		Path arquivoBanco = Paths.get("src/br/aeso/ChequeSimples/main/Banco.chs");
		//ler
		FileInputStream fis = new FileInputStream(arquivoBanco.toFile());
		ObjectInputStream ois = new ObjectInputStream(fis);
		//gravar
		FileOutputStream fos = new FileOutputStream(arquivoBanco.toFile());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ArrayList<Banco> bancos = new ArrayList();
		
		String nome, numero;
		teclado = new Scanner(System.in);
		
		System.out.println("inserir banco?");
		String inserir = teclado.next();
		
		while(inserir.equals("sim")){
			System.out.println("Digite o nome do banco:");
			nome = teclado.next();
			System.out.println("Digite o numero do banco:");
			numero = teclado.next();
			Banco banco = new Banco(nome, numero);
			bancos.add(banco);
			
			System.out.println("Inserir novo banco?");
			inserir = teclado.next();
		}
		
		oos.writeObject(bancos);
		oos.close();
		
		bancos = (ArrayList<Banco>) ois.readObject();
		ois.close();
		System.out.println(bancos);
		
	}
}