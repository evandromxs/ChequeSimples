package br.aeso.ChequeSimples.funcionario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario {
	private Integer id;
    private String nome;
    private String cpf;
    private String cargo;
    private String data_cadastro = getDataHoje();

    public Funcionario(String nome, String cpf, String cargo) {
    	this.setNome(nome);
    	this.setCpf(cpf);
        this.setCargo(cargo);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getCpfFormatado() {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
    
    private void setCpf(String cpf) {
    	this.cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
    }
    
    public String getCargo(){
    	return cargo;
    }
    
    public void setCargo(String cargo){
    	this.cargo = cargo;
    }

	@Override
	public String toString() {
		return "Funcionário [id=" + id + ", nome=" + nome + ", cpf=" + cpf +", cargo=" + cargo +"]";
	}
	
	public String getDataHoje() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		return formato.format(data);
	}
}
