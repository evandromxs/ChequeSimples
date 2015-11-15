package br.aeso.ChequeSimples.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class FrameCadastroBanco extends JFrame {

	private JPanel contentPaneTCadBanco;
	private JTextField textFieldTCadBanco_Codigo;
	private JTextField textFieldTCadBanco_Nome;
	private JButton btnTCadBanco_Limpar;
	private JButton btnTCadBanco_Cancelar;

	/**
	 * Create the frame.
	 */
	public FrameCadastroBanco() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCadastroBanco.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon.png")));
		setResizable(false);
		setTitle("Cadastrar Banco");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 798, 599);
		setSize(600, 155);
		contentPaneTCadBanco = new JPanel();
		contentPaneTCadBanco.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTCadBanco);
		
		JLabel lblTCadBanco_Codigo = new JLabel("C�digo:");
		
		JLabel lblTCadBanco_Nome = new JLabel("Nome:");
		
		textFieldTCadBanco_Codigo = new JTextField("Digite o c�digo");
		textFieldTCadBanco_Codigo.setForeground(Color.GRAY);
		textFieldTCadBanco_Codigo.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadBanco_Codigo);
		
		textFieldTCadBanco_Nome = new JTextField("Digite o nome do banco");
		textFieldTCadBanco_Nome.setForeground(Color.GRAY);
		textFieldTCadBanco_Nome.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadBanco_Nome);
		
		JButton btnTCadBanco_Salvar = new JButton("Salvar");
		
		btnTCadBanco_Limpar = new JButton("Limpar");
		btnTCadBanco_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTCadBanco_Codigo.setText("");
				textFieldTCadBanco_Nome.setText("");
			}
		});
		
		btnTCadBanco_Cancelar = new JButton("Cancelar");
		btnTCadBanco_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrameTPrincipal frameTPrincipal = new FrameTPrincipal();
				frameTPrincipal.setVisible(true);
			}
		});
		
		GroupLayout gl_contentPaneTCadBanco = new GroupLayout(contentPaneTCadBanco);
		gl_contentPaneTCadBanco.setHorizontalGroup(
			gl_contentPaneTCadBanco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadBanco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadBanco.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCadBanco_Codigo)
						.addComponent(lblTCadBanco_Nome))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadBanco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneTCadBanco.createSequentialGroup()
							.addComponent(btnTCadBanco_Salvar)
							.addGap(18)
							.addComponent(btnTCadBanco_Limpar)
							.addGap(18)
							.addComponent(btnTCadBanco_Cancelar))
						.addComponent(textFieldTCadBanco_Nome, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
						.addComponent(textFieldTCadBanco_Codigo, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		gl_contentPaneTCadBanco.setVerticalGroup(
			gl_contentPaneTCadBanco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadBanco.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadBanco.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadBanco_Codigo)
						.addComponent(textFieldTCadBanco_Codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadBanco.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTCadBanco_Nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTCadBanco_Nome))
					.addGap(18)
					.addGroup(gl_contentPaneTCadBanco.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTCadBanco_Salvar)
						.addComponent(btnTCadBanco_Limpar)
						.addComponent(btnTCadBanco_Cancelar))
					.addContainerGap(260, Short.MAX_VALUE))
		);
		contentPaneTCadBanco.setLayout(gl_contentPaneTCadBanco);
	}
	
}
