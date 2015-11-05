package br.aeso.ChequeSimples.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FramePrincipal extends JFrame {

	private JPanel contentPaneTPrinc;

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600, 400);
		contentPaneTPrinc = new JPanel();
		contentPaneTPrinc.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTPrinc);
		
		JButton btnTPrinc_NovoCliente = new JButton("Novo");
		
		JButton btnNovoUsurio = new JButton("Novo Usu\u00E1rio");
		
		JLabel lblTPrinc_Cliente = new JLabel("Cliente");
		
		JButton btnTPrinc_PesquisarCliente = new JButton("Pesquisar");
		
		GroupLayout gl_contentPaneTPrinc = new GroupLayout(contentPaneTPrinc);
		
		gl_contentPaneTPrinc.setHorizontalGroup(
			gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNovoUsurio)
						.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
							.addComponent(btnTPrinc_NovoCliente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTPrinc_PesquisarCliente))
						.addComponent(lblTPrinc_Cliente))
					.addContainerGap(272, Short.MAX_VALUE))
		);
		
		gl_contentPaneTPrinc.setVerticalGroup(
			gl_contentPaneTPrinc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTPrinc.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTPrinc_Cliente)
					.addGap(11)
					.addGroup(gl_contentPaneTPrinc.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTPrinc_NovoCliente)
						.addComponent(btnTPrinc_PesquisarCliente))
					.addGap(45)
					.addComponent(btnNovoUsurio)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		contentPaneTPrinc.setLayout(gl_contentPaneTPrinc);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
