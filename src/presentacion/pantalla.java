package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class pantalla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CardLayout cardLayout;
	private JTextField textField;
	private JPasswordField passwordField;
	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla frame = new pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 722, 22);
		contentPane.add(menuBar);
		
		JMenu mnElementos = new JMenu("Elementos");
		menuBar.add(mnElementos);
		
		JMenuItem mntmTabla = new JMenuItem("Tabla");
		
		mnElementos.add(mntmTabla);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		
		mnElementos.add(mntmLista);
		
		JMenuItem mntmElementos = new JMenuItem("Elementos");
		
		mnElementos.add(mntmElementos);
		
		JPanel panelMaster = new JPanel();
		panelMaster.setBounds(0, 22, 722, 433);
		contentPane.add(panelMaster);
		panelMaster.setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout)panelMaster.getLayout();
		
		JPanel panelEmpty = new JPanel();
		panelMaster.add(panelEmpty, "PANEL_EMPTY");
		
		JPanel panelTable = new JPanel();
		panelMaster.add(panelTable, "PANEL_TABLE");
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 51, 567, 299);
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CI", "Nombre", "Apellido", "Generacion", "Orientacion"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		scrollPane.setViewportView(table);
		
		JPanel panelLista = new JPanel();
		panelMaster.add(panelLista, "PANEL_LISTA");
		panelLista.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(198, 54, 322, 306);
		panelLista.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JPanel panelElemntos = new JPanel();
		panelMaster.add(panelElemntos, "PANEL_ELEMENTOS");
		panelElemntos.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(310, 50, 238, 26);
		panelElemntos.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(310, 99, 238, 26);
		panelElemntos.add(passwordField);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(310, 153, 116, 26);
		panelElemntos.add(spinner);
		
		JRadioButton rdbtnOpcion = new JRadioButton("Opcion 1");
		rdbtnOpcion.setBounds(310, 211, 105, 23);
		panelElemntos.add(rdbtnOpcion);
		
		JRadioButton rdbtnOpcion_1 = new JRadioButton("Opcion 2");
		rdbtnOpcion_1.setBounds(441, 211, 141, 23);
		panelElemntos.add(rdbtnOpcion_1);
		
		buttonGroup.add(rdbtnOpcion_1);
		buttonGroup.add(rdbtnOpcion);
		
		JLabel lblJtextfield = new JLabel("JTextField");
		lblJtextfield.setBounds(168, 55, 83, 16);
		panelElemntos.add(lblJtextfield);
		
		JLabel lblJpasswordfield = new JLabel("JPasswordField");
		lblJpasswordfield.setBounds(168, 104, 116, 16);
		panelElemntos.add(lblJpasswordfield);
		
		JLabel lblJspinner = new JLabel("JSpinner");
		lblJspinner.setBounds(169, 158, 61, 16);
		panelElemntos.add(lblJspinner);
		
		JLabel lblJradiobuttonConButtongroup = new JLabel("JRadioButton con ButtonGroup");
		lblJradiobuttonConButtongroup.setBounds(98, 215, 200, 16);
		panelElemntos.add(lblJradiobuttonConButtongroup);
		
		mntmTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelMaster, "PANEL_TABLE");
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				
				dm.addRow(new Object[] {
						"13324412", "Carlos", "Fernandez", "2019", "TIC"
				});
			}
		});
		
		mntmLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelMaster, "PANEL_LISTA");
			}
		});
		
		mntmElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelMaster, "PANEL_ELEMENTOS");
			}
		});
	}
}
