package br.aeso.ChequeSimples.excecoes;

public class ChequeNaoEncontradoException extends Exception {
    public ChequeNaoEncontradoException(){
        super ("Cheque não encontrado!");
    }
}
