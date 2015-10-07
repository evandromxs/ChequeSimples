package br.aeso.ChequeSimples.excecoes;

public class FuncionariosVazioException extends Exception {
    public FuncionariosVazioException(){
        super ("A lista de funcionários está vazia!");
    }
}
