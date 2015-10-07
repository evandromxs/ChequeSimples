package br.aeso.ChequeSimples.excecoes;

public class ChequesVazioException extends Exception {
    public ChequesVazioException(){
        super ("A lista de cheques está vazia!");
    }
}
