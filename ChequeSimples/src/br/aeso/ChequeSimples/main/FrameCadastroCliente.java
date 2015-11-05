package br.aeso.ChequeSimples.main;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.cliente.ControladorCliente;
import br.aeso.ChequeSimples.enums.EstadosBrasileirosEnum;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;

public class FrameCadastroCliente extends JFrame {

	private JPanel contentPaneTCadCli;
	private static String tituloDaJanelaCadastroCliente = "Cadastrar Cliente";
	private JTextField textFieldTCadCli_NomeRazao;
	private JTextField textFieldTCadCli_CpfCnpj;
	private JTextField textFieldTCadCli_Logradouro;
	private JTextField textFieldTCadCli_NumeroEndereco;
	private JTextField textFieldTCadCli_Bairro;
	private JTextField textFieldTCadCli_Cidade;
	private JTextField textFieldTCadCli_Cep;

	public static void metodoSetTextoVolatil(JTextField campoTexto){
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
					campoTexto.setForeground(Color.BLACK);
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
		setSize(600, 350);
		contentPaneTCadCli = new JPanel();
		contentPaneTCadCli.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTCadCli);
		
		JLabel lblTCadCli_NomeRazao = new JLabel("Nome / Raz\u00E3o Social:");
		
		JLabel lblTCadCli_CpfCnpj = new JLabel("CPF / CNPJ:");
		
		JLabel lblTCadCli_Pessoa = new JLabel("Pessoa:");
		
		JLabel lblTCadCli_Endereco = new JLabel("Endere\u00E7o");
		lblTCadCli_Endereco.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTCadCli_Logradouro = new JLabel("Logradouro:");
		
		JLabel lblTCadCli_Numero = new JLabel("N\u00FAmero:");
		
		JLabel lblTCadCli_Bairro = new JLabel("Bairro:");
		
		JLabel lblTCadCli_Cidade = new JLabel("Cidade:");
		
		JLabel lblTCadCli_Estado = new JLabel("Estado:");
		
		JLabel lblTCadCli_Cep = new JLabel("CEP:");
		
