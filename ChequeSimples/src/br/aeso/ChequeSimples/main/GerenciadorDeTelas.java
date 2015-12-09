package br.aeso.ChequeSimples.main;

import java.awt.EventQueue;
import java.text.ParseException;
import javax.swing.JOptionPane;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;

public class GerenciadorDeTelas {
	
	static FrameLogin frameLogin; 
	static FrameTPrincipal frameTelaPrincipal;
	static FrameCadastroCheque frameCadastroCheque;
	static FrameCadastroBanco frameCadastroBanco;
	static FrameCadastroCliente frameCadastroCliente;
	static FrameCadastroUsuario frameCadastroUsuario;
	static FrameConsultaCheque frameConsultaCheque;
	
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
	
	public static void iniciarTelaPrincipal(String usuarioLogado){
		frameTelaPrincipal = new FrameTPrincipal(usuarioLogado);
		frameTelaPrincipal.setVisible(true);
	}
	
	public static void abrirTelaPrincipal(){
		if(frameTelaPrincipal == null){
//			frameTelaPrincipal = new FrameTPrincipal();
			JOptionPane.showConfirmDialog(null, "Erro. Reinicie o programa.", "Erro Abrir Tela Principal", 0);
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
	
	public static void abrirTelaConsultaCheque() throws ParseException, ClientesVazioException{
		frameConsultaCheque = new FrameConsultaCheque();
		frameConsultaCheque.setVisible(true);
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
	
	public static void fecharTelaCadastroClienteAbrindoTelaPrincipal(){
		frameCadastroCliente.dispose();
		abrirTelaPrincipal();
	}
	
	public static void abrirTelaCadastroUsuario(){
		frameCadastroUsuario = new FrameCadastroUsuario();
		frameCadastroUsuario.setVisible(true);
	}
	
	public static void fecharTelaCadastroUsuario(){
		frameCadastroUsuario.dispose();
	}
	
	public static String converterParaDataBrasileira(String dataEstrangeira){
		dataEstrangeira = dataEstrangeira.replaceAll("[^0-9 ]", "");
		String dataBrasileira = dataEstrangeira.substring(6, 8) + "/" + dataEstrangeira.substring(4, 6) + "/" + dataEstrangeira.substring(0, 4); 
		return dataBrasileira;
	}
	
	public static String converterParaDataEstrangeira(String dataBrasileira){
		dataBrasileira = dataBrasileira.replaceAll("[^0-9 ]", "");
		String dataEstrangeira = dataBrasileira.substring(4, 8) + "-" + dataBrasileira.substring(2, 4) + "-" + dataBrasileira.substring(0, 2);
		return dataEstrangeira;
	}
	
}
