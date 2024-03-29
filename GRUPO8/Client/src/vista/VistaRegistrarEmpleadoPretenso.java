package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VistaRegistrarEmpleadoPretenso extends JPanel implements IVistaRegistrarEmpleadoPretenso, KeyListener {
	private JPanel panel_Centro;
	private JPanel panel_Sur;
	private JPanel panel_DatosEmpleado_Border;
	private JPanel panel_DatosEmpleadoPretenso;
	private JLabel lbl_Nya;
	private JTextField textField_Nya;
	private JLabel lbl_Telefono;
	private JTextField textField_Telefono;
	private JLabel lbl_Edad;
	private JTextField textField_Edad;
	private JPanel panel_lbl_Nya;
	private JPanel panel_textField_Nya;
	private JPanel panel_lbl_Telefono;
	private JPanel panel_textField_Telefono;
	private JPanel panel_lbl_Edad;
	private JPanel panel_texField_Edad;
	private JPanel panel_UsuarioContrasena_Border;
	private JPanel panel_UsuarioContrasena;
	private JLabel lbl_Usuario;
	private JTextField textField_Usuario;
	private JLabel lbl_Contrasena;
	private JTextField textField_Contrasena;
	private JPanel panel_lbl_Usuario;
	private JPanel panel_textField_Usuario;
	private JPanel panel_lbl_Contrasena;
	private JPanel panel_textField_Contrasena;
	private JButton btn_Volver;
	private JButton btn_Registrar;
	private JPanel panel_Volver;
	private JPanel panel_Registrar;

	/**
	 * Create the panel.
	 */
	public VistaRegistrarEmpleadoPretenso() {
		setLayout(new BorderLayout(0, 0));
		
		this.panel_Centro = new JPanel();
		add(this.panel_Centro, BorderLayout.CENTER);
		this.panel_Centro.setLayout(new BorderLayout(0, 0));
		
		this.panel_DatosEmpleado_Border = new JPanel();
		this.panel_Centro.add(this.panel_DatosEmpleado_Border, BorderLayout.NORTH);
		
		this.panel_DatosEmpleadoPretenso = new JPanel();
		this.panel_DatosEmpleadoPretenso.setBorder(new TitledBorder(null, "Datos empleado pretenso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_DatosEmpleado_Border.add(this.panel_DatosEmpleadoPretenso);
		this.panel_DatosEmpleadoPretenso.setLayout(new GridLayout(3, 2, 0, 0));
		
		this.panel_lbl_Nya = new JPanel();
		this.panel_DatosEmpleadoPretenso.add(this.panel_lbl_Nya);
		
		this.lbl_Nya = new JLabel("Nombre y apellido");
		this.panel_lbl_Nya.add(this.lbl_Nya);
		
		this.panel_textField_Nya = new JPanel();
		this.panel_DatosEmpleadoPretenso.add(this.panel_textField_Nya);
		
		this.textField_Nya = new JTextField();
		this.textField_Nya.addKeyListener(this);
		this.panel_textField_Nya.add(this.textField_Nya);
		this.textField_Nya.setColumns(10);
		
		this.panel_lbl_Telefono = new JPanel();
		this.panel_DatosEmpleadoPretenso.add(this.panel_lbl_Telefono);
		
		this.lbl_Telefono = new JLabel("Telefono");
		this.panel_lbl_Telefono.add(this.lbl_Telefono);
		
		this.panel_textField_Telefono = new JPanel();
		this.panel_DatosEmpleadoPretenso.add(this.panel_textField_Telefono);
		
		this.textField_Telefono = new JTextField();
		this.textField_Telefono.addKeyListener(this);
		this.panel_textField_Telefono.add(this.textField_Telefono);
		this.textField_Telefono.setColumns(10);
		
		this.panel_lbl_Edad = new JPanel();
		this.panel_DatosEmpleadoPretenso.add(this.panel_lbl_Edad);
		
		this.lbl_Edad = new JLabel("Edad");
		this.panel_lbl_Edad.add(this.lbl_Edad);
		
		this.panel_texField_Edad = new JPanel();
		this.panel_DatosEmpleadoPretenso.add(this.panel_texField_Edad);
		
		this.textField_Edad = new JTextField();
		this.textField_Edad.addKeyListener(this);
		this.panel_texField_Edad.add(this.textField_Edad);
		this.textField_Edad.setColumns(10);
		
		this.panel_UsuarioContrasena_Border = new JPanel();
		this.panel_UsuarioContrasena_Border.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_Centro.add(this.panel_UsuarioContrasena_Border, BorderLayout.SOUTH);
		
		this.panel_UsuarioContrasena = new JPanel();
		this.panel_UsuarioContrasena_Border.add(this.panel_UsuarioContrasena);
		this.panel_UsuarioContrasena.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_lbl_Usuario = new JPanel();
		this.panel_UsuarioContrasena.add(this.panel_lbl_Usuario);
		
		this.lbl_Usuario = new JLabel("Usuario");
		this.panel_lbl_Usuario.add(this.lbl_Usuario);
		
		this.panel_textField_Usuario = new JPanel();
		this.panel_UsuarioContrasena.add(this.panel_textField_Usuario);
		
		this.textField_Usuario = new JTextField();
		this.textField_Usuario.addKeyListener(this);
		this.panel_textField_Usuario.add(this.textField_Usuario);
		this.textField_Usuario.setColumns(10);
		
		this.panel_lbl_Contrasena = new JPanel();
		this.panel_UsuarioContrasena.add(this.panel_lbl_Contrasena);
		
		this.lbl_Contrasena = new JLabel("Contrase\u00F1a");
		this.panel_lbl_Contrasena.add(this.lbl_Contrasena);
		
		this.panel_textField_Contrasena = new JPanel();
		this.panel_UsuarioContrasena.add(this.panel_textField_Contrasena);
		
		this.textField_Contrasena = new JTextField();
		this.textField_Contrasena.addKeyListener(this);
		this.panel_textField_Contrasena.add(this.textField_Contrasena);
		this.textField_Contrasena.setColumns(10);
		
		this.panel_Sur = new JPanel();
		add(this.panel_Sur, BorderLayout.SOUTH);
		this.panel_Sur.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panel_Volver = new JPanel();
		this.panel_Sur.add(this.panel_Volver);
		
		this.btn_Volver = new JButton("Volver");
		this.panel_Volver.add(this.btn_Volver);
		
		this.panel_Registrar = new JPanel();
		this.panel_Sur.add(this.panel_Registrar);
		
		this.btn_Registrar = new JButton("Registrar");
		this.btn_Registrar.setEnabled(false);
		this.panel_Registrar.add(this.btn_Registrar);

	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btn_Registrar.addActionListener(actionListener);
		this.btn_Volver.addActionListener(actionListener);
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		int edad = 0;
		long telefono = 0;
		
		try {
			edad = Integer.parseInt(this.textField_Edad.getText());			
		}
		catch(NumberFormatException exception) {
		}
		
		try {
			telefono = Long.parseLong(this.textField_Telefono.getText());		
		}
		catch(NumberFormatException exception) {
		}
		
		if(this.textField_Contrasena.getText().length() != 0
				&& this.textField_Edad.getText().length() != 0
				&& this.textField_Nya.getText().length() != 0
				&& this.textField_Telefono.getText().length() != 0
				&& this.textField_Usuario.getText().length() != 0
				&& 16<edad 
				&& telefono != 0) {
			this.btn_Registrar.setEnabled(true);
		}
		else
			this.btn_Registrar.setEnabled(false);
	}
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public String getNya()
	{
		return this.textField_Nya.getText();
	}

	@Override
	public String getTelefono()
	{
		return this.textField_Telefono.getText();
	}

	@Override
	public int getEdad()
	{
		return Integer.parseInt(this.textField_Edad.getText());
	}

	@Override
	public String getUsuario()
	{
		return this.textField_Usuario.getText();
	}

	@Override
	public String getContrasena()
	{
		return this.textField_Contrasena.getText();
	}

	@Override
	public void limpiarVentana()
	{
		this.textField_Nya.setText("");
		this.textField_Telefono.setText("");
		this.textField_Edad.setText("");
		this.textField_Usuario.setText("");
		this.textField_Contrasena.setText("");
		
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	
}
