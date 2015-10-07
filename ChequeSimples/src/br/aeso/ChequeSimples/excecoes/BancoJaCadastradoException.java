package br.aeso.ChequeSimples.excecoes;

public class BancoJaCadastradoException extends Exception {
    public BancoJaCadastradoException(){
        super ("Banco já cadastrado!");
    }
}
