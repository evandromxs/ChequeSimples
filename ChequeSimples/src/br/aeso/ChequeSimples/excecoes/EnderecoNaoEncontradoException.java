package br.aeso.ChequeSimples.excecoes;

public class EnderecoNaoEncontradoException extends Exception {
    public EnderecoNaoEncontradoException(){
        super ("Banco n�o encontrado!");
    }
}
