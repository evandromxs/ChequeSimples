package br.aeso.ChequeSimples.excecoes;

public class TelefoneJaCadastradoException extends Exception {
    public TelefoneJaCadastradoException(){
        super ("Banco já cadastrado!");
    }
}
