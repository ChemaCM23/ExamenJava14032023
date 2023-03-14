package views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ControladorCentroeducativo;
import controllers.ControladorMateria;
import models.Centroeducativo;
import models.Materia;
import models.Nivel;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class VentanaGestionCurso extends JPanel {
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JComboBox<Centroeducativo> jcbcentro;
	private JComboBox<Nivel> jcbnivel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField jtfcodigo;
	private JButton btnNewButton_2;
	private String TITULO_APLICACION = "Titulo de la aplicacion";
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_5;
	private JComboBox<Materia> jcbmateria;
	private JLabel lblNewLabel_4;
	private JTextField jtfnombre;
	private JTextField jtfid;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField jtfurl;
	private JLabel lblNewLabel_8;
	private JTextField jtffecha;
	private JLabel lblNewLabel_9;
	private JCheckBox jchmatricula;
	private JButton btnNewButton_6;

	/**
	 * Create the frame.
	 */
	public VentanaGestionCurso() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("Gestión de Materias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblNewLabel_1 = new JLabel("Centro:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbcentro = new JComboBox<Centroeducativo>();
		GridBagConstraints gbc_jcbcentro = new GridBagConstraints();
		gbc_jcbcentro.insets = new Insets(0, 0, 5, 5);
		gbc_jcbcentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbcentro.gridx = 1;
		gbc_jcbcentro.gridy = 1;
		add(jcbcentro, gbc_jcbcentro);

		btnNewButton = new JButton("Cargar niveles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarmaterias();

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		lblNewLabel = new JLabel("Nivel:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbnivel = new JComboBox<Nivel>();
		GridBagConstraints gbc_jcbnivel = new GridBagConstraints();
		gbc_jcbnivel.insets = new Insets(0, 0, 5, 5);
		gbc_jcbnivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbnivel.gridx = 1;
		gbc_jcbnivel.gridy = 2;
		add(jcbnivel, gbc_jcbnivel);

		btnNewButton_1 = new JButton("Cargar niveles");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaACampos();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);

		lblNewLabel_3 = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbmateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbmateria = new GridBagConstraints();
		gbc_jcbmateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbmateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbmateria.gridx = 1;
		gbc_jcbmateria.gridy = 3;
		add(jcbmateria, gbc_jcbmateria);

		btnNewButton_5 = new JButton("Ver materia");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 3;
		add(btnNewButton_5, gbc_btnNewButton_5);

		lblNewLabel_4 = new JLabel("Cargar materias");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfid = new JTextField();
		jtfid.setEnabled(false);
		GridBagConstraints gbc_jtfid = new GridBagConstraints();
		gbc_jtfid.gridwidth = 2;
		gbc_jtfid.insets = new Insets(0, 0, 5, 0);
		gbc_jtfid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfid.gridx = 1;
		gbc_jtfid.gridy = 5;
		add(jtfid, gbc_jtfid);
		jtfid.setColumns(10);

		lblNewLabel_6 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfnombre = new JTextField();
		GridBagConstraints gbc_jtfnombre = new GridBagConstraints();
		gbc_jtfnombre.gridwidth = 2;
		gbc_jtfnombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfnombre.gridx = 1;
		gbc_jtfnombre.gridy = 6;
		add(jtfnombre, gbc_jtfnombre);
		jtfnombre.setColumns(10);

		lblNewLabel_7 = new JLabel("Codigo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfcodigo = new JTextField();
		GridBagConstraints gbc_jtfcodigo = new GridBagConstraints();
		gbc_jtfcodigo.gridwidth = 2;
		gbc_jtfcodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfcodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfcodigo.gridx = 1;
		gbc_jtfcodigo.gridy = 7;
		add(jtfcodigo, gbc_jtfcodigo);
		jtfcodigo.setColumns(10);

		lblNewLabel_8 = new JLabel("URL Classroom:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfurl = new JTextField();
		GridBagConstraints gbc_jtfurl = new GridBagConstraints();
		gbc_jtfurl.gridwidth = 2;
		gbc_jtfurl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfurl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfurl.gridx = 1;
		gbc_jtfurl.gridy = 8;
		add(jtfurl, gbc_jtfurl);
		jtfurl.setColumns(10);

		lblNewLabel_9 = new JLabel("Fecha inicio:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtffecha = new JTextField();
		GridBagConstraints gbc_jtffecha = new GridBagConstraints();
		gbc_jtffecha.gridwidth = 2;
		gbc_jtffecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtffecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtffecha.gridx = 1;
		gbc_jtffecha.gridy = 9;
		add(jtffecha, gbc_jtffecha);
		jtffecha.setColumns(10);

		jchmatricula = new JCheckBox("Admite matrícula");
		jchmatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_jchmatricula = new GridBagConstraints();
		gbc_jchmatricula.anchor = GridBagConstraints.WEST;
		gbc_jchmatricula.insets = new Insets(0, 0, 5, 5);
		gbc_jchmatricula.gridx = 1;
		gbc_jchmatricula.gridy = 10;
		add(jchmatricula, gbc_jchmatricula);

		btnNewButton_6 = new JButton("Guardar");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 11;
		add(btnNewButton_6, gbc_btnNewButton_6);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 12;
		add(btnNewButton_2, gbc_btnNewButton_2);

		llenarJcb();

	}

	public boolean esURL(String url) {
		Pattern patron = Pattern
				.compile("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}");

		Matcher comparar = patron.matcher(url);
		return comparar.find();
	}

	private void llenarJcb() {
		List<Centroeducativo> lc = ControladorCentroeducativo.findAll();
		for (Centroeducativo curso : lc) {
			jcbcentro.addItem(curso);
		}
	}

	private void cargarmaterias() {
		Centroeducativo c = (Centroeducativo) jcbcentro.getSelectedItem();
		List<Materia> lc = ControladorMateria.cargarMaterias(c.getId());

		try {
			jcbnivel.removeAllItems();
		} catch (Exception e) {
		}

		for (Materia materia : lc) {
			jcbnivel.setSelectedItem(materia);
		}

	}

	private void listaACampos() {
		Materia m = (Materia) jcbnivel.getSelectedItem();
		jtfnombre.setText(m.getNombre());
		m.setId(Integer.parseInt(this.jtfid.getText()));

	}

}
