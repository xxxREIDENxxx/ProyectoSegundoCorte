package CajaRegistradora1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.TreeMap;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	public TreeMap listPersona;
	public TreeMap listProductos;
	
	public VentanaPrincipal() {
			super("Mi ventana principal");
			listPersona = new TreeMap();
			listProductos = new TreeMap();
			inicio();
			
			pack();
	        setLocationRelativeTo( null );
	}
	
	public void  agregarPersona(String _nombre, String _apellido,int _edad,int _cedula,String _empresa, float _sueldo) {
		Clientes obj = new Clientes(_nombre,_apellido,_edad,_cedula,_empresa,_sueldo);
		listPersona.put(_cedula,obj);
		//actualizarTabla();
	}
	private VentanaPrincipal inicio(){
		Dimension dims = new Dimension(800, 700);
		this.setSize(dims);
		this.setPreferredSize(dims);
		this.getContentPane( ).setLayout( new BorderLayout( ) );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return this;
	}
	

}
