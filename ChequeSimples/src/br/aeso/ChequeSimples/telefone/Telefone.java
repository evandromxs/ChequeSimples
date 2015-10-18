package br.aeso.ChequeSimples.telefone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Telefone{
	private int id;
	private int idCliente;
	private String ddd;
	private String telefone;
	private String data_cadastro = getDataHoje();
	
	public Telefone(String ddd, String telefone){
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getDdd() {
		return ddd;
	}


	public void setDdd(String ddd) {
		this.ddd = ddd;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getDataHoje() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		return formato.format(data);
	}
}
