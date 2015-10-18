package br.aeso.ChequeSimples.excecoes;

public class TelefoneNaoEncontradoException extends Exception {
    public TelefoneNaoEncontradoException(){
        super ("Banco não encontrado!");
    }
}
