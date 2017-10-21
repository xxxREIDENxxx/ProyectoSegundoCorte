package CajaRegistradora1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class PanelProducto extends JPanel implements ActionListener{

	JLabel jlNombre;
	JLabel jlCantidad;
	JLabel jlMarca;
	JLabel jlPeso;
	JLabel jlValor;
	
	JComboBox cbNombre;
	JTextField tCantidad;
	JComboBox cbMarca;
	JTextField tPeso;
	JTextField tValor;
	
	JButton btnAgregar;
	
	DefaultTableModel modelo;
	DefaultTableModel modelo2;
	JTable tabla;
	JTable tabla2;
	
	ArrayList<Producto> productos;
	
	VentanaPrincipal ventanaPrincipal;
	
	public PanelProducto(VentanaPrincipal v){
		this.ventanaPrincipal = v;
		configuracion();
		componentes();
		actualizarTabla();
	}

	public void configuracion(){
		setLayout(null);
		setBackground(Color.white);
		//setBackground(Color.CYAN);
	}
	
	public void componentes(){
		Font fuente = new Font("Arial", Font.PLAIN, 15);
		int sep = 10;
		int heigh = 30;
		
		jlNombre = new JLabel("Nombre:");
		jlNombre.setFont(fuente);
		jlNombre.setBounds(30, 50, 100, heigh);
		add(jlNombre);
		
		cbNombre = new JComboBox();
		cbNombre.setFont(fuente);
		cbNombre.addItem("Seleccione");
		cbNombre.addItem("Televisor");
		cbNombre.addItem("Lavadora");
		cbNombre.addItem("Nevera");
		cbNombre.addItem("Computador");
		cbNombre.setBounds(jlNombre.getX()+jlNombre.getWidth(), jlNombre.getY(), 150, heigh);
		cbNombre.addActionListener(this);
		add(cbNombre);
		
		jlCantidad = new JLabel("Cantidad:");
		jlCantidad.setFont(fuente);
		jlCantidad.setBounds(jlNombre.getX(), jlNombre.getY()+jlNombre.getHeight()+sep, 100, heigh);
		add(jlCantidad);
		
		tCantidad = new JTextField();
		tCantidad.setFont(fuente);
		tCantidad.setBounds(jlCantidad.getX()+jlCantidad.getWidth(), jlCantidad.getY(), 150, heigh);
		tCantidad.addKeyListener(new soloNumeros());
		add(tCantidad);
		
		jlMarca = new JLabel("Marca:");
		jlMarca.setFont(fuente);
		jlMarca.setBounds(jlCantidad.getX(), jlCantidad.getY()+jlCantidad.getHeight()+sep, 100, heigh);
		add(jlMarca);
		
		cbMarca = new JComboBox();
		cbMarca.addItem("Seleccione");
		cbMarca.addItem("LG");
		cbMarca.setFont(fuente);
		cbMarca.setBounds(jlMarca.getX()+jlMarca.getWidth(), jlMarca.getY(), 150, heigh);
		cbMarca.setEnabled(false);
		add(cbMarca);
		
		jlPeso = new JLabel("Peso:");
		jlPeso.setFont(fuente);
		jlPeso.setBounds(jlMarca.getX(), jlMarca.getY()+jlMarca.getHeight()+sep, 100, heigh);
		add(jlPeso);
		
		tPeso = new JTextField();
		tPeso.setFont(fuente);
		tPeso.setBounds(jlPeso.getX()+jlPeso.getWidth(), jlPeso.getY(), 150, heigh);
		tPeso.addKeyListener(new soloNumeros());
		add(tPeso);
		
		jlValor = new JLabel("V. Unidad:");
		jlValor.setFont(fuente);
		jlValor.setBounds(jlPeso.getX(), jlPeso.getY()+jlPeso.getHeight()+sep, 100, heigh);
		add(jlValor);
		
		tValor = new JTextField();
		tValor.setFont(fuente);
		tValor.setBounds(jlValor.getX()+jlValor.getWidth(), jlValor.getY(), 150, heigh);
		tValor.addKeyListener(new soloNumeros());
		add(tValor);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(fuente);
		btnAgregar.setBounds(jlValor.getX(), jlValor.getY()+jlValor.getHeight()+sep, 150, heigh);
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
		
		productos = new ArrayList<>();
	}
	
	public void actualizarTabla(){
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Marca");
		modelo.addColumn("Peso");
		modelo.addColumn("V. Unitario");
		
		modelo2 = new DefaultTableModel();
		modelo2.addColumn("Nombre");
		modelo2.addColumn("Cantidad");
		modelo2.addColumn("Marca");
		modelo2.addColumn("Peso");
		modelo2.addColumn("V. Unitario");
		
		tabla2.setModel(modelo2);
		tabla.setModel(modelo);
		
		for(int i = 0; i < productos.size(); i++){
			Object m[] = {productos.get(i).getProducto(), 
						  productos.get(i).getCantidad(), 
						  productos.get(i).getMarca(), 
						  productos.get(i).getPeso(), 
						  productos.get(i).getValorUni()};
			if(productos.get(i).getCantidad() > 10){
				modelo.addRow(m);
			}
			else{
				modelo2.addRow(m);
			}
			
		}
	}
	
	public boolean validarDatos(){
		if(tCantidad.getText().trim().equals("") || tPeso.getText().trim().equals("")|| tValor.getText().trim().equals("") || cbMarca.getSelectedIndex() == 0 || cbNombre.getSelectedIndex() == 0){
			JOptionPane.showMessageDialog(null, "Llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cbNombre){
			if(cbNombre.getSelectedIndex() != 0){
				cbMarca.setEnabled(true);
			}
			else{
				cbMarca.setEnabled(false);
			}
		}
		else if (e.getSource() == btnAgregar){
			if(validarDatos()){
				String nombre = cbNombre.getSelectedItem().toString();
				int cantidad = Integer.parseInt(tCantidad.getText().trim());
				String marca = cbMarca.getSelectedItem().toString();
				float peso = Float.parseFloat(tPeso.getText().trim());
				float valor = Float.parseFloat(tValor.getText().trim());
				
				Producto p = new Producto(nombre, cantidad, marca, peso, valor);
				System.out.println("Agrego");
				productos.add(p);
				actualizarTabla();
				ventanaPrincipal.panelPrincipal.panelCompra.actualizarProductos();
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

}
