package br.aeso.ChequeSimples.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.aeso.ChequeSimples.excecoes.ClientesVazioException;
import br.aeso.ChequeSimples.fachada.Fachada;
import br.aeso.ChequeSimples.util.ResultSetTable;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class FrameConsultaCheque extends JFrame {

	private JPanel contentPane;
	private JTable table;
	final JPanel plistar;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConsultaCheque frame = new FrameConsultaCheque();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClientesVazioException 
	 */
	public FrameConsultaCheque() throws ClientesVazioException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		plistar = new JPanel();
		plistar.setBounds(10, 262, 754, 279);
		contentPane.add(plistar);
		listar();

	}
	private void listar() throws ClientesVazioException {
		plistar.removeAll();
		rs = (ResultSet) Fachada.getInstance().listarCliente();
		try {
			plistar.setLayout(null);
			ResultSetTable rst = new ResultSetTable(rs);
			rst.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  
			rst.setPreferredScrollableViewportSize(new Dimension(240,140));  
	        JScrollPane scrollPane = new JScrollPane(rst);
	        scrollPane.setSize(734, 274);
	        scrollPane.setLocation(10, 5);
	        plistar.add(scrollPane);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
