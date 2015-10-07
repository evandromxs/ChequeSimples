package br.aeso.ChequeSimples.cheque;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.aeso.ChequeSimples.banco.Banco;
import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.funcionario.Funcionario;
import br.aeso.ChequeSimples.util.PegarDataHoje;

public class Cheque {
	private int id;
	private Cliente titular;
	private Banco banco;
	private Funcionario funcionario;
	private String numero;
	private float valor;
	private String data_desconto;
	private String situacao;
	private String observacao;
	private String data_cadastro = getDataHoje();
	
	public Cheque(Cliente titular, Banco banco, Funcionario funcionario, String numero, float valor, String data_desconto, String observacao) {
		this.titular = titular;
		this.banco = banco;
		this.funcionario = funcionario;
		this.numero = numero;
		this.valor = valor;
		this.data_desconto = data_desconto;
		this.observacao = observacao;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getData_desconto() {
		return data_desconto;
	}

	public void setData_desconto(String data_desconto) {
		this.data_desconto = data_desconto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Cheque [id=" + id + ", titular=" + titular + ", banco=" + banco + ", numero=" + numero + ", valor=" + valor + ", data_desconto=" + data_desconto + ", situacao=" + situacao + ", observacao=" + observacao + "]";
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
