package br.aeso.ChequeSimples.util;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PegarDataHoje {
	public static String data = getDataHoje();
	public String getDataHoje() {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		return formato.format(data);
	}
}
