package br.aeso.ChequeSimples.excecoes;

public class RelatoriosVazioException extends Exception {
    public RelatoriosVazioException(){
        super ("A lista de cheques est� vazia, ent�o n�o existem relat�rios.");
    }
}
