package br.aeso.ChequeSimples.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.aeso.ChequeSimples.banco.Banco;
import br.aeso.ChequeSimples.excecoes.BancoJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.BancoNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.fachada.Fachada;

public class TelaBanco {

	public static void main(String[] args) throws IOException {
		Fachada fachada = Fachada.getInstance();
		Scanner teclado = new Scanner(System.in);
		int escolha = 0;
		String certeza, codigo, nome;
		Banco banco;
		ArrayList<Banco> listaBancos;
		while(true) {
			try {
				System.out.println("Escolha a opção: ");
				System.out.println("1 - Cadastar Banco");
				System.out.println("2 - Procurar Banco");
				System.out.println("3 - Remover Banco");
				System.out.println("4 - Atualizar Banco");
				System.out.println("5 - Listar Bancos");
				System.out.println("0 - Sair");
				
				escolha = teclado.nextInt();
				// Cadastrar Banco
				if (escolha == 1) {
					System.out.print("Entre com o Nome: ");
					nome = teclado.next();
					//teclado.next();
					System.out.print("Entre com o Código: ");
					codigo = teclado.next();
					//System.out.println(nome);
					
					banco = new Banco(codigo, nome);
					fachada.cadastrarBanco(banco);
					System.out.println("Banco cadastrado com sucesso!");
				}
				// Procurar Banco
				else if (escolha == 2) {
					System.out.print("Entre com o Código: ");
					codigo = teclado.next();
					banco = fachada.procurarBanco(codigo);
					System.out.println(banco);
				}
				// Remover banco
				else if (escolha == 3) {
					System.out.print("Entre com o Código: ");
					codigo = teclado.next();
					System.out.println("Tem certeza que deseja remover o banco "+fachada.procurarBanco(codigo).getNome()+"? (S ou N)");
					certeza = teclado.next().toLowerCase();
					if(certeza.equals("s")){
					fachada.removerBanco(codigo);
					System.out.println("Banco removido com sucesso!");
					}else{
						System.out.println("O banco "+fachada.procurarBanco(codigo).getNome()+" não foi removido.");
						TelaBanco.main(null);
					}
				}
				// Atualizar Banco
				else if (escolha == 4) {
					System.out.print("Entre com o Código: ");
					codigo = teclado.next();
					banco = fachada.procurarBanco(codigo);
					System.out.print("Entre com o novo Código: ");
					codigo = teclado.next();
					banco.setCodigo(codigo);
					System.out.print("Entre com o novo Nome: ");
					nome = teclado.next();
					banco.setNome(nome);
					fachada.atualizarBanco(banco);
					System.out.println("Banco atualizado com sucesso!");
				}
				else if (escolha == 5) {
					listaBancos = fachada.listarBanco();
					if (listaBancos.isEmpty()) System.out.println("Lista está vazia.");
					System.out.println(listaBancos);
				}

				if (escolha == 0) break;
			} catch (BancoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (CampoObrigatorioInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (BancoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Parâmetro de seleção é nulo ou inválido.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Saiu dos bancos");
	}

	}
