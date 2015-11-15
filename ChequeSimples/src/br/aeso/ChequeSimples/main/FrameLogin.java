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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(360, 200);
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
				confirmarSaida();
			}
		});
		
		JButton btnTestar = new JButton("Testar");
		btnTestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					FrameTPrincipal frameTPrincipal = new FrameTPrincipal();
					frameTPrincipal.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		GroupLayout gl_contentPaneTLogin = new GroupLayout(contentPaneTLogin);
		gl_contentPaneTLogin.setHorizontalGroup(
			gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(lblSenha))
					.addGap(18)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPaneTLogin.createSequentialGroup()
							.addComponent(btnTLogin_Ok)
							.addGap(18)
							.addComponent(btnTLogin_Sair)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnTestar))
						.addComponent(pwdTLogin_Senha, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(txtTLogin_Usuario))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		gl_contentPaneTLogin.setVerticalGroup(
			gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtTLogin_Usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(pwdTLogin_Senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frameLogin = new FrameLogin();
					frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
