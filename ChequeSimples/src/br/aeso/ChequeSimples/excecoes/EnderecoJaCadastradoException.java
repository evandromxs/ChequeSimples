package br.aeso.ChequeSimples.excecoes;

public class EnderecoJaCadastradoException extends Exception {
    public EnderecoJaCadastradoException(){
        super ("Banco já cadastrado!");
    }
}
