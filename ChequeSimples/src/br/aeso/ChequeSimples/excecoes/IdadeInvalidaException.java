package br.aeso.ChequeSimples.excecoes;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Voc� precisa ter 18 anos ou mais.");
	}
}