		textFieldTCadCli_NomeRazao = new JTextField("Digite o nome ou razão social");
		textFieldTCadCli_NomeRazao.setForeground(Color.GRAY);
		textFieldTCadCli_NomeRazao.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_NomeRazao);
		
		textFieldTCadCli_CpfCnpj = new JTextField("Digite o CPF ou CNPJ");
		textFieldTCadCli_CpfCnpj.setForeground(Color.GRAY);
		textFieldTCadCli_CpfCnpj.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_CpfCnpj);
		
		textFieldTCadCli_Logradouro = new JTextField("Digite o logradouro");
		textFieldTCadCli_Logradouro.setForeground(Color.GRAY);
		textFieldTCadCli_Logradouro.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Logradouro);
		
		textFieldTCadCli_NumeroEndereco = new JTextField("Digite o número");
		textFieldTCadCli_NumeroEndereco.setForeground(Color.GRAY);
		textFieldTCadCli_NumeroEndereco.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_NumeroEndereco);
		
		textFieldTCadCli_Bairro = new JTextField("Digite o bairro");
		textFieldTCadCli_Bairro.setForeground(Color.GRAY);
		textFieldTCadCli_Bairro.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Bairro);
		
		textFieldTCadCli_Cidade = new JTextField("Digite a cidade");
		textFieldTCadCli_Cidade.setForeground(Color.GRAY);
		textFieldTCadCli_Cidade.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Cidade);
		
		textFieldTCadCli_Cep = new JTextField("Digite o CEP");
		textFieldTCadCli_Cep.setForeground(Color.GRAY);
		textFieldTCadCli_Cep.setColumns(10);
		metodoSetTextoVolatil(textFieldTCadCli_Cep);
		
		ButtonGroup bgTCadCli_Pessoa = new ButtonGroup();  
		
		JRadioButton rdbtnTCadCli_PFisica = new JRadioButton("Física");
		//rdbtnTCadCli_PFisica.setSelected(true);
		
		JRadioButton rdbtnTCadCli_PJuridica = new JRadioButton("Jurídica");
		
		bgTCadCli_Pessoa.add(rdbtnTCadCli_PFisica);
		bgTCadCli_Pessoa.add(rdbtnTCadCli_PJuridica);
		
		JComboBox comboBoxTCadCli_Estado = new JComboBox();
		comboBoxTCadCli_Estado.setModel(new DefaultComboBoxModel(EstadosBrasileirosEnum.values()));
		comboBoxTCadCli_Estado.setToolTipText("");
		comboBoxTCadCli_Estado.setSelectedIndex(15);
		
		JButton btnTCadCli_Salvar = new JButton("Salvar");
		btnTCadCli_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente novoCliente = new Cliente();
				
				novoCliente.setNome(textFieldTCadCli_NomeRazao.getText());
				novoCliente.setCpf(textFieldTCadCli_CpfCnpj.getText());
				novoCliente.getEndereco().setLogradouro(textFieldTCadCli_Logradouro.getText());
				novoCliente.getEndereco().setNumero(Integer.parseInt(textFieldTCadCli_NumeroEndereco.getText()));
				novoCliente.getEndereco().setBairro(textFieldTCadCli_Bairro.getText());
				novoCliente.getEndereco().setCidade(textFieldTCadCli_Cidade.getText());
				novoCliente.getEndereco().setEstado(comboBoxTCadCli_Estado.getSelectedItem().toString());
				novoCliente.getEndereco().setCep(textFieldTCadCli_Cep.getText());
				ControladorCliente controladorCliente = new ControladorCliente();
				
				try {
					controladorCliente.cadastrar(novoCliente);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ClienteJaCadastradoException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (CampoObrigatorioInvalidoException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		
		JButton btnTCadCli_Cancelar = new JButton("Cancelar");
		btnTCadCli_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				System.exit(0);
			}
		});
		
		JButton btnTCadCli_Limpar = new JButton("Limpar");
		btnTCadCli_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldTCadCli_NomeRazao.setText("");
				textFieldTCadCli_CpfCnpj.setText("");
				bgTCadCli_Pessoa.clearSelection();
				textFieldTCadCli_Logradouro.setText("");
				textFieldTCadCli_NumeroEndereco.setText("");
				textFieldTCadCli_Bairro.setText("");
				textFieldTCadCli_Cidade.setText("");
				comboBoxTCadCli_Estado.setSelectedIndex(15);
				textFieldTCadCli_Cep.setText("");
			}
		});
		
		GroupLayout gl_contentPaneTCadCli = new GroupLayout(contentPaneTCadCli);
		
		gl_contentPaneTCadCli.setHorizontalGroup(
			gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCadCli_NomeRazao)
						.addComponent(lblTCadCli_CpfCnpj)
						.addComponent(lblTCadCli_Pessoa)
						.addComponent(lblTCadCli_Logradouro)
						.addComponent(lblTCadCli_Numero)
						.addComponent(lblTCadCli_Bairro)
						.addComponent(lblTCadCli_Cidade)
						.addComponent(lblTCadCli_Estado)
						.addComponent(lblTCadCli_Cep))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addComponent(btnTCadCli_Salvar)
							.addGap(18)
							.addComponent(btnTCadCli_Limpar)
							.addGap(18)
							.addComponent(btnTCadCli_Cancelar))
						.addComponent(lblTCadCli_Endereco)
						.addComponent(comboBoxTCadCli_Estado, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_Cidade, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_Bairro, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_NumeroEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_Logradouro, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addComponent(rdbtnTCadCli_PFisica)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnTCadCli_PJuridica))
						.addComponent(textFieldTCadCli_NomeRazao, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_Cep, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_CpfCnpj, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		gl_contentPaneTCadCli.setVerticalGroup(
			gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCli_NomeRazao)
						.addComponent(textFieldTCadCli_NomeRazao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCli_CpfCnpj)
						.addComponent(textFieldTCadCli_CpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addComponent(lblTCadCli_Pessoa)
							.addGap(22))
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnTCadCli_PFisica)
								.addComponent(rdbtnTCadCli_PJuridica))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTCadCli_Endereco)
							.addGap(6)))
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCadCli_Logradouro)
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTCadCli_Logradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCadCli_Numero)
						.addComponent(textFieldTCadCli_NumeroEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCli_Bairro)
						.addComponent(textFieldTCadCli_Bairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCli_Cidade)
						.addComponent(textFieldTCadCli_Cidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCli_Estado)
						.addComponent(comboBoxTCadCli_Estado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCadCli_Cep)
						.addComponent(textFieldTCadCli_Cep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTCadCli_Salvar)
						.addComponent(btnTCadCli_Limpar)
						.addComponent(btnTCadCli_Cancelar))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPaneTCadCli.setLayout(gl_contentPaneTCadCli);
		
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
