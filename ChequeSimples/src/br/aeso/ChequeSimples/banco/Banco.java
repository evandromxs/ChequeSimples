package br.aeso.ChequeSimples.banco;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * 001 - Banco do Brasil S.A.
 * 341 - Itaú Unibanco S.A.
 * 237 - Banco Bradesco S.A.
 * 104 - Caixa Econômica Federal
 * 033 - Banco Santander S.A.
*/

public class Banco implements java.io.Serializable{
	private int id;
	private String codigo;
	private String nome;
	private String data_cadastro = getDataHoje();
	
	public Banco(String codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Banco [id=" + id + ", codigo=" + codigo + ", nome=" + nome + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDataHoje() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		return formato.format(data);
	}
}
