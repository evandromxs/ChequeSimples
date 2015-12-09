package br.aeso.ChequeSimples.main;

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
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		
		JLabel lblTLogin_IconeChequeTela = new JLabel();
		lblTLogin_IconeChequeTela.setIcon(new ImageIcon(FrameLogin.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon_G.png")));
		
		JLabel lblTLogin_Usuario = new JLabel("Usuário:");
		
		JLabel lblTLogin_Senha = new JLabel("Senha:");
		
		JLabel lblTLogin_UsuarioOuSenha = new JLabel("Usuário e/ou senha incorretos");
		lblTLogin_UsuarioOuSenha.setForeground(Color.RED);
		lblTLogin_UsuarioOuSenha.setVisible(false);
		
		pwdTLogin_Senha = new JPasswordField();
		pwdTLogin_Senha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				pwdTLogin_Senha.setText("");
				lblTLogin_UsuarioOuSenha.setVisible(false);
			}
		});
		
		txtTLogin_Usuario = new JTextField();
		txtTLogin_Usuario.setColumns(10);
		txtTLogin_Usuario.addKeyListener(new KeyAdapter() {
			int cont = 0;
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER){
		            System.out.println("Apertei ENTER! " + cont++);
		            
		        } 
			}
		});
		
		JButton btnTLogin_Ok = new JButton("OK");
		btnTLogin_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// @GAMBIARRA ¬¬
				String usuarioLogado = autenticaUsuario(txtTLogin_Usuario.getText(), pwdTLogin_Senha.getText()); 
				if(usuarioLogado != null){
					try {
						GerenciadorDeTelas.fecharTelaLogin();
						GerenciadorDeTelas.iniciarTelaPrincipal(usuarioLogado);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}else{
					lblTLogin_UsuarioOuSenha.setVisible(true);
				}
			}
		});
		
		JButton btnTLogin_Sair = new JButton("Sair");
		btnTLogin_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		GroupLayout gl_contentPaneTLogin = new GroupLayout(contentPaneTLogin);
		gl_contentPaneTLogin.setHorizontalGroup(
			gl_contentPaneTLogin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPaneTLogin.createSequentialGroup()
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPaneTLogin.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTLogin_Senha)
								.addComponent(lblTLogin_Usuario))
							.addGap(18)
							.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtTLogin_Usuario, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPaneTLogin.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(pwdTLogin_Senha)))
								.addGroup(gl_contentPaneTLogin.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTLogin_UsuarioOuSenha)
										.addGroup(gl_contentPaneTLogin.createSequentialGroup()
											.addComponent(btnTLogin_Ok)
											.addGap(18)
											.addComponent(btnTLogin_Sair)))))
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
						.addGroup(gl_contentPaneTLogin.createSequentialGroup()
							.addGap(46)
							.addComponent(lblTLogin_IconeChequeTela)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPaneTLogin.setVerticalGroup(
			gl_contentPaneTLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTLogin.createSequentialGroup()
					.addGap(28)
					.addComponent(lblTLogin_IconeChequeTela)
					.addGap(36)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTLogin_Usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTLogin_Usuario))
					.addGap(21)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTLogin_Senha)
						.addComponent(pwdTLogin_Senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPaneTLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTLogin_Ok)
						.addComponent(btnTLogin_Sair))
					.addGap(18)
					.addComponent(lblTLogin_UsuarioOuSenha)
					.addContainerGap(24, Short.MAX_VALUE))
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
	
	public String autenticaUsuario(String login, String senha){
		String usuarioLogado;
		if((login.equalsIgnoreCase("admin")) && (senha.equalsIgnoreCase("admin"))){
			usuarioLogado = new String("admin");
		}else{
			usuarioLogado = null;
		}
		return usuarioLogado;
	}
	
}
