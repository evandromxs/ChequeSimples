package br.aeso.ChequeSimples.excecoes;

public class RelatoriosVazioException extends Exception {
    public RelatoriosVazioException(){
        super ("A lista de cheques está vazia, então não existem relatórios.");
    }
}
