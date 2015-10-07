package br.aeso.ChequeSimples.main;

import java.io.IOException;
import java.util.Scanner;

import br.aeso.ChequeSimples.excecoes.BancosVazioException;
import br.aeso.ChequeSimples.excecoes.ChequesVazioException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;
import br.aeso.ChequeSimples.excecoes.FuncionariosVazioException;
import br.aeso.ChequeSimples.excecoes.RelatoriosVazioException;
import br.aeso.ChequeSimples.fachada.Fachada;

public class TelaGeral {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		int escolha = 0;
		
		while(true) {
			System.out.println("Escolha a opção: ");
			System.out.println("1 - Funcionarios");
			System.out.println("2 - Clientes");
			System.out.println("3 - Bancos");
			System.out.println("4 - Cheques");
			System.out.println("5 - Relatórios");
			System.out.println("0 - Sair");
			escolha = teclado.nextInt();

			if (escolha == 1) {
				TelaFuncionario.main(null);
			}else if (escolha == 2){
				if(Fachada.getInstance().listaVaziaFuncionario() == true){
					System.out.println("Cadastre um Funcionário."); TelaFuncionario.main(null);
				}else{
				TelaCliente.main(null);
				}
			}else if (escolha == 3){
				if(Fachada.getInstance().listaVaziaCliente() == true){
					System.out.println("Cadastre um Cliente."); TelaCliente.main(null);
				}else{
				TelaBanco.main(null);
				}
			}else if (escolha == 4){
				if(Fachada.getInstance().listaVaziaBanco() == true){
					System.out.println("Cadastre um Banco."); TelaBanco.main(null);
				}else{
				TelaCheque.main(null);
				}
			}else if (escolha == 5){
				if(Fachada.getInstance().listaVaziaCheque() == true){
					System.out.println("Cadastre um Cheque."); TelaCheque.main(null);
				}else{
				TelaRelatorios.main(null);
				}
			}else if (escolha == 0) break;

		}
	
		System.out.println("Programa fechou!");




}
}
