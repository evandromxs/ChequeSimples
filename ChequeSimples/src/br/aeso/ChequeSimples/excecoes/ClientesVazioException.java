package br.aeso.ChequeSimples.excecoes;

public class ClientesVazioException extends Exception {
    public ClientesVazioException(){
        super ("A lista de clientes está vazia!");
    }
}
