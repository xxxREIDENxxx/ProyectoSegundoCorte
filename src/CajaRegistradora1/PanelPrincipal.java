package CajaRegistradora1;

import javax.swing.JTabbedPane;

public class PanelPrincipal extends JTabbedPane{

	PanelProducto panelProducto;
	
	PanelCliente panelCliente;
	
	PanelCompra panelCompra;
	
	VentanaPrincipal ventana;
	
	public PanelPrincipal(VentanaPrincipal v) {
		this.ventana = v;
		configuracion();
		componentes();
		setVisible(true);
	}
	
	public void configuracion(){
		
	}
	
	public void componentes(){
		panelProducto = new PanelProducto(ventana);
		panelCliente = new PanelCliente(ventana);
		panelCompra = new PanelCompra(ventana);
		
		add(panelProducto, "Producto");
		add(panelCliente, "Cliente");
		add(panelCompra, "Comprar");
		
	}
}
