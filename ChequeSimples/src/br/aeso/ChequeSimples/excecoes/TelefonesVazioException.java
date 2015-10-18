package br.aeso.ChequeSimples.excecoes;

public class TelefonesVazioException extends Exception {
    public TelefonesVazioException(){
        super ("A lista de bancos está vazia!");
    }
}
