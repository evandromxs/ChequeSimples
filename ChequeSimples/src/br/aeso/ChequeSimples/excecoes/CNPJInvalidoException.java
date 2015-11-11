package br.aeso.ChequeSimples.excecoes;

public class CNPJInvalidoException extends Exception {
	private String cnpj;
	
	public CNPJInvalidoException(String cnpj) {
		super("CNPJ " + cnpj + " Nulo ou Inválido");
		this.cnpj = cnpj;
	}
}
