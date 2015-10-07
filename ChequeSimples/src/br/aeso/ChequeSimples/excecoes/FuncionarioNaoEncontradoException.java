package br.aeso.ChequeSimples.excecoes;

public class FuncionarioNaoEncontradoException extends Exception {
    public FuncionarioNaoEncontradoException(){
        super ("Funcionario não encontrado!");
    }
}
