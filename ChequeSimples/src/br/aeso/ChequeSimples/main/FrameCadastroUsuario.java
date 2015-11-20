package br.aeso.ChequeSimples.main;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class FrameCadastroUsuario extends JFrame {

	private JPanel contentPaneTCadUsu;
	private JTextField textFieldTCadUsu_Nome;
	private JTextField textFieldTCadUsu_Cpf;
	private JPasswordField pwdTCadUsu_Senha;
	private JRadioButton rdbtnTCadUsu_Funcionario;
	private JTextField JRadioButton;

	/**
	 * Create the frame.
	 */
	public FrameCadastroUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCadastroUsuario.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon.png")));
		setResizable(false);
		setTitle("Cadastrar Usuário");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 798, 599);
		setSize(600, 250);
		contentPaneTCadUsu = new JPanel();
		contentPaneTCadUsu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTCadUsu);
		
		JLabel lblTCadUsu_Nome = new JLabel("Nome:");
		
		JLabel lblTCadUsu_Cpf = new JLabel("CPF:");
		
		JLabel lblTCadUsu_Senha = new JLabel("Senha:");
		
		JLabel lblTCadUsu_Perfil = new JLabel("Perfil de Usuário:");
		
		textFieldTCadUsu_Nome = new JTextField("Digite o nome");
		textFieldTCadUsu_Nome.setForeground(Color.GRAY);
		textFieldTCadUsu_Nome.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadUsu_Nome);
		
		textFieldTCadUsu_Cpf = new JTextField("Digite o CPF");
		textFieldTCadUsu_Cpf.setForeground(Color.GRAY);
		textFieldTCadUsu_Cpf.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadUsu_Cpf);
		
		ButtonGroup bgTCadUsu_Perfil = new ButtonGroup();  
		
		JRadioButton rdbtnTCadUsu_Funcionario = new JRadioButton("Funcionário");
		JRadioButton rdbtnTCadUsu_Admin = new JRadioButton("Admin");
		
		bgTCadUsu_Perfil.add(rdbtnTCadUsu_Funcionario);
		bgTCadUsu_Perfil.add(rdbtnTCadUsu_Admin);
		rdbtnTCadUsu_Funcionario.setSelected(true);
		
		JCheckBox chckbxTCadUsu_Ativo = new JCheckBox("Ativo");
		chckbxTCadUsu_Ativo.setEnabled(false);
		chckbxTCadUsu_Ativo.setSelected(true);
		
		pwdTCadUsu_Senha = new JPasswordField("");
		pwdTCadUsu_Senha.setToolTipText("Solicite que o usuário digite a senha");
		
		pwdTCadUsu_Senha.addFocusListener(new FocusListener(){
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					pwdTCadUsu_Senha.setText("");
				}
			});
		
		JButton btnTCadUsu_Salvar = new JButton("Salvar");
		
		JButton btnTCadUsu_Limpar = new JButton("Limpar");
		btnTCadUsu_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTCadUsu_Nome.setText("");
				textFieldTCadUsu_Cpf.setText("");
				pwdTCadUsu_Senha.setText("");
				bgTCadUsu_Perfil.clearSelection();
				rdbtnTCadUsu_Funcionario.setSelected(true);
			}
		});
		
		JButton btnTCadUsu_Cancelar = new JButton("Cancelar");
		btnTCadUsu_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorDeTelas.fecharTelaCadastroUsuario();
				GerenciadorDeTelas.abrirTelaPrincipal();
			}
		});
		
		GroupLayout gl_contentPaneTCadUsu = new GroupLayout(contentPaneTCadUsu);
		gl_contentPaneTCadUsu.setHorizontalGroup(
			gl_contentPaneTCadUsu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadUsu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCadUsu_Perfil)
						.addComponent(lblTCadUsu_Senha)
						.addComponent(lblTCadUsu_Nome)
						.addComponent(lblTCadUsu_Cpf))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneTCadUsu.createSequentialGroup()
							.addComponent(btnTCadUsu_Salvar)
							.addGap(18)
							.addComponent(btnTCadUsu_Limpar)
							.addGap(18)
							.addComponent(btnTCadUsu_Cancelar))
						.addComponent(chckbxTCadUsu_Ativo)
						.addComponent(textFieldTCadUsu_Cpf, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdTCadUsu_Senha, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPaneTCadUsu.createSequentialGroup()
							.addComponent(rdbtnTCadUsu_Funcionario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnTCadUsu_Admin))
						.addComponent(textFieldTCadUsu_Nome, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		gl_contentPaneTCadUsu.setVerticalGroup(
			gl_contentPaneTCadUsu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadUsu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadUsu_Nome)
						.addComponent(textFieldTCadUsu_Nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadUsu_Cpf)
						.addComponent(textFieldTCadUsu_Cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadUsu_Senha)
						.addComponent(pwdTCadUsu_Senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadUsu_Perfil)
						.addComponent(rdbtnTCadUsu_Funcionario)
						.addComponent(rdbtnTCadUsu_Admin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxTCadUsu_Ativo)
					.addGap(18)
					.addGroup(gl_contentPaneTCadUsu.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTCadUsu_Salvar)
						.addComponent(btnTCadUsu_Limpar)
						.addComponent(btnTCadUsu_Cancelar))
					.addContainerGap(188, Short.MAX_VALUE))
		);
		contentPaneTCadUsu.setLayout(gl_contentPaneTCadUsu);
	}
	
}
