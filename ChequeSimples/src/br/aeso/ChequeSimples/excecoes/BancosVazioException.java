package br.aeso.ChequeSimples.excecoes;

public class BancosVazioException extends Exception {
    public BancosVazioException(){
        super ("A lista de bancos está vazia!");
    }
}
