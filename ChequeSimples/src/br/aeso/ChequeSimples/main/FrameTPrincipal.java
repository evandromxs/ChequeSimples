package br.aeso.ChequeSimples.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class FrameTPrincipal extends JFrame {

	private JPanel contentPaneTPrinc;
	
	/**
	 * Create the frame.
	 */
	public FrameTPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon.png")));
		setResizable(false);
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 452);
		contentPaneTPrinc = new JPanel();
		contentPaneTPrinc.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTPrinc);
		
		JLabel lblTPrinc_IconeCheque = new JLabel();
		lblTPrinc_IconeCheque.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/chq_icn.png")));
		
		JLabel lblTPrinc_IconeBanco = new JLabel();
		lblTPrinc_IconeBanco.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/bnc_icn.png")));
		
		JLabel lblTPrinc_IconeCliente = new JLabel();
		lblTPrinc_IconeCliente.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/clnt_icn.png")));
		
		JLabel lblTPrinc_IconeUsuario = new JLabel();
		lblTPrinc_IconeUsuario.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/usr_icn.png")));
		
		JButton btnTPrinc_CadastrarCheque = new JButton("    Cadastrar Cheque");
		btnTPrinc_CadastrarCheque.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/add_icn.png")));
		btnTPrinc_CadastrarCheque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCadastroCheque frameCadCheque;
				try {
					frameCadCheque = new FrameCadastroCheque();
					frameCadCheque.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnTPrinc_CadastrarBanco = new JButton("    Cadastrar Banco");
		btnTPrinc_CadastrarBanco.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/add_icn.png")));
		btnTPrinc_CadastrarBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrameCadastroBanco frameCadBanco = new FrameCadastroBanco();
					frameCadBanco.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnTPrinc_CadastrarCliente = new JButton("    Cadastrar Cliente");
		btnTPrinc_CadastrarCliente.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/add_icn.png")));
		btnTPrinc_CadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrameCadastroCliente frameCadCliente = new FrameCadastroCliente();
					frameCadCliente.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnTPrinc_CadastrarUsuario = new JButton("    Cadastrar Usuário");
		btnTPrinc_CadastrarUsuario.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/add_icn.png")));
		btnTPrinc_CadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrameCadastroUsuario frameCadUsuario = new FrameCadastroUsuario();
					frameCadUsuario.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnTPrinc_PesquisarCheque = new JButton("    Pesquisar Cheque");
		btnTPrinc_PesquisarCheque.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/pesq_icn.png")));
		
		JButton btnTPrinc_PequisarBanco = new JButton("    Pequisar Banco");
		btnTPrinc_PequisarBanco.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/pesq_icn.png")));
		
		JButton btnTPrinc_PesquisarCliente = new JButton("    Pesquisar Cliente");
		btnTPrinc_PesquisarCliente.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/pesq_icn.png")));
		
		JButton btnTPrinc_PesquisarUsuario = new JButton("    Pesquisar Usuário");
		btnTPrinc_PesquisarUsuario.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/pesq_icn.png")));
		
		JButton btnTPrinc_EncerrarPrograma = new JButton("    Encerrar Programa");
		btnTPrinc_EncerrarPrograma.setIcon(new ImageIcon(FrameTPrincipal.class.getResource("/br/aeso/ChequeSimples/files/sai_icn.png")));
		btnTPrinc_EncerrarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja encerrar o programa?", "Sair",JOptionPane.YES_NO_OPTION);  
				if (i == JOptionPane.YES_OPTION) {  
					System.exit(0);  
				} else {
					repaint();
				}  
			}  
		});
		
		
		GroupLayout gl_contentPaneTPrinc = new GroupLayout(contentPaneTPrinc);
		
		gl_contentPaneTPrinc.setHorizontalGroup(
			gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
							.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
									.addComponent(lblTPrinc_IconeUsuario)
									.addGap(18)
									.addComponent(btnTPrinc_CadastrarUsuario, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
								.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
									.addComponent(lblTPrinc_IconeCliente)
									.addGap(18)
									.addComponent(btnTPrinc_CadastrarCliente, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
									.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTPrinc_IconeCheque)
										.addComponent(lblTPrinc_IconeBanco))
									.addGap(18)
									.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
										.addComponent(btnTPrinc_CadastrarCheque, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
										.addComponent(btnTPrinc_CadastrarBanco, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
							.addGap(18)
							.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnTPrinc_PequisarBanco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTPrinc_PesquisarUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTPrinc_PesquisarCheque, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTPrinc_PesquisarCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(15, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPaneTPrinc.createSequentialGroup()
							.addComponent(btnTPrinc_EncerrarPrograma, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(90))))
		);
		
		gl_contentPaneTPrinc.setVerticalGroup(
			gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTPrinc_IconeCheque)
						.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnTPrinc_PesquisarCheque)
							.addComponent(btnTPrinc_CadastrarCheque)))
					.addGap(18)
					.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnTPrinc_CadastrarBanco)
							.addComponent(btnTPrinc_PequisarBanco))
						.addComponent(lblTPrinc_IconeBanco))
					.addGap(18)
					.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
							.addComponent(lblTPrinc_IconeCliente)
							.addGap(18)
							.addComponent(lblTPrinc_IconeUsuario))
						.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
							.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTPrinc_PesquisarCliente)
								.addComponent(btnTPrinc_CadastrarCliente))
							.addGap(48)
							.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTPrinc_PesquisarUsuario)
								.addComponent(btnTPrinc_CadastrarUsuario))))
					.addGap(45)
					.addComponent(btnTPrinc_EncerrarPrograma)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		
		gl_contentPaneTPrinc.linkSize(SwingConstants.VERTICAL, new Component[] {lblTPrinc_IconeCheque, lblTPrinc_IconeBanco, lblTPrinc_IconeCliente, lblTPrinc_IconeUsuario});
		contentPaneTPrinc.setLayout(gl_contentPaneTPrinc);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTPrincipal frameTPrincipal = new FrameTPrincipal();
					frameTPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
