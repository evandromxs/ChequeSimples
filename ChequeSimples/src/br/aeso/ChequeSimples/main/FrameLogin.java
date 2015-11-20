package br.aeso.ChequeSimples.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrameLogin extends JFrame{

	private JPanel contentPaneTLogin;
	private JPasswordField pwdTLogin_Senha;
	private JTextField txtTLogin_Usuario;
	
	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		setTitle("ChequeSimples");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(340, 410);
		contentPaneTLogin = new JPanel();
		contentPaneTLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		JLabel lblSenha = new JLabel("Senha:");
		
		pwdTLogin_Senha = new JPasswordField();
		
		txtTLogin_Usuario = new JTextField();
		txtTLogin_Usuario.setColumns(10);
		
		JButton btnTLogin_Ok = new JButton("OK");
		
		JButton btnTLogin_Sair = new JButton("Sair");
		btnTLogin_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnTestar = new JButton("Testar");
		btnTestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GerenciadorDeTelas.fecharTelaLogin();
					GerenciadorDeTelas.abrirTelaPrincipal();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JLabel lblIconeChequeTela = new JLabel("");
		lblIconeChequeTela.setIcon(new ImageIcon(FrameLogin.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon_G.png")));
		
		GroupLayout gl_contentPaneTLogin = new GroupLayout(contentPaneTLogin);
		gl_contentPaneTLogin.setHorizontalGroup(
			gl_contentPaneTLogin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPaneTLogin.createSequentialGroup()
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPaneTLogin.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(lblUsuario))
							.addGap(18)
							.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneTLogin.createSequentialGroup()
									.addComponent(btnTLogin_Ok)
									.addGap(18)
									.addComponent(btnTLogin_Sair)
									.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
									.addComponent(btnTestar))
								.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPaneTLogin.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(pwdTLogin_Senha))
									.addComponent(txtTLogin_Usuario, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPaneTLogin.createSequentialGroup()
							.addGap(46)
							.addComponent(lblIconeChequeTela)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPaneTLogin.setVerticalGroup(
			gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTLogin.createSequentialGroup()
					.addGap(28)
					.addComponent(lblIconeChequeTela)
					.addGap(36)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTLogin_Usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(21)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(pwdTLogin_Senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTLogin_Ok)
						.addComponent(btnTLogin_Sair)
						.addComponent(btnTestar))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPaneTLogin.setLayout(gl_contentPaneTLogin);
	}
	
	public void confirmarSaida(){
		int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja encerrar o programa?", "Sair",JOptionPane.YES_NO_OPTION);  
		if (i == JOptionPane.YES_OPTION) {  
			System.exit(0);
		} else {
			repaint();
		} 
	}
	
}
