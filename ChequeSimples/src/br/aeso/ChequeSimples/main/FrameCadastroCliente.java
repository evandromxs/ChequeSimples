package br.aeso.ChequeSimples.main;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import br.aeso.ChequeSimples.enums.EstadosBrasileirosEnum;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCadastroCliente extends JFrame {

	private JPanel contentPane;
	private static String tituloDaJanelaCadastroCliente = "Cadastrar Cliente";
	private JTextField textFieldTCadCli_NomeRazao;
	private JTextField textFieldTCadCli_CpfCnpj;
	private JTextField textFieldTCadCli_Logradouro;
	private JTextField textFieldTCadCli_NumeroEndereco;
	private JTextField textFieldTCadCli_Bairro;
	private JTextField textFieldTCadCli_Cidade;
	private JTextField textFieldTCadCli_Cep;

	public void metodoSetTextoVolatil(JTextField campoTexto){
		campoTexto.addFocusListener(new FocusListener(){
			byte apaguei;
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(apaguei == 0){
					campoTexto.setText("");
				}
				apaguei = 1;
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public FrameCadastroCliente() {
		super(tituloDaJanelaCadastroCliente);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 599);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomeRazao = new JLabel("Nome / Raz\u00E3o Social:");
		
		JLabel lblCpfCnpj = new JLabel("CPF / CNPJ:");
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		JLabel lblEstado = new JLabel("Estado:");
		
		JLabel lblCep = new JLabel("CEP:");
		
		textFieldTCadCli_NomeRazao = new JTextField("Digite o nome ou razão social");
		textFieldTCadCli_NomeRazao.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_NomeRazao);
		
		textFieldTCadCli_CpfCnpj = new JTextField("Digite o CPF ou CNPJ");
		textFieldTCadCli_CpfCnpj.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_CpfCnpj);
		
		textFieldTCadCli_Logradouro = new JTextField("Digite o logradouro");
		textFieldTCadCli_Logradouro.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Logradouro);
		
		textFieldTCadCli_NumeroEndereco = new JTextField("Digite o número");
		textFieldTCadCli_NumeroEndereco.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_NumeroEndereco);
		
		textFieldTCadCli_Bairro = new JTextField("Digite o bairro");
		textFieldTCadCli_Bairro.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Bairro);
		
		textFieldTCadCli_Cidade = new JTextField("Digite a cidade");
		textFieldTCadCli_Cidade.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Cidade);
		
		textFieldTCadCli_Cep = new JTextField("Digite o CEP");
		textFieldTCadCli_Cep.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Cep);
		
		ButtonGroup bgPessoa = new ButtonGroup();  
		
		JRadioButton rdbtnTCadCli_PFisica = new JRadioButton("F\u00EDsica");
		//rdbtnTCadCli_PFisica.setSelected(true);
		
		JRadioButton rdbtnTCadCli_PJuridica = new JRadioButton("Jur\u00EDdica");
		
		bgPessoa.add(rdbtnTCadCli_PFisica);
		bgPessoa.add(rdbtnTCadCli_PJuridica);
		
		JComboBox comboBoxTCadCli_Estado = new JComboBox();
		comboBoxTCadCli_Estado.setModel(new DefaultComboBoxModel(EstadosBrasileirosEnum.values()));
		comboBoxTCadCli_Estado.setToolTipText("");
		comboBoxTCadCli_Estado.setSelectedIndex(16);
		
		JButton btnTCadCli_Salvar = new JButton("Salvar");
		
		JButton btnTCadCli_Cancelar = new JButton("Cancelar");
		
		JButton btnTCadCli_Limpar = new JButton("Limpar");
		btnTCadCli_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTCadCli_NomeRazao.setText("");
				textFieldTCadCli_CpfCnpj.setText("");
				bgPessoa.clearSelection();
				textFieldTCadCli_Logradouro.setText("");
				textFieldTCadCli_NumeroEndereco.setText("");
				textFieldTCadCli_Bairro.setText("");
				textFieldTCadCli_Cidade.setText("");
				comboBoxTCadCli_Estado.setSelectedIndex(16);
				textFieldTCadCli_Cep.setText("");
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeRazao)
						.addComponent(lblCpfCnpj)
						.addComponent(lblPessoa)
						.addComponent(lblLogradouro)
						.addComponent(lblNumero)
						.addComponent(lblBairro)
						.addComponent(lblCidade)
						.addComponent(lblEstado)
						.addComponent(lblCep))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndereco)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnTCadCli_Salvar)
							.addGap(18)
							.addComponent(btnTCadCli_Limpar)
							.addGap(18)
							.addComponent(btnTCadCli_Cancelar))
						.addComponent(comboBoxTCadCli_Estado, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_Cidade, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_Bairro, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_NumeroEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_Logradouro, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnTCadCli_PFisica)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnTCadCli_PJuridica))
						.addComponent(textFieldTCadCli_NomeRazao, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_Cep, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_CpfCnpj, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeRazao)
						.addComponent(textFieldTCadCli_NomeRazao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpfCnpj)
						.addComponent(textFieldTCadCli_CpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPessoa)
							.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnTCadCli_PFisica)
								.addComponent(rdbtnTCadCli_PJuridica))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEndereco)
							.addGap(6)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogradouro)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTCadCli_Logradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumero)
						.addComponent(textFieldTCadCli_NumeroEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro)
						.addComponent(textFieldTCadCli_Bairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(textFieldTCadCli_Cidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBoxTCadCli_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCep)
						.addComponent(textFieldTCadCli_Cep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTCadCli_Salvar)
						.addComponent(btnTCadCli_Limpar)
						.addComponent(btnTCadCli_Cancelar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroCliente frame = new FrameCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
