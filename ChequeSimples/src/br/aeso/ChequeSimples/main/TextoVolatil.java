package br.aeso.ChequeSimples.main;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextoVolatil {
	
	public static void metodoSetTextoVolatil(JTextField campoTexto){
		campoTexto.addFocusListener(new FocusListener(){
			byte apaguei;
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(apaguei == 0){
					campoTexto.setText("");
					campoTexto.setForeground(Color.BLACK);
				}
				apaguei = 1;
			}
		});
	}
	
}
