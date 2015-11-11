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
    private String dataCadastro = getDataHoje();
    
    public Cliente(String nomeRazaoSocial, String cpf_cnpj) {
        this.setNome_razaoSocial(nomeRazaoSocial);
        this.setCpf_cnpj(cpf_cnpj);
    }
    
    public Cliente(){}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getDataCadastro() {
		return dataCadastro = getDataHoje();
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
//	public Endereco getEndereco() {
//		if(endereco == null){
//			this.endereco = new Endereco();
//		}	
//		return endereco;
//	}

//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}

//	public String getCpfFormatado() {
//        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
//    }
//    
//    public void setCpf(String cpf) {
//    	this.cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
//    }

//	@Override
//	public String toString() {
//		return "Cliente [id=" + id + ", nome=" + nome +", cpf=" + cpf +"]";
//	}
//	
	public String getDataHoje() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		return formato.format(data);
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNome_razaoSocial() {
		return nome_razaoSocial;
	}

	public void setNome_razaoSocial(String nome_razaoSocial) {
		this.nome_razaoSocial = nome_razaoSocial;
	}

	public byte getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(byte bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
}
