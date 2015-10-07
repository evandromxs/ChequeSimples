package br.aeso.ChequeSimples.excecoes;

public class CPFInvalidoException extends Exception {
	private String cpf;
	
	public CPFInvalidoException(String cpf) {
		super("CPF " + cpf + " Nulo ou Inválido");
		this.cpf = cpf;
	}
}
