package br.aeso.ChequeSimples.excecoes;

public class FuncionariosVazioException extends Exception {
    public FuncionariosVazioException(){
        super ("A lista de funcion�rios est� vazia!");
    }
}
