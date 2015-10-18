package br.aeso.ChequeSimples.excecoes;

public class EnderecosVazioException extends Exception {
    public EnderecosVazioException(){
        super ("A lista de bancos está vazia!");
    }
}
