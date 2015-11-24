package br.aeso.ChequeSimples.main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.endereco.Endereco;
import br.aeso.ChequeSimples.enums.EstadosBrasileirosEnum;
import br.aeso.ChequeSimples.excecoes.CPFInvalidoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.EnderecoJaCadastradoException;
import br.aeso.ChequeSimples.fachada.Fachada;

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
	private JTextField textFieldTCadCli_Telefone;
	private MaskFormatter mascaraCep;
	private MaskFormatter mascaraTelefone;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FrameCadastroCliente() throws ParseException {
		super(tituloDaJanelaCadastroCliente);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCadastroCliente.class.getResource("/br/aeso/ChequeSimples/files/chq_programIcon.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 798, 599);
		setSize(600, 420);
		contentPaneTCadCli = new JPanel();
		contentPaneTCadCli.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTCadCli);
		mascaraCep = new MaskFormatter("##.###-###");
		mascaraTelefone = new MaskFormatter("(##)#####-####");
		
		JLabel lblTCadCli_NomeRazao = new JLabel("Nome / Raz�o Social:");
		
		JLabel lblTCadCli_CpfCnpj = new JLabel("CPF / CNPJ:");
		
		JLabel lblTCadCli_Pessoa = new JLabel("Pessoa:");
		
		JLabel lblTCadCli_Endereco = new JLabel("Endere�o");
		lblTCadCli_Endereco.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTCadCli_Logradouro = new JLabel("Logradouro:");
		
		JLabel lblTCadCli_Numero = new JLabel("N�mero:");
		
		JLabel lblTCadCli_Bairro = new JLabel("Bairro:");
		
		JLabel lblTCadCli_Cidade = new JLabel("Cidade:");
		
		JLabel lblTCadCli_Estado = new JLabel("Estado:");
		
		JLabel lblTCadCli_Cep = new JLabel("CEP:");
		
		JLabel lblTelefone = new JLabel("Telefone:");

		textFieldTCadCli_NomeRazao = new JTextField("Digite o nome ou raz�o social");
		textFieldTCadCli_NomeRazao.setForeground(Color.GRAY);
		textFieldTCadCli_NomeRazao.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_NomeRazao);
		
		textFieldTCadCli_CpfCnpj = new JTextField("Digite o CPF ou CNPJ");
		textFieldTCadCli_CpfCnpj.setForeground(Color.GRAY);
		textFieldTCadCli_CpfCnpj.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_CpfCnpj);
		
		textFieldTCadCli_Logradouro = new JTextField("Digite o logradouro");
		textFieldTCadCli_Logradouro.setForeground(Color.GRAY);
		textFieldTCadCli_Logradouro.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_Logradouro);
		
		textFieldTCadCli_NumeroEndereco = new JTextField("Digite o n�mero");
		textFieldTCadCli_NumeroEndereco.setForeground(Color.GRAY);
		textFieldTCadCli_NumeroEndereco.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_NumeroEndereco);
		
		textFieldTCadCli_Bairro = new JTextField("Digite o bairro");
		textFieldTCadCli_Bairro.setForeground(Color.GRAY);
		textFieldTCadCli_Bairro.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_Bairro);
		
		textFieldTCadCli_Cidade = new JTextField("Digite a cidade");
		textFieldTCadCli_Cidade.setForeground(Color.GRAY);
		textFieldTCadCli_Cidade.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_Cidade);
		
		textFieldTCadCli_Cep = new JFormattedTextField(mascaraCep);
		textFieldTCadCli_Cep.setColumns(10);
		
		textFieldTCadCli_Telefone = new JTextField("Digite o telefone");
		textFieldTCadCli_Telefone.setForeground(Color.GRAY);
		textFieldTCadCli_Telefone.setColumns(10);
		TextoVolatil.metodoSetTextoVolatil(textFieldTCadCli_Telefone);
		
		ButtonGroup bgTCadCli_Pessoa = new ButtonGroup();  
		JRadioButton rdbtnTCadCli_PFisica = new JRadioButton("F�sica");
		JRadioButton rdbtnTCadCli_PJuridica = new JRadioButton("Jur�dica");
		bgTCadCli_Pessoa.add(rdbtnTCadCli_PFisica);
		bgTCadCli_Pessoa.add(rdbtnTCadCli_PJuridica);
		
		JComboBox comboBoxTCadCli_Estado = new JComboBox();
		comboBoxTCadCli_Estado.setModel(new DefaultComboBoxModel(EstadosBrasileirosEnum.values()));
		comboBoxTCadCli_Estado.setSelectedIndex(15);
		
		JButton btnTCadCli_Salvar = new JButton("Salvar");
		btnTCadCli_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente novoCliente = new Cliente(null, null, null, (byte) 0);
				//Endereco novoEndereco = new Endereco();
				
				novoCliente.setPessoa("pj");
				novoCliente.setCpf_cnpj(textFieldTCadCli_CpfCnpj.getText());
				novoCliente.setNome_razaoSocial(textFieldTCadCli_NomeRazao.getText());
				novoCliente.setCpf_cnpj(textFieldTCadCli_CpfCnpj.getText());
				
				//novoEndereco.setLogradouro(textFieldTCadCli_Logradouro.getText());
				//novoEndereco.setNumero(Integer.parseInt(textFieldTCadCli_NumeroEndereco.getText()));
				//novoEndereco.setBairro(textFieldTCadCli_Bairro.getText());
				//novoEndereco.setCidade(textFieldTCadCli_Cidade.getText());
				//novoEndereco.setEstado(comboBoxTCadCli_Estado.getSelectedItem().toString());
				//novoEndereco.setCep(textFieldTCadCli_Cep.getText());
				
				//instanciando a Fachada para chamar o m�todo cadastrar cliente
				Fachada fachada = Fachada.getInstance();
				
				try {
					fachada.cadastrarCliente(novoCliente);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
					GerenciadorDeTelas.fecharTelaCadastroClienteAbrindoTelaPrincipal();
					//Obtendo o ID que est� no BD do novo Cliente e setando para o Endere�o
					//novoEndereco.setIdCliente(novoCliente.getId());
					//fachada.cadastrarEndereco(novoEndereco);
					
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ClienteJaCadastradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (CampoObrigatorioInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (CPFInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} //catch (EnderecoJaCadastradoException e) {
					//JOptionPane.showMessageDialog(null, e.getMessage());
				//}
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
				textFieldTCadCli_Telefone.setText("");
			}
		});
		
		JButton btnTCadCli_Cancelar = new JButton("Cancelar");
		btnTCadCli_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GerenciadorDeTelas.fecharTelaCadastroCliente();
					GerenciadorDeTelas.abrirTelaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
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
						.addComponent(lblTCadCli_Cep)
						.addComponent(lblTelefone))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addComponent(btnTCadCli_Salvar)
							.addGap(18)
							.addComponent(btnTCadCli_Limpar)
							.addGap(18)
							.addComponent(btnTCadCli_Cancelar))
						.addComponent(textFieldTCadCli_Telefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTCadCli_Endereco)
						.addComponent(textFieldTCadCli_Cidade, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_Bairro, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_NumeroEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTCadCli_Logradouro, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addGroup(gl_contentPaneTCadCli.createSequentialGroup()
							.addComponent(rdbtnTCadCli_PFisica)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnTCadCli_PJuridica))
						.addComponent(textFieldTCadCli_NomeRazao, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(textFieldTCadCli_CpfCnpj, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textFieldTCadCli_Cep, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(comboBoxTCadCli_Estado, Alignment.LEADING, 0, 83, Short.MAX_VALUE)))
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
						.addComponent(textFieldTCadCli_Cep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTCadCli_Cep))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(textFieldTCadCli_Telefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPaneTCadCli.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTCadCli_Salvar)
						.addComponent(btnTCadCli_Limpar)
						.addComponent(btnTCadCli_Cancelar))
					.addContainerGap())
		);
		contentPaneTCadCli.setLayout(gl_contentPaneTCadCli);
	}
	
}
