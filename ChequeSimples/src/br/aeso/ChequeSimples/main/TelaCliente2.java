package br.aeso.ChequeSimples.main;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.aeso.ChequeSimples.cliente.Cliente;
import br.aeso.ChequeSimples.excecoes.CPFInvalidoException;
import br.aeso.ChequeSimples.excecoes.CampoObrigatorioInvalidoException;
import br.aeso.ChequeSimples.excecoes.ClienteJaCadastradoException;
import br.aeso.ChequeSimples.excecoes.ClienteNaoEncontradoException;
import br.aeso.ChequeSimples.excecoes.ClientesVazioException;
import br.aeso.ChequeSimples.excecoes.IdadeInvalidaException;
import br.aeso.ChequeSimples.fachada.Fachada;
 
public class TelaCliente2 {
 
    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtIdade;
    private JTextField txtLogradouro;
    private JTextField txtNumero;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtUf;
    private Fachada fachada;
    private JTable table;
    private DefaultTableModel defaultTableModel;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCliente2 window = new TelaCliente2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    /**
     * Create the application.
     * @throws IOException 
     */
    public TelaCliente2() throws IOException {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     * @throws IOException 
     */
    private void initialize() throws IOException {
        fachada = Fachada.getInstance();
        frame = new JFrame();
        frame.setBounds(100, 100, 546, 365);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
         
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 510, 47);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
         
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cadastrar();
            }
        });
        btnCadastrar.setBounds(0, 11, 102, 23);
        panel.add(btnCadastrar);
         
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(102, 11, 102, 23);
        panel.add(btnAtualizar);
         
        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                remover();
            }
        });
        btnRemover.setBounds(204, 11, 102, 23);
        panel.add(btnRemover);
         
        JButton btnProcurar = new JButton("Procurar");
        btnProcurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					procurar();
				} catch (CPFInvalidoException | ClienteNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnProcurar.setBounds(306, 11, 102, 23);
        panel.add(btnProcurar);
         
        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					listar();
				} catch (ClientesVazioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnListar.setBounds(408, 11, 102, 23);
        panel.add(btnListar);
         
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 65, 510, 112);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
         
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 11, 46, 14);
        panel_1.add(lblNome);
         
        txtNome = new JTextField();
        txtNome.setBounds(45, 8, 139, 20);
        panel_1.add(txtNome);
        txtNome.setColumns(10);
         
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(194, 11, 46, 14);
        panel_1.add(lblCpf);
         
        txtCpf = new JTextField();
        txtCpf.setBounds(232, 8, 86, 20);
        panel_1.add(txtCpf);
        txtCpf.setColumns(10);
         
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(349, 11, 46, 14);
        panel_1.add(lblIdade);
         
        txtIdade = new JTextField();
        txtIdade.setBounds(414, 8, 86, 20);
        panel_1.add(txtIdade);
        txtIdade.setColumns(10);
         
        JLabel lblLogradouro = new JLabel("Logradouro:");
        lblLogradouro.setBounds(20, 39, 72, 14);
        panel_1.add(lblLogradouro);
         
        txtLogradouro = new JTextField();
        txtLogradouro.setBounds(102, 39, 86, 20);
        panel_1.add(txtLogradouro);
        txtLogradouro.setColumns(10);
         
        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(216, 39, 46, 14);
        panel_1.add(lblNumero);
         
        txtNumero = new JTextField();
        txtNumero.setBounds(272, 36, 86, 20);
        panel_1.add(txtNumero);
        txtNumero.setColumns(10);
         
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(20, 81, 46, 14);
        panel_1.add(lblBairro);
         
        txtBairro = new JTextField();
        txtBairro.setBounds(76, 78, 86, 20);
        panel_1.add(txtBairro);
        txtBairro.setColumns(10);
         
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(172, 81, 46, 14);
        panel_1.add(lblCidade);
         
        txtCidade = new JTextField();
        txtCidade.setBounds(232, 78, 86, 20);
        panel_1.add(txtCidade);
        txtCidade.setColumns(10);
         
        JLabel lblUf = new JLabel("UF:");
        lblUf.setBounds(349, 81, 46, 14);
        panel_1.add(lblUf);
         
        txtUf = new JTextField();
        txtUf.setBounds(401, 78, 86, 20);
        panel_1.add(txtUf);
        txtUf.setColumns(10);
         
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 183, 510, 133);
        frame.getContentPane().add(scrollPane);
         
        table = new JTable();
        String colunaTabelaCliente[] = new String[] {"ID", "Nome", "CPF", "Idade"};
        defaultTableModel = new DefaultTableModel(new Object[][] {},colunaTabelaCliente);
        table.setModel(defaultTableModel);
        scrollPane.setViewportView(table);
    }
     
    private void cadastrar() {
        String logradouro   = txtLogradouro.getText();
        String numero       = txtNumero.getText();
        String bairro       = txtBairro.getText();
        String cidade       = txtCidade.getText();
        String estado       = txtUf.getText();
        String nome         = txtNome.getText();
        String cpf          = txtCpf.getText();
        int idade           = (txtIdade.getText().equals("")) ? 0 : Integer.parseInt(txtIdade.getText());    
      //  Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado);
        Cliente cliente = new Cliente(nome, cpf);
         
        try {
            fachada.cadastrarCliente(cliente);
            JOptionPane.showMessageDialog(frame, "Cliente Cadastrado com Sucesso");
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (CPFInvalidoException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ClienteJaCadastradoException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (CampoObrigatorioInvalidoException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IdadeInvalidaException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public void remover() {
        try {
            fachada.removerCliente(txtCpf.getText());
            JOptionPane.showMessageDialog(frame, "Cliente removido com Sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            // Envia SMS
            // Envia Email
            // Grava Log em arquivo
        }
     
    }
     
    private void procurar() throws CPFInvalidoException, ClienteNaoEncontradoException {
      
            Cliente cliente = fachada.procurarCliente(txtCpf.getText());
            txtNome.setText(cliente.getNome());
            txtIdade.setText(String.valueOf(cliente.getNome()));
        
    }
     
    private void listar() throws ClientesVazioException {
        defaultTableModel.setNumRows(0);
        ArrayList<Cliente> lista = fachada.listarCliente();
        for(Cliente cliente: lista) {
            Object[] vector = new Object[3];
            vector[0] = cliente.getId();
            vector[1] = cliente.getNome();
            vector[2] = cliente.getCpfFormatado();
            defaultTableModel.addRow(vector);
        }
    }
}