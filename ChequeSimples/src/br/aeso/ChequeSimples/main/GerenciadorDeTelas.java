package br.aeso.ChequeSimples.main;

import java.awt.EventQueue;
import java.text.ParseException;

public class GerenciadorDeTelas {
	
	static FrameLogin frameLogin; 
	static FrameTPrincipal frameTelaPrincipal;
	static FrameCadastroCheque frameCadastroCheque;
	static FrameCadastroBanco frameCadastroBanco;
	static FrameCadastroCliente frameCadastroCliente;
	static FrameCadastroUsuario frameCadastroUsuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abrirTelaLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Fim Main

	public static void abrirTelaLogin(){
		if(frameLogin == null){
			frameLogin = new FrameLogin();
			frameLogin.setVisible(true);
		}
	}
	
	public static void fecharTelaLogin(){
		frameLogin.dispose();
	}
	
	public static void abrirTelaPrincipal(){
		if(frameTelaPrincipal == null){
			frameTelaPrincipal = new FrameTPrincipal();
		}
		frameTelaPrincipal.setVisible(true);
	}
	
	public static void fecharTelaPrincipal(){
		frameTelaPrincipal.setVisible(false);
	}
	
	public static void abrirTelaCadastroBanco(){
		frameCadastroBanco = new FrameCadastroBanco();
		frameCadastroBanco.setVisible(true);
	}
	
	public static void fecharTelaCadastroBanco(){
		frameCadastroBanco.dispose();
	}
	
	public static void abrirTelaCadastroCheque() throws ParseException{
		frameCadastroCheque = new FrameCadastroCheque();
		frameCadastroCheque.setVisible(true);
	}
	
	public static void fecharTelaCadastroCheque(){
		frameCadastroCheque.dispose();
	}
	
	public static void abrirTelaCadastroCliente() throws ParseException{
		frameCadastroCliente = new FrameCadastroCliente();
		frameCadastroCliente.setVisible(true);
	}
	
	public static void fecharTelaCadastroCliente(){
		frameCadastroCliente.dispose();
	}
	
	public static void abrirTelaCadastroUsuario(){
		frameCadastroUsuario = new FrameCadastroUsuario();
		frameCadastroUsuario.setVisible(true);
	}
	
	public static void fecharTelaCadastroUsuario(){
		frameCadastroUsuario.dispose();
	}

}
