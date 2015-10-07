package br.aeso.ChequeSimples.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.aeso.ChequeSimples.banco.Banco;
import br.aeso.ChequeSimples.cheque.Cheque;
import br.aeso.ChequeSimples.cheque.Cheque;
import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.excecoes.ChequeJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequeNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.ChequeJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ChequeNaoEncontradoException;
import br.aeso.ChequeSimples.fachada.Fachada;
import br.aeso.ChequeSimples.funcionario.Funcionario;

public class TelaCheque {

	public static void main(String[] args) throws IOException {
		Fachada fachada = Fachada.getInstance();
		Scanner teclado = new Scanner(System.in);
		int escolha = 0;
		String certeza;
		
		Funcionario funcionario;
		Cliente titular;
		Banco banco;
		String cpf_funcionario;
		String cpf_cliente;
		String codigo_banco;
		
		String numero;
		float valor;
		String data_desconto;
		String situacao;
		String observacao;
		
		Cheque cheque;
		ArrayList<Cheque> listaCheques;
		while(true) {
			try {
				System.out.println("Escolha a opção: ");
				System.out.println("1 - Cadastar Cheque");
				System.out.println("2 - Procurar Cheque");
				System.out.println("3 - Remover Cheque");
				System.out.println("4 - Atualizar Cheque");
				System.out.println("5 - Listar Cheques");
				System.out.println("0 - Sair");
				
				escolha = teclado.nextInt();
				// Cadastrar Cheque
				if (escolha == 1) {
					System.out.print("Entre com o CPF de funcionário: ");
					cpf_funcionario = teclado.next();
					funcionario = fachada.procurarFuncionario(cpf_funcionario);
					//teclado.next();
					System.out.print("Entre com o CPF do Titular (cliente ao qual o cheque pertence): ");
					cpf_cliente = teclado.next();
					titular = fachada.procurarCliente(cpf_cliente);
					//System.out.println(nome);
					System.out.print("Entre com o Código do banco: ");
					codigo_banco = teclado.next();
					banco = fachada.procurarBanco(codigo_banco);
					
					System.out.print("Entre com o Número do cheque: ");
					numero = teclado.next();
					System.out.print("Entre com o Valor do cheque: R$");
					String valor_string = teclado.next();
					valor = Float.parseFloat(valor_string);
					System.out.print("Entre com a data de desconto do cheque: ");
					data_desconto = teclado.next();
					System.out.print("Entre com as observações sobre o cheque: ");
					observacao = teclado.next();

					
					cheque = new Cheque(titular, banco, funcionario, numero, valor, data_desconto, observacao);
					fachada.cadastrarCheque(cheque);
					System.out.println("Cheque cadastrado com sucesso!");
				}
				// Procurar Cheque
				else if (escolha == 2) {
					System.out.print("Entre com o Número: ");
					numero = teclado.next();
					cheque = fachada.procurarCheque(numero);
					System.out.println(cheque);
				}
				// Remover cheque
				else if (escolha == 3) {
					System.out.print("Entre com o Número: ");
					numero = teclado.next();
					System.out.println("Tem certeza que deseja remover o cheque "+numero+" do cliente "+fachada.procurarCheque(numero).getTitular().getNome()+"? (S ou N)");
					certeza = teclado.next().toLowerCase();
					if(certeza.equals("s")){
					fachada.removerCheque(numero);
					System.out.println("Cheque removido com sucesso!");
					}else{
						System.out.println("O cheque do Cliente "+fachada.procurarCheque(numero).getTitular().getNome()+" não foi removido.");
						TelaCheque.main(null);
					}
				}
				// Atualizar Cheque
				else if (escolha == 4) {
					System.out.print("Entre com o Número do cheque: ");
					numero = teclado.next();
					System.out.print("Entre com o novo Valor do cheque: R$");
					String valor_string = teclado.next();
					valor = Float.parseFloat(valor_string);
					System.out.print("Entre com a nova data de desconto do cheque: ");
					data_desconto = teclado.next();
					System.out.print("Entre com as novas observações sobre o cheque: ");
					observacao = teclado.next();
					cheque = fachada.procurarCheque(numero);
					cheque.setValor(valor);					
					cheque.setData_desconto(data_desconto);
					cheque.setObservacao(observacao);
					fachada.atualizarCheque(cheque);
					System.out.println("Cheque atualizado com sucesso!");
				}
				else if (escolha == 5) {
					System.out.print("Entre com o Número do cheque: ");
					numero = teclado.next();
					cheque = fachada.procurarCheque(numero);
					cheque.setSituacao("Depositado");
					System.out.println("Situação atualizada com sucesso!");
				}
				else if (escolha == 6) {
					listaCheques = fachada.listarCheque();
					System.out.println(listaCheques);
				}

				if (escolha == 0) break;
			} catch (ChequeJaCadastradoException e) {
				System.out.println(e.getMessage());
			} catch (CampoObrigatorioInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (ChequeNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Parâmetro de seleção é nulo ou inválido.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Saiu dos cheques");
	}

	}
