package br.aeso.ChequeSimples.excecoes;

public class FuncionarioJaCadastradoException extends Exception {
    public FuncionarioJaCadastradoException(){
        super ("Funcion�rio j� cadastrado!");
    }
}
