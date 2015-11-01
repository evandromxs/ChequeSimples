package br.aeso.ChequeSimples.enums;

import java.util.ArrayList;
import java.util.Collection;

public enum StatusCheque {
	
	PENDENTE("Pendente"),
	DEPOSITADO("Depositado"),
	SEM_FUNDOS("Sem Fundos"),
	EXTRAVIADO("Extraviado"),
	CANCELADO("Cancelado"),
	OUTROS("Outros");
		
	private String descricao;
		
	StatusCheque(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public Collection<String> getDescricoes(){
		Collection<String> listaCheques = new ArrayList<String>();
		for(StatusCheque sc : StatusCheque.values()){
			listaCheques.add(sc.getDescricao());
		}
		
		return listaCheques;
	}
}
