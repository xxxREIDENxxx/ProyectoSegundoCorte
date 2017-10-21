package CajaRegistradora1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelCliente extends JPanel implements ActionListener, KeyListener{

	JLabel jlNombre;
	JLabel jlApellido;
	JLabel jlCedula;
	JLabel jlEdad;
	JLabel jlEmpresa;
	JLabel jlSueldo;
	JLabel jlFoto;
	
	JTextField tNombre;
	JTextField tApellido;
	JTextField tCedula;
	JTextField tEdad;
	JTextField tEmpresa;
	JTextField tSueldo;
	JFileChooser fcFoto;
	
	JButton btnAgregar;
	
	DefaultTableModel modelo;
	DefaultTableModel modelo2;
	JTable tabla;
	JTable tabla2;
	
	VentanaPrincipal ventana;
	
	public PanelCliente(VentanaPrincipal v) {
		this.ventana = v;
		configuracion();
		componentes();
	}
	
	public void configuracion(){
		setLayout(null);
		setBackground(Color.WHITE);
	}
	
	public void componentes(){
		Font fuente = new Font("Arial", Font.PLAIN, 15);
		int sep = 10;
		int heigh = 30;
		
		jlNombre = new JLabel("Nombre:");
		jlNombre.setFont(fuente);
		jlNombre.setBounds(30, 50, 100, heigh);
		add(jlNombre);
		
		tNombre = new JTextField();
		tNombre.setBounds(jlNombre.getX()+jlNombre.getWidth(), jlNombre.getY(), 150, heigh);
		tNombre.setFont(fuente);
		add(tNombre);
		
		jlApellido = new JLabel("Apellido:");
		jlApellido.setFont(fuente);
		jlApellido.setBounds(jlNombre.getX(), jlNombre.getY()+jlNombre.getHeight()+sep, 100, heigh);
		add(jlApellido);
		
		tApellido = new JTextField();
		tApellido.setFont(fuente);
		tApellido.setBounds(jlApellido.getX()+jlApellido.getWidth(), jlApellido.getY(), 150, heigh);
		tApellido.addKeyListener(this);
		add(tApellido);
		
		jlCedula = new JLabel("Cedula:");
		jlCedula.setFont(fuente);
		jlCedula.setBounds(jlApellido.getX(), jlApellido.getY()+jlApellido.getHeight()+sep, 100, heigh);
		add(jlCedula);
		
		tCedula = new JTextField();
		tCedula.setFont(fuente);
		tCedula.setBounds(jlCedula.getX()+jlCedula.getWidth(), jlCedula.getY(), 150, heigh);
		tCedula.addKeyListener(this);
		add(tCedula);
		
		jlEdad = new JLabel("Edad:");
		jlEdad.setFont(fuente);
		jlEdad.setBounds(jlCedula.getX(), jlCedula.getY()+jlCedula.getHeight()+sep, 100, heigh);
		add(jlEdad);
		
		tEdad = new JTextField();
		tEdad.setFont(fuente);
		tEdad.setBounds(jlEdad.getX()+jlEdad.getWidth(), jlEdad.getY(), 150, heigh);
		//sEdad.addKeyListener(this);
		add(tEdad);
		
		jlEmpresa = new JLabel("Empresa:");
		jlEmpresa.setFont(fuente);
		jlEmpresa.setBounds(jlEdad.getX(), jlEdad.getY()+jlEdad.getHeight()+sep, 100, heigh);
		add(jlEmpresa);
		
		tEmpresa = new JTextField();
		tEmpresa.setFont(fuente);
		tEmpresa.setBounds(jlEmpresa.getX()+jlEmpresa.getWidth(), jlEmpresa.getY(), 150, heigh);
		add(tEmpresa);
		
		jlSueldo = new JLabel("Sueldo:");
		jlSueldo.setFont(fuente);
		jlSueldo.setBounds(jlEmpresa.getX(), jlEmpresa.getY()+jlEmpresa.getHeight()+sep, 100, heigh);
		add(jlSueldo);
		
		tSueldo = new JTextField();
		tSueldo.setFont(fuente);
		tSueldo.setBounds(jlSueldo.getX()+jlSueldo.getWidth(), jlSueldo.getY(), 150, heigh);
		add(tSueldo);
		
		jlFoto = new JLabel("Foto:");
		jlFoto.setFont(fuente);
		jlFoto.setBounds(jlSueldo.getX(), jlSueldo.getY()+jlSueldo.getHeight()+sep, 100, heigh);
		add(jlFoto);
		
		fcFoto = new JFileChooser();
		fcFoto.setFont(fuente);
		fcFoto.setBounds(jlFoto.getX()+jlFoto.getWidth(), jlFoto.getY(), 150, heigh);
		//add(fcFoto);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(fuente);
		btnAgregar.setBounds(jlFoto.getX(), jlFoto.getY()+jlFoto.getHeight()+sep, 150, heigh);
		btnAgregar.addActionListener(this);
		add(btnAgregar);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
