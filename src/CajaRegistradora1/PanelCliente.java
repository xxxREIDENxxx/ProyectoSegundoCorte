package CajaRegistradora1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelCliente extends JPanel implements ActionListener{

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
	
	ArrayList<Cliente> clientes;
	
	VentanaPrincipal ventana;
	
	public PanelCliente(VentanaPrincipal v) {
		clientes = new ArrayList<>();
		this.ventana = v;
		configuracion();
		componentes();
		actualizarTabla();
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
		
		add(tApellido);
		
		jlCedula = new JLabel("Cedula:");
		jlCedula.setFont(fuente);
		jlCedula.setBounds(jlApellido.getX(), jlApellido.getY()+jlApellido.getHeight()+sep, 100, heigh);
		add(jlCedula);
		
		tCedula = new JTextField();
		tCedula.setFont(fuente);
		tCedula.setBounds(jlCedula.getX()+jlCedula.getWidth(), jlCedula.getY(), 150, heigh);
		tCedula.addKeyListener(new soloNumeros());
		add(tCedula);
		
		jlEdad = new JLabel("Edad:");
		jlEdad.setFont(fuente);
		jlEdad.setBounds(jlCedula.getX(), jlCedula.getY()+jlCedula.getHeight()+sep, 100, heigh);
		add(jlEdad);
		
		tEdad = new JTextField();
		tEdad.setFont(fuente);
		tEdad.setBounds(jlEdad.getX()+jlEdad.getWidth(), jlEdad.getY(), 150, heigh);
		tEdad.addKeyListener(new soloNumeros());
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
		tSueldo.addKeyListener(new soloNumeros());
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
		
		tabla = new JTable();
		tabla.setAutoCreateRowSorter(true);
		
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(320, 20, 480, 250);
		
		add(scroll);
		
		tabla2 = new JTable();
		tabla2.setAutoCreateRowSorter(true);
		
		JScrollPane scroll2 = new JScrollPane(tabla2);
		scroll2.setBounds(scroll.getX(), scroll.getY()+scroll.getHeight()+sep, 480, 180);
		
		add(scroll2);
		
		
	}

	public void actualizarTabla(){
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Edad");
		modelo.addColumn("Cedula");
		modelo.addColumn("Empresa");
		modelo.addColumn("Sueldo");
		
		modelo2 = new DefaultTableModel();
		modelo2.addColumn("Nombre");
		modelo2.addColumn("Apellido");
		modelo2.addColumn("Edad");
		modelo2.addColumn("Cedula");
		modelo2.addColumn("Empresa");
		modelo2.addColumn("Sueldo");
		
		tabla2.setModel(modelo2);
		tabla.setModel(modelo);
		
		Collections.sort(clientes, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente p1, Cliente p2) {
				return new Float(p2.getSueldo()).compareTo(p1.getSueldo());
			}
		});
		
		for(int i = 0; i < clientes.size(); i++){
			Object m[] = {clientes.get(i).getNombre(), 
					clientes.get(i).getApellido(), 
					clientes.get(i).getEdad(), 
					clientes.get(i).getCedula(), 
					clientes.get(i).getEmpresa(), 
					clientes.get(i).getSueldo()};
			
			if(i > 2){
				modelo.addRow(m);
			}
			else{
				modelo.addRow(m);
				modelo2.addRow(m);
			}
			
		}
	}
	
	class soloNumeros extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent tecla) {
            if(tecla.getKeyChar() < '0' || tecla.getKeyChar() > '9' && tecla.getKeyChar() > 31){
                tecla.consume();
            }
        } 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar){
			if(validarDatos()){
				String nombre = tNombre.getText().trim();
				String apellido = tApellido.getText().trim();
				int cedula = Integer.parseInt(tCedula.getText().trim());
				int edad = Integer.parseInt(tEdad.getText().trim());
				String empresa = tEmpresa.getText().trim();
				float sueldo = Float.parseFloat(tSueldo.getText().trim());
				
				Cliente c = new Cliente(nombre, apellido, edad, cedula, empresa, sueldo);
				System.out.println("Agrego");
				clientes.add(c);
				actualizarTabla();
				ventana.panelPrincipal.panelCompra.actualizarClientes();
			}
		}
		
	}
	
	public boolean validarDatos(){
		//&& tApellido.getText().trim() == ""&& tCedula.getText().trim() == "" && tEdad.getText().trim() == "" && tEmpresa.getText().trim() == "" && tSueldo.getText().trim() == ""
		if(tNombre.getText().trim().equals("") || tApellido.getText().trim().equals("")|| tCedula.getText().trim().equals("")|| tEdad.getText().trim().equals("")|| tEmpresa.getText().trim().equals("")|| tSueldo.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "Llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

}
