package br.aeso.ChequeSimples.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.aeso.ChequeSimples.funcionario.Funcionario;
import br.aeso.ChequeSimples.funcionario.Funcionario;
import br.aeso.ChequeSimples.excecoes.FuncionarioJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.FuncionarioNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.fachada.Fachada;

public class TelaFuncionario {

	public static void main(String[] args) throws IOException {
		Fachada fachada = Fachada.getInstance();
		Scanner teclado = new Scanner(System.in);
		int escolha = 0;
		String certeza, nome, cpf, cargo;
		Funcionario funcionario;
		ArrayList<Funcionario> listaFuncionarios;
		while(true) {
			try {
				System.out.println("Escolha a op��o: ");
				System.out.println("1 - Cadastar Funcion�rio");
				System.out.println("2 - Procurar Funcion�rio");
				System.out.println("3 - Remover Funcion�rio");
				System.out.println("4 - Atualizar Funcion�rio");
				System.out.println("5 - Listar Funcion�rios");
				System.out.println("0 - Sair");
				
				escolha = teclado.nextInt();
				// Cadastrar Funcionario
				if (escolha == 1) {
					System.out.print("Entre com o Nome: ");
					nome = teclado.next();
					//teclado.next();
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					System.out.print("Entre com o Cargo: ");
					cargo = teclado.next();
					//System.out.println(nome);
					
					funcionario = new Funcionario(nome, cpf, cargo);
					fachada.cadastrarFuncionario(funcionario);
					System.out.println("Funcion�rio cadastrado com sucesso!");
				}
				// Procurar Funcionario
				else if (escolha == 2) {
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					funcionario = fachada.procurarFuncionario(cpf);
					System.out.println(funcionario);
				}
				// Remover funcionario
				else if (escolha == 3) {
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					System.out.println("Tem certeza que deseja remover o funcion�rio "+fachada.procurarFuncionario(cpf).getNome()+"? (S ou N)");
					certeza = teclado.next().toLowerCase();
					if(certeza.equals("s")){
					fachada.removerFuncionario(cpf);
					System.out.println("Funcion�rio removido com sucesso!");
					}else{
						System.out.println("O funcion�rio "+fachada.procurarFuncionario(cpf).getNome()+" n�o foi removido.");
						TelaFuncionario.main(null);
					}
				}
				// Atualizar Funcionario
				else if (escolha == 4) {
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					funcionario = fachada.procurarFuncionario(cpf);
					System.out.print("Entre com o novo Nome: ");
					nome = teclado.next();
					System.out.print("Entre com o novo Cargo: ");
					cargo = teclado.next();
					funcionario.setNome(nome);
					funcionario.setCargo(cargo);
					fachada.atualizarFuncionario(funcionario);
					System.out.println("Funcion�rio atualizado com sucesso!");
				}
				else if (escolha == 5) {
					listaFuncionarios = fachada.listarFuncionario();
					System.out.println(listaFuncionarios);
				}

				if (escolha == 0) break;
			} catch (FuncionarioJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (CampoObrigatorioInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (FuncionarioNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Par�metro de sele��o � nulo ou inv�lido.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Saiu dos funcion�rios");
	}

	}
