package br.aeso.ChequeSimples.excecoes;

public class BancoNaoEncontradoException extends Exception {
    public BancoNaoEncontradoException(){
        super ("Banco não encontrado!");
    }
}
