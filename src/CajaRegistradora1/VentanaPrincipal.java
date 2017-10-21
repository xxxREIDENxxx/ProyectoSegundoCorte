package CajaRegistradora1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.TreeMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame{
	
	PanelPrincipal panelPrincipal;
	
	public VentanaPrincipal() {
			super("Mi ventana principal");
			inicio();
			componentes();
	        setLocationRelativeTo( null );
	}
	
	private void inicio(){
		Dimension dims = new Dimension(1000, 600);
		this.setSize(dims);
		setResizable(false);
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void componentes() {
		panelPrincipal = new PanelPrincipal(this);
		panelPrincipal.setBounds(0, 0, 1000, 500);
		add(panelPrincipal);
	}

}
