package br.aeso.ChequeSimples.cliente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.aeso.ChequeSimples.endereco.Endereco;

public class Cliente {
	private Integer id;
    private String pessoa;
    private String cpf_cnpj;
    private String nome_razaoSocial;
    private byte bloqueado;
    private int id_endereco;
    private String data_cadastro = getDataHoje();
    
    public Cliente(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
    }
    
    public Cliente(){}
    
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
        
    public String getDataCadastro() {
		return dataCadastro = getDataHoje();
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Endereco getEndereco() {
		if(endereco == null){
			this.endereco = new Endereco();
		}	
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpfFormatado() {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
    
    public void setCpf(String cpf) {
    	this.cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
    }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome +", cpf=" + cpf +"]";
	}
	
	public String getDataHoje() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		return formato.format(data);
	}
}
