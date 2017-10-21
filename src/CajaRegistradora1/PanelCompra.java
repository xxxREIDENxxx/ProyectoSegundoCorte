package CajaRegistradora1;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CajaRegistradora1.PanelCliente.soloNumeros;

public class PanelCompra extends JPanel{

	JLabel jlUsuario;
	JLabel jlProducto;
	JLabel jlCantidad;
	
	JComboBox cbCliente;
	JComboBox cbProducto;
	JTextField tCantidad;
	
	JButton btnAgregar;
	JButton btnComprar;
	
	VentanaPrincipal ventana;
	
	public PanelCompra(VentanaPrincipal v) {
		this.ventana =v;
		configurar();
		componentes();
	}

	public void configurar(){
		setLayout(null);
	}
	
	public void componentes(){
		Font fuente = new Font("Arial", Font.PLAIN, 15);
		int sep = 10;
		int heigh = 30;
		
		jlUsuario = new JLabel("Usuario:");
		jlUsuario.setFont(fuente);
		jlUsuario.setBounds(30, 50, 100, heigh);
		add(jlUsuario);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(jlUsuario.getX()+jlUsuario.getWidth(), jlUsuario.getY(), 150, heigh);
		cbCliente.setFont(fuente);
		add(cbCliente);
		actualizarClientes();
		
		jlProducto = new JLabel("Producto:");
		jlProducto.setFont(fuente);
		jlProducto.setBounds(jlUsuario.getX(), jlUsuario.getY()+jlUsuario.getHeight()+sep, 100, heigh);
		add(jlProducto);
		
		cbProducto = new JComboBox();
		cbProducto.setFont(fuente);
		cbProducto.setBounds(jlProducto.getX()+jlProducto.getWidth(), jlProducto.getY(), 150, heigh);
		add(cbProducto);
		
		jlCantidad = new JLabel("Cantidad:");
		jlCantidad.setFont(fuente);
		jlCantidad.setBounds(jlProducto.getX(), jlProducto.getY()+jlProducto.getHeight()+sep, 100, heigh);
		add(jlCantidad);
		
		tCantidad = new JTextField();
		tCantidad.setFont(fuente);
		tCantidad.setBounds(jlCantidad.getX()+jlCantidad.getWidth(), jlCantidad.getY(), 150, heigh);
		tCantidad.addKeyListener(new soloNumeros());
		add(tCantidad);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(fuente);
		btnAgregar.setBounds(jlCantidad.getX(), jlCantidad.getY()+jlCantidad.getHeight()+sep, 100, heigh);
		add(btnAgregar);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setFont(fuente);
		btnComprar.setBounds(btnAgregar.getX()+btnAgregar.getWidth()+sep, btnAgregar.getY(), 100, heigh);
		add(btnComprar);
	}
	
	public void actualizarClientes(){
		try{
			ArrayList<Cliente> clientes = new ArrayList<>();
			clientes = ventana.panelPrincipal.panelCliente.clientes;
			cbCliente.removeAllItems();
			for(int i = 0; i < clientes.size(); i++){
				cbCliente.addItem(clientes.get(i).getCedula()+", "+clientes.get(i).getNombre());
			}
		}catch(Exception e){
			
		}
		
	}
	
	public void actualizarProductos(){
		try{
			ArrayList<Producto> productos = new ArrayList<>();
			productos = ventana.panelPrincipal.panelProducto.productos;
			cbProducto.removeAllItems();
			for(int i = 0; i < productos.size(); i++){
				cbProducto.addItem(productos.get(i).getProducto()+", "+productos.get(i).getMarca());
			}
		}catch(Exception e){
			
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
