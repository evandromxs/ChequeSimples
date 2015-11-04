package br.aeso.ChequeSimples.main;


import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import br.aeso.ChequeSimples.enums.StatusCheque;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameCadastroCheque extends JFrame {

	private JPanel contentPaneTCadCheque;
	private JTextField txtTCadCheque_CodBanco;
	private JTextField txtTCadCheque_CodCliente;
	private JTextField txtTCadCheque_NumeroCheque;
	private JTextField txtTCadCheque_DataEmissao;
	private JTextField txtTCadCheque_Valor;
	private JTextField txtTCadCheque_DataDeposito;
	private JTextField txtTCadCheque_NomeBanco;
	private JTextField txtTCadCheque_NomeCliente;
	private MaskFormatter mascaraData;
	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FrameCadastroCheque() throws ParseException {
		setTitle("Cadastrar Cheque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 599);
		setSize(780, 360);
		contentPaneTCadCheque = new JPanel();
		contentPaneTCadCheque.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTCadCheque);
		mascaraData = new MaskFormatter("##/##/####");
		
		JLabel lblTCadCheque_Banco = new JLabel("Banco:");
		
		JLabel lblTCadCheque_Cliente = new JLabel("Cliente:");
		
		JLabel lblTCadCheque_Numero = new JLabel("N\u00FAmero:");
		
		JLabel lblTCadCheque_Valor = new JLabel("Valor:");
		
		JLabel lblTCadCheque_DataDeEmissao = new JLabel("Data de Emiss\u00E3o:");
		
		JLabel lblTCadCheque_Status = new JLabel("Status:");
		
		JLabel lblTCadCheque_DataDeDeposito = new JLabel("Data de Dep\u00F3sito:");
		
		JCheckBox chckbxTCadCheque_Cruzado = new JCheckBox("Cruzado");
		
		JCheckBox chckbxTCadCheque_Nominal = new JCheckBox("Nominal");
		
		txtTCadCheque_CodBanco = new JTextField("C�d. Banco");
		txtTCadCheque_CodBanco.setForeground(Color.GRAY);
		txtTCadCheque_CodBanco.setColumns(10);
		FrameCadastroCliente.metodoSetTextoVolatil(txtTCadCheque_CodBanco);
		
		txtTCadCheque_NomeBanco = new JTextField("Nome do banco");
		txtTCadCheque_NomeBanco.setForeground(Color.GRAY);
		txtTCadCheque_NomeBanco.setColumns(10);
		FrameCadastroCliente.metodoSetTextoVolatil(txtTCadCheque_NomeBanco);
		
		txtTCadCheque_CodCliente = new JTextField("C�d. Cliente");
		txtTCadCheque_CodCliente.setForeground(Color.GRAY);
		txtTCadCheque_CodCliente.setColumns(10);
		FrameCadastroCliente.metodoSetTextoVolatil(txtTCadCheque_CodCliente);
		
		txtTCadCheque_NomeCliente = new JTextField("Nome do cliente");
		txtTCadCheque_NomeCliente.setForeground(Color.GRAY);
		txtTCadCheque_NomeCliente.setColumns(10);
		FrameCadastroCliente.metodoSetTextoVolatil(txtTCadCheque_NomeCliente);
		
		txtTCadCheque_NumeroCheque = new JTextField("N�mero do cheque");
		txtTCadCheque_NumeroCheque.setForeground(Color.GRAY);
		txtTCadCheque_NumeroCheque.setColumns(10);
		FrameCadastroCliente.metodoSetTextoVolatil(txtTCadCheque_NumeroCheque);
		
		txtTCadCheque_Valor = new JTextField("Valor do cheque");
		txtTCadCheque_Valor.setForeground(Color.GRAY);
		txtTCadCheque_Valor.setColumns(10);
		FrameCadastroCliente.metodoSetTextoVolatil(txtTCadCheque_Valor);
		
		txtTCadCheque_DataEmissao = new JFormattedTextField(mascaraData);
		txtTCadCheque_DataEmissao.setColumns(10);
		
		txtTCadCheque_DataDeposito = new JFormattedTextField(mascaraData);
		txtTCadCheque_DataDeposito.setColumns(10);
		
		JComboBox comboBoxTCadCheque_Status = new JComboBox();
		comboBoxTCadCheque_Status.setModel(new DefaultComboBoxModel(StatusCheque.PENDENTE.getDescricoes().toArray()));
		
		
		
		JButton btnTCadCheque_ProcurarBanco = new JButton("Procurar...");
		
		JButton btnTCadCheque_ProcurarCliente = new JButton("Procurar...");
		
		JButton btnTCadCheque_Salvar = new JButton("Salvar");
		
		JButton btnTCadCheque_Limpar = new JButton("Limpar");
		btnTCadCheque_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTCadCheque_CodBanco.setText("");
				txtTCadCheque_NomeBanco.setText("");
				txtTCadCheque_CodCliente.setText("");
				txtTCadCheque_NomeCliente.setText("");
				txtTCadCheque_NumeroCheque.setText("");
				txtTCadCheque_Valor.setText("");
				txtTCadCheque_DataEmissao.setText("  /  /    ");
				txtTCadCheque_DataDeposito.setText("  /  /    ");
				comboBoxTCadCheque_Status.setSelectedIndex(-1);
				
			}
		});
		
		JButton btnTCadCheque_Cancelar = new JButton("Cancelar");
		
		GroupLayout gl_contentPaneTCadCheque = new GroupLayout(contentPaneTCadCheque);
		gl_contentPaneTCadCheque.setHorizontalGroup(
			gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCadCheque_Banco)
						.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
							.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTCadCheque_DataDeEmissao)
								.addComponent(lblTCadCheque_Numero)
								.addComponent(lblTCadCheque_Status))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
									.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
											.addComponent(txtTCadCheque_NumeroCheque, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
											.addGap(68)
											.addComponent(lblTCadCheque_Valor))
										.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
											.addComponent(comboBoxTCadCheque_Status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblTCadCheque_DataDeDeposito))
										.addComponent(txtTCadCheque_DataEmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.TRAILING)
										.addComponent(chckbxTCadCheque_Nominal, Alignment.LEADING)
										.addComponent(chckbxTCadCheque_Cruzado, Alignment.LEADING)
										.addComponent(txtTCadCheque_Valor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
										.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
											.addComponent(txtTCadCheque_DataDeposito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(135))))
								.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
									.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtTCadCheque_CodCliente, 0, 0, Short.MAX_VALUE)
										.addComponent(txtTCadCheque_CodBanco, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTCadCheque_NomeCliente, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
										.addComponent(txtTCadCheque_NomeBanco, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)))
								.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
									.addComponent(btnTCadCheque_Salvar)
									.addGap(18)
									.addComponent(btnTCadCheque_Limpar)
									.addGap(18)
									.addComponent(btnTCadCheque_Cancelar)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
								.addComponent(btnTCadCheque_ProcurarCliente)
								.addComponent(btnTCadCheque_ProcurarBanco)))
						.addComponent(lblTCadCheque_Cliente))
					.addGap(25))
		);
		gl_contentPaneTCadCheque.setVerticalGroup(
			gl_contentPaneTCadCheque.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadCheque.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCheque_Banco)
						.addComponent(txtTCadCheque_CodBanco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTCadCheque_NomeBanco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTCadCheque_ProcurarBanco))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCheque_Cliente)
						.addComponent(txtTCadCheque_CodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTCadCheque_NomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTCadCheque_ProcurarCliente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCheque_Numero)
						.addComponent(txtTCadCheque_NumeroCheque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTCadCheque_Valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTCadCheque_Valor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCheque_DataDeEmissao)
						.addComponent(txtTCadCheque_DataEmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCheque_Status)
						.addComponent(txtTCadCheque_DataDeposito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTCadCheque_Status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTCadCheque_DataDeDeposito))
					.addGap(18)
					.addComponent(chckbxTCadCheque_Nominal)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxTCadCheque_Cruzado)
					.addGap(18)
					.addGroup(gl_contentPaneTCadCheque.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTCadCheque_Salvar)
						.addComponent(btnTCadCheque_Limpar)
						.addComponent(btnTCadCheque_Cancelar))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPaneTCadCheque.setLayout(gl_contentPaneTCadCheque);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroCheque frame = new FrameCadastroCheque();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}