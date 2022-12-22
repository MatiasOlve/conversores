package conversor.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import conversor.modelo.Moneda;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class AplicationWindow {

	private JFrame frmConversor;
	private JTextField txtIngreseElValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicationWindow window = new AplicationWindow();
					window.frmConversor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversor = new JFrame();
		frmConversor.setResizable(false);
		frmConversor.setTitle("Conversor");
		frmConversor.setBounds(100, 100, 275, 245);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.getContentPane().setLayout(null);
		
		String[] tiposCambios = {"Peso Argentino a Dolar", "Peso Argentino a Euro", "Peso Argentino a Libras",
				"Peso Argentino a Yen", "Peso Argentino a Won", "Dolar a Peso Argentino", 
				"Euro a Peso Argentino", "Libras a Peso Argentino", "Yen a Peso Argentino", 
				"Won a Peso Argentino"};
		
		String[] tiposTemperaturas= {"Celsius a Farenheit", "Celsius a Kelvin", "Kelvin a Celsius",
				"Farenheit a Celsius", "Farenheit a Kelvin", "Kelvin a Farenheit"};
		
		JLabel lblNewLabel = new JLabel("Seleccione una opción de conversión:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 77, 239, 24);
		frmConversor.getContentPane().add(lblNewLabel);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(tiposCambios);
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(10, 137, 239, 24);
		frmConversor.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el valor que desea convertir:");
		lblNewLabel_1.setBounds(10, 11, 239, 24);
		frmConversor.getContentPane().add(lblNewLabel_1);
		
		txtIngreseElValor = new JTextField();
		txtIngreseElValor.setToolTipText("Ingrese un valor decimal. Ej: 122.54");
		txtIngreseElValor.setBounds(10, 46, 239, 20);
		frmConversor.getContentPane().add(txtIngreseElValor);
		txtIngreseElValor.setColumns(10);
		
		JRadioButton rdbtnMonedas = new JRadioButton("Monedas");
		rdbtnMonedas.setSelected(true);
		rdbtnMonedas.setBounds(10, 107, 109, 23);
		frmConversor.getContentPane().add(rdbtnMonedas);
		
		rdbtnMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setModel(new DefaultComboBoxModel<Object>(tiposCambios));
			}
		});
		
		JRadioButton rdbtnTemperatura = new JRadioButton("Temperatura");
		rdbtnTemperatura.setBounds(140, 107, 109, 23);
		frmConversor.getContentPane().add(rdbtnTemperatura);
		
		rdbtnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setModel(new DefaultComboBoxModel<Object>(tiposTemperaturas));
			}
		});
		
		ButtonGroup bg=new ButtonGroup();  
		bg.add(rdbtnMonedas);
		bg.add(rdbtnTemperatura);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				String tipo = (String) comboBox.getSelectedItem();
				String texto = txtIngreseElValor.getText();
				
				if(rdbtnMonedas.isSelected()) convertirMoneda (index, texto);
				else convertirTemperatura(tipo, texto);
			}
		});
		btnNewButton.setBounds(160, 172, 89, 23);
		frmConversor.getContentPane().add(btnNewButton);
	}
	
	public void convertirMoneda(int index, String texto) {
		try {
			double valor = Double.parseDouble(texto);
			valor = Conversor.convertir(index, valor);
			JOptionPane.showMessageDialog(null, "Valor convertido " + 
					valor,"Conversor",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception NumberFormatException) {
			JOptionPane.showMessageDialog(null, "El formato ingresado no es correcto.",
					"Error en los datos",JOptionPane.ERROR_MESSAGE);
		}
		continuar();
		
	}
	
	public void convertirTemperatura(String tipo, String valor) {
		try {
			double temperatura = Double.parseDouble(valor);
			temperatura = Conversor.convertirTemperatura(tipo, temperatura);
			
			JOptionPane.showMessageDialog(null, "Valor convertido " + 
					temperatura,"Conversor",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception NumberFormatException) {
			JOptionPane.showMessageDialog(null, "El formato ingresado no es correcto.",
					"Error en los datos",JOptionPane.ERROR_MESSAGE);
		}
		continuar();
		
	}
	
	
	public void continuar() {
		int opcion = JOptionPane.showConfirmDialog(null,"Desea continuar?", 
				"Conversor", JOptionPane.YES_NO_OPTION);
		
		if (opcion == 1) {
			JOptionPane.showMessageDialog(null, "Programa Finalizado", "Conversor",
					JOptionPane.INFORMATION_MESSAGE);
			frmConversor.dispose();
		}
	}
	
}
