package br.aeso.ChequeSimples.excecoes;

public class ChequeJaCadastradoException extends Exception {
    public ChequeJaCadastradoException(){
        super ("Cheque já cadastrado!");
    }
}
