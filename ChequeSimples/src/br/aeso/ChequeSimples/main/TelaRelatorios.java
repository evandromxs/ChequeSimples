package br.aeso.ChequeSimples.main;
import br.aeso.ChequeSimples.util.*;

public class TelaRelatorios {
	
	public static void main(String[] args) {
		
		PegarDataHoje datahoje = new PegarDataHoje();
		
		System.out.println(datahoje.getDataHoje());

	}

}
