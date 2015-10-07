package br.aeso.ChequeSimples.excecoes;

public class ClienteJaCadastradoException extends Exception {
    public ClienteJaCadastradoException(){
        super ("Cliente já cadastrado!");
    }
} 