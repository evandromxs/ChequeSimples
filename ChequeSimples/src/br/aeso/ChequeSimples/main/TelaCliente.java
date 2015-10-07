package br.aeso.ChequeSimples.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.fachada.Fachada;

public class TelaCliente {

	public static void main(String[] args) throws IOException {
		Fachada fachada = Fachada.getInstance();
		Scanner teclado = new Scanner(System.in);
		int escolha = 0;
		String certeza, nome, cpf;
		Cliente cliente;
		ArrayList<Cliente> listaClientes;
		while(true) {
			try {
				System.out.println("Escolha a opção: ");
				System.out.println("1 - Cadastar Cliente");
				System.out.println("2 - Procurar Cliente");
				System.out.println("3 - Remover Cliente");
				System.out.println("4 - Atualizar Cliente");
				System.out.println("5 - Listar Clientes");
				System.out.println("0 - Sair");
				
				escolha = teclado.nextInt();
				// Cadastrar Cliente
				if (escolha == 1) {
					System.out.print("Entre com o Nome: ");
					nome = teclado.next();
					//teclado.next();
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					//System.out.println(nome);
					
					cliente = new Cliente(nome, cpf);
					fachada.cadastrarCliente(cliente);
					System.out.println("Cliente cadastrado com sucesso!");
				}
				// Procurar Cliente
				else if (escolha == 2) {
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					cliente = fachada.procurarCliente(cpf);
					System.out.println(cliente);
				}
				// Remover cliente
				else if (escolha == 3) {
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					System.out.println("Tem certeza que deseja remover o cliente "+fachada.procurarCliente(cpf).getNome()+"? (S ou N)");
					certeza = teclado.next().toLowerCase();
					if(certeza.equals("s")){
					fachada.removerCliente(cpf);
					System.out.println("Cliente removido com sucesso!");
					}else{
						System.out.println("O cliente "+fachada.procurarCliente(cpf).getNome()+" não foi removido.");
						TelaCliente.main(null);
					}
				}
				// Atualizar Cliente
				else if (escolha == 4) {
					System.out.print("Entre com o CPF: ");
					cpf = teclado.next();
					cliente = fachada.procurarCliente(cpf);
					System.out.print("Entre com o novo Nome: ");
					nome = teclado.next();
					cliente.setNome(nome);
					fachada.atualizarCliente(cliente);
					System.out.println("Cliente atualizado com sucesso!");
				}
				else if (escolha == 5) {
					listaClientes = fachada.listarCliente();
					System.out.println(listaClientes);
				}

				if (escolha == 0) break;
			} catch (ClienteJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (CampoObrigatorioInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Parâmetro de seleção é nulo ou inválido.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Saiu dos clientes");
	}

	}
