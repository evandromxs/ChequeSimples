package br.aeso.ChequeSimples.excecoes;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Você precisa ter 18 anos ou mais.");
	}
}
